package dataProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utiliti {

public ResponseSpecification resp;
public static RequestSpecification spec;
PrintStream pr;
	public RequestSpecification RequestSpecificatio() throws IOException
	{
		if(spec==null)
		{
		   pr=new PrintStream(new FileOutputStream("alllog.txt"));
		spec = new RequestSpecBuilder().setBaseUri(globalproperty("baseUrl"))
				.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(pr))
				.addFilter(ResponseLoggingFilter.logResponseTo(pr))
				.build();
		return spec;
		}
		return spec;
	}
	public ResponseSpecification ResponseSpecificatio()
	{
		resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200)
				.build();
		return resp;
	}
	public String globalproperty(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\java\\dataProperty\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	public String getJsonPath(String respo,String key)
	{
		JsonPath js = new JsonPath(respo);
		String Key = js.getString(key);
		return Key;
	}
}
