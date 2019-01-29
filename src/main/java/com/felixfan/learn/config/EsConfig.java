package com.felixfan.learn.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: ES配置类
 * @author: felix.fan
 * @date: 2019/1/29 16:46
 */
@Slf4j
@Configuration
public class EsConfig {

    @Bean(name = "transportClient")
    public TransportClient transportClient() {
        log.info("elasticsearch初始化开始......");
        TransportClient transportClient = null;
        try {
            //es集群连接
            TransportAddress node1 = new TransportAddress(InetAddress.getByName("192.168.1.101"), 9300);
            TransportAddress node2 = new TransportAddress(InetAddress.getByName("192.168.1.102"), 9300);
            TransportAddress node3 = new TransportAddress(InetAddress.getByName("192.168.1.103"), 9300);
            //es集群配置（自定义配置） 连接自己安装的集群名称
            Settings settings = Settings.builder()
                    .put("cluster.name", "ESCluster")
                    //增加嗅探机制，找到ES集群  如果报org.elasticsearch.transport.ReceiveTimeoutTransportException: 注释掉 即可
                    .put("client.transport.sniff", true)
                    //增加线程池个数，暂时设为5
                    .put("thread_pool.search.size", "5")
                    .build();
            transportClient = new PreBuiltTransportClient(settings);
            transportClient.addTransportAddress(node1);
            transportClient.addTransportAddress(node2);
            transportClient.addTransportAddress(node3);
        } catch (UnknownHostException e) {
            log.error("初始化es集群连接时出现未知host异常!", e);
        } catch (Exception e) {
            log.error("elasticsearch初始化出现异常!!!", e);
        }
        return transportClient;
    }
}