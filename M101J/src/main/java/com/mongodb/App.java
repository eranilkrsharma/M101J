package com.mongodb;

import org.bson.BsonDocument;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       MongoClientOptions aOptions = MongoClientOptions.builder().build(); 
       //aOptions.getConnectionsPerHost()
       MongoClient aClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
       MongoDatabase db = aClient.getDatabase("myDB");
       MongoCollection<BsonDocument> aColl = db.getCollection("user", BsonDocument.class);
    }
}
