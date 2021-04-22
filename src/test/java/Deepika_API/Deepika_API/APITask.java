package Deepika_API.Deepika_API;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class APITask {
	public JSONObject data;
	//public JSONObject data;
public 	JSONObject data1;

	 int id;
	String getURL="https://petstore.swagger.io/v2/pet/";
	App a;
	
	
	@Test(priority=0)
	public void create() throws IOException, java.text.ParseException, ParseException
	{
		 a=new App();
		 data=a.Request();
		id= (int) data.get("id");
	}
	
	
	@Test(priority=1)
	public void get() {

		Response response = RestAssured.get(getURL+id);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		given().get(getURL+id).then().statusCode(200).body("id", equalTo(id));


	}
	
	@Test(priority=2)
	public void update() throws IOException, java.text.ParseException, ParseException
	{
		 a=new App();
		 data=a.Request();
		id= (int) data.get("id");
	}
	
	@Test(priority=3)
	public void delete() {

		Response response = RestAssured.get(getURL+id);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		given().delete(getURL+id).then().statusCode(200).body("code", equalTo(200));


	}
	
	

	}	

