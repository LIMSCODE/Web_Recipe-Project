package com.mongo;

import java.util.Arrays;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbManager {

	private static final String IP = "localhost";
	private static final int PORT = 27017;

	private static MongoClient mongoClient = null;

	public MongoDbManager() {

	}

	public static void init() {
		MongoDbManager.mongoClient = MongoClients.create(MongoClientSettings.builder().applyToClusterSettings(
				builder -> builder.hosts(Arrays.asList(new ServerAddress(MongoDbManager.IP, MongoDbManager.PORT))))
				.build());
		System.out.println(MongoDbManager.IP);
		System.out.println(MongoDbManager.PORT);
	}
	

	public static MongoClient getInstance() {
		if (MongoDbManager.mongoClient == null) {
			MongoDbManager.init();
		}
		return MongoDbManager.mongoClient;
	}


}
