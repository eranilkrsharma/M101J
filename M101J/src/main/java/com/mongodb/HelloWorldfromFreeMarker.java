package com.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldfromFreeMarker {

	public static void main(String[] args) {
		
		Configuration aConfiguration = new Configuration();
		aConfiguration.setClassForTemplateLoading(HelloWorldfromFreeMarker.class, "/");
		try {
			Template aTemplate = aConfiguration.getTemplate("hello.ftl");
			StringWriter aWriter = new StringWriter();
			Map<String, Object> aHelloMap = new HashMap<String, Object>();
			aHelloMap.put("name","FreeMarker");
			aTemplate.process(aHelloMap,aWriter);
			System.out.println(aWriter);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
