package controller;

import java.net.UnknownHostException;
//import java.rmi.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Database {

	private MongoClient mongoClient = null;
	private DB database;
	private DBCollection collection;
	private String databaseName = "atos";
	private String collectionName = "usercollection";

	public Database() {
		try {
			mongoClient = new MongoClient("localhost", 27017);
			database = mongoClient.getDB(databaseName);
			collection = database.getCollection(collectionName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public DB getDatabase() {
		return database;
	}

	public void setDatabase(DB database) {
		this.database = database;
	}

	public DBCollection getCollection() {
		return collection;
	}

	public void setCollection(DBCollection collection) {
		this.collection = collection;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
}