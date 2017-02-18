package com.sat.example.elasticsearch_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Application controller
 *
 */
@RestController
@EnableAutoConfiguration
@ComponentScan("com.sat.example.elasticsearch_java")
public class App {

	@Autowired
	TransportClient client;

	@GetMapping("/")
	String getSomething() throws Exception {
		List<DiscoveryNode> nodes = client.connectedNodes();
		List<String> connectedNodes = new ArrayList<>();
		nodes.forEach(node -> connectedNodes.add(node.getName()));

		return Arrays.toString(connectedNodes.toArray());
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
