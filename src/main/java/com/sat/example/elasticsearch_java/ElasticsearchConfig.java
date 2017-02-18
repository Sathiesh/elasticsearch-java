package com.sat.example.elasticsearch_java;

import java.net.InetSocketAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchConfig {
	/**
	 * Creating the transport client bean
	 * 
	 * @return the transport client bean
	 * @throws Exception
	 */
	@Bean
	TransportClient client() throws Exception {
		Settings settings = Settings.builder()//
				.put("cluster.name", "mycluster")//
				.build();
		TransportClient client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9300)));

		return client;
	}
}
