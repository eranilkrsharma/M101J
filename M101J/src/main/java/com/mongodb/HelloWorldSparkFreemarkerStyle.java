package com.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldSparkFreemarkerStyle {

	public static void main(String[] args) {
		final Configuration aConfiguration = new Configuration();
		aConfiguration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");	
		Spark.get( "/", new Route(){
			public Object handle(final Request request, final Response response){			
				
				StringWriter aWriter = new StringWriter();
				try {
					Template aTemplate = aConfiguration.getTemplate("hello.ftl");
					Map<String, Object> aHelloMap = new HashMap<String, Object>();
					aHelloMap.put("name","FreeMarker ");
					aTemplate.process(aHelloMap,aWriter);
					System.out.println(aWriter);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return aWriter;
			}
			
		});

	}

}
