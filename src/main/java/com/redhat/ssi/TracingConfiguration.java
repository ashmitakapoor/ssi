package com.redhat.ssi;

import java.util.Collections;
import java.util.regex.Pattern;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uber.jaeger.metrics.Metrics;
import com.uber.jaeger.metrics.NullStatsReporter;
import com.uber.jaeger.metrics.StatsFactoryImpl;
import com.uber.jaeger.reporters.RemoteReporter;
import com.uber.jaeger.samplers.ProbabilisticSampler;
import com.uber.jaeger.senders.Sender;
import com.uber.jaeger.senders.UdpSender;


import io.opentracing.NoopTracerFactory;
import io.opentracing.Tracer;
import io.opentracing.contrib.spring.web.autoconfig.WebTracingConfiguration;

/**
 * @author Pavol Loffay
 */
@Configuration
public class TracingConfiguration {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TracingConfiguration.class);
    private static final String SERVICE_NAME = "currency";

    @Bean
    public Tracer tracer() {
        String jaegerURL = System.getenv("JAEGER_SERVER_HOSTNAME");
        if (jaegerURL != null) {
            log.info("Using Jaeger tracer");
            return jaegerTracer(jaegerURL);
        }

        log.info("Using Noop tracer");
        return NoopTracerFactory.create();
    }


    private Tracer jaegerTracer(String url) {
        Sender sender = new UdpSender(url, 0, 0);
        return new com.uber.jaeger.Tracer.Builder(SERVICE_NAME,
                new RemoteReporter(sender, 100, 50,
                        new Metrics(new StatsFactoryImpl(new NullStatsReporter()))),
                new ProbabilisticSampler(1.0))
                .build();
    }


    @Bean
    public WebTracingConfiguration webTracingConfiguration() {
        return WebTracingConfiguration.builder()
                .withSkipPattern(Pattern.compile("/api/health"))
                .build();
    }
}
