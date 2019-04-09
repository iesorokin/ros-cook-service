package com.anti.mrg.roscookservice.config

import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import org.zalando.logbook.Logbook
import org.zalando.logbook.httpclient.LogbookHttpRequestInterceptor
import org.zalando.logbook.httpclient.LogbookHttpResponseInterceptor

@Configuration
class RestTemplateConfig(val logbook: Logbook) {

    @Bean
    fun restTemplateRos(restTemplateBuilder: RestTemplateBuilder): RestTemplate {
        return restTemplateBuilder
                .requestFactory { createRequestFactory() }
                .build()
    }

    fun createRequestFactory(): ClientHttpRequestFactory {
        val requestFactory = HttpComponentsClientHttpRequestFactory(createHttpClient())

        requestFactory.setConnectTimeout(10000)
        requestFactory.setConnectionRequestTimeout(10000)
        requestFactory.setReadTimeout(10000)

        return requestFactory
    }

    fun createHttpClient(): HttpClient {
        return HttpClientBuilder.create()
                .addInterceptorFirst(LogbookHttpRequestInterceptor(logbook))
                .addInterceptorLast(LogbookHttpResponseInterceptor())
                .setMaxConnPerRoute(50)
                .setMaxConnTotal(100)
                .build()
    }

}
