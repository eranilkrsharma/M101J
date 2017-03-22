package com.mongodb;

import org.bson.Document;

public class DocumentTest {

	public static void main(String[] args) {
		Document doc = new Document().append("str", "MongoDB Docuemnet")
				.append("document", new Document("str2", "name"));
	System.out.println(doc.getString("str"));

	}
	
	
}
