package com.felixfan.learn.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: ES批量操作初始化
 * @author: felix.fan
 * @date: 2019/1/29 17:07
 */
@Slf4j
public class EsClient {

    @Autowired
    private TransportClient transportClient;

    @Bean("bulkProcessor")
    public BulkProcessor bulkProcessor() {
        log.info("bulkProcessor初始化开始......");
        BulkProcessor.Listener listener = new BulkProcessor.Listener() {
            //bulk提交之前
            @Override
            public void beforeBulk(long executionId, BulkRequest request) {
                int numberOfActions = request.numberOfActions();
                log.info("Executing bulk [{}] with {} requests", executionId, numberOfActions);
            }

            //bulk提交以后
            @Override
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                if (response.hasFailures()) {
                    log.error("Bulk [{}] executed with failures,response = {}", executionId, response.buildFailureMessage());
                } else {
                    log.info("Bulk [{}] completed in {} milliseconds", executionId, response.getTook().getMillis());
                }
            }
            //bulk提交以后并且返回异常
            @Override
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                log.error("Failed to execute bulk", failure);
            }
        };
        BulkProcessor bulkProcessor = BulkProcessor.builder(transportClient, listener)
                // 1000条数据请求执行一次bulk
                .setBulkActions(1000)
                // 5mb的数据刷新一次bulk
                .setBulkSize(new ByteSizeValue(5L, ByteSizeUnit.MB))
                // 并发请求数量, 0不并发, 1并发允许执行
                .setConcurrentRequests(0)
                // 固定5s必须刷新一次
                .setFlushInterval(TimeValue.timeValueSeconds(5L))
                // 重试3次，间隔1s
                .setBackoffPolicy(BackoffPolicy.constantBackoff(TimeValue.timeValueSeconds(1L), 3))
                .build();
        return bulkProcessor;
    }
}