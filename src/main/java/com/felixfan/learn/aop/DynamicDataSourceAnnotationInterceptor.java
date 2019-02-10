package com.felixfan.learn.aop;

import com.felixfan.learn.annotation.DataSource;
import com.felixfan.learn.config.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author felix.fan
 * @date 2019/2/9 23:20
 * @description
 */
@Slf4j
public class DynamicDataSourceAnnotationInterceptor implements MethodInterceptor {

    /**
     * 缓存方法注解值
     */
    private static final Map<Method, String> METHOD_CACHE = new HashMap<>();

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            String datasource = determineDatasource(methodInvocation);
            if (! DynamicDataSourceContextHolder.containsDataSource(datasource)) {
                log.info("数据源[{}]不存在，使用默认数据源 >", datasource);
            }
            DynamicDataSourceContextHolder.setDataSourceRouterKey(datasource);
            return methodInvocation.proceed();
        } finally {
            DynamicDataSourceContextHolder.removeDataSourceRouterKey();
        }
    }

    private String determineDatasource(MethodInvocation methodInvocation) {
        Method method = methodInvocation.getMethod();
        if (METHOD_CACHE.containsKey(method)) {
            return METHOD_CACHE.get(method);
        } else {
            DataSource ds = method.isAnnotationPresent(DataSource.class) ? method.getAnnotation(DataSource.class) : AnnotationUtils.findAnnotation(method.getDeclaringClass(), DataSource.class);
            METHOD_CACHE.put(method, ds.value());
            return ds.value();
        }
    }
}
