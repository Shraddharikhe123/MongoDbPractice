package com.perennialsys.snapshot.appconfig;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.perennialsys.snapshot.configuration.MongoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.text.Document;

@EntityScan(basePackages = "com.perennialsys.snapshot.model")
@ComponentScan(basePackages = "com.perennialsys.snapshot.*")
@SpringBootApplication(scanBasePackages = "com.perennialsys.snapshot")
public class SnapshotApplication {



	public static void main(String[] args) {
		SpringApplication.run(SnapshotApplication.class, args);

	}

}
