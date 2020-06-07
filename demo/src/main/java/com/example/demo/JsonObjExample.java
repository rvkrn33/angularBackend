package com.example.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.jackson.JsonObjectDeserializer;

public class JsonObjExample {
	JSONObject obj=null;
	
	public int levelCount() {

		obj = new JSONObject();
		Map<String,Map<String,String>> map=new HashMap<String,Map<String,String>>();
		
		Map<String,String> innerMap1=new HashMap<String,String>();
		innerMap1.put("name","Ravi" );
		
		Map<String,String> innerMap2=new HashMap<String,String>();
		innerMap2.put("name","Patil" );
		
		map.put("0",innerMap1);
		map.put("1",innerMap2);
		
		obj.put("", map);
		
		String jsonText = obj.toJSONString();

		System.out.println("Text >>>> "+jsonText);
		
		String[] str=jsonText.split(",");
		System.out.println("length : "+str.length);
		
		for (String string : str) {
			System.out.println(string);
		}
		
		
		JSONParser parser = new JSONParser();
		
		JSONObject newJObject = null;
		try {
			newJObject = (JSONObject) parser.parse(jsonText);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Map<String,Map<String,String>> map1=(Map<String, Map<String,String>>) newJObject.get("");
		
		//System.out.println(map1.size());

		//System.out.println("Get Json Object >>"+newJObject.get(""));
		

		return map1.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new JsonObjExample().levelCount();
	}

}
