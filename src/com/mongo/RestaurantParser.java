package com.mongo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RestaurantParser {
	private static final String DB_NAME = "spnup";
	private static final String COLLECTION_NAME = "restaurant";

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;

	public RestaurantParser() {
		this.mongoClient = MongoDbManager.getInstance();
		this.database = mongoClient.getDatabase(RestaurantParser.DB_NAME);
		this.collection = database.getCollection(RestaurantParser.COLLECTION_NAME);
	}

    //이제 음식점 정보를 담고 있는 하나 하나의 JSON을 몽고DB에 저장해 보자.
	// Document 클래스의 parse() 메소드를 이용하여 Document 객체로 만들고 이를 몽고DB에 저장
	private void save(String json) {
		Document doc = Document.parse(json);
		this.collection.insertOne(doc);
	}
     //다음으로 JSON 파일을 읽고 몽고DB에 저장하는 코드를 작성해 보자
	//JSON 파일을 읽고 그 내용을 문자열 변수에 저장하는 코드는 다음과 같다.
	//is에 파일경로를 저장하고 jsonTxt로 그 파일을 변환
	public void parse(String fileName) {
		InputStream is = null;
		String jsonTxt = new String();

		try {
			is = new FileInputStream(fileName);
			jsonTxt = IOUtils.toString(is, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//다음으로 저장한 JSON 문자열을 해석하는 코드는 다음과 같다.
		//위의 jsonTxt를 JSONObject형태의 json으로 저장하고 
		JSONObject json = new JSONObject(jsonTxt);

		//위의 json의 데이터를 배열로 만들고 
		//restaurant 스트링형태로 저장한다.
		JSONArray arr = json.getJSONArray("DATA");
		for (int i = 0; i < arr.length(); i++) {
			String restaurant = arr.getJSONObject(i).toString();
			this.save(restaurant);
		}
	}

	public static void main(String[] args) {
		RestaurantParser rp = new RestaurantParser();
		rp.parse("C:\\Users\\a\\Desktop\\[JSON]서울시음식점\\서울시 강남구 일반음식점 식품위생업소 현황.json");
	}

}
