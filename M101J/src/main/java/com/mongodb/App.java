package com.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
 {
		// MongoClientOptions aOptions = MongoClientOptions.builder().build();
		// aOptions.getConnectionsPerHost()
		@SuppressWarnings("resource")
		MongoClient aClient = new MongoClient(new MongoClientURI(
				"mongodb://localhost:27017"));
		MongoDatabase db = aClient.getDatabase("students");
		MongoCollection<Document> aColl = db.getCollection("grades");
		Bson sort = Sorts.orderBy(Sorts.ascending("student_id"),
				Sorts.ascending("score"));
		List<Document> aStudent = (List<Document>) aColl
				.find(new Document("type", "homework")).sort(sort)
				.into(new ArrayList<Document>());
		System.out.println("Size" + aStudent.size());
		int old_id = 1000;
		for (Document student : aStudent) {
			Integer student_id = (Integer) student.get("student_id");
			if (!(student_id == old_id)) {
				aColl.deleteOne(student);
				System.out.println("OLD Value" + old_id);
				old_id = student_id;
			}

   }
       
       System.out.println("Size after remove" +aStudent.size());
    }
}