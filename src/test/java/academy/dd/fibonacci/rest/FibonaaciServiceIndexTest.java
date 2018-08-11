package academy.dd.fibonacci.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import io.restassured.http.ContentType;

@RunWith(Parameterized.class)
public class FibonaaciServiceIndexTest {
	private int index;
	private int startIndex;
	private int finishIndex;
	private String expectedResult;
	
	public FibonaaciServiceIndexTest(int index, String expectedResult){
		super();
		this.index=index;
		this.expectedResult=expectedResult;
	}
	
	@BeforeClass
	public static void setup(){
		
		
		//baseURI = "";
	}
	
	@AfterClass
	public static void teardown(){
		//TODO
	}
	
	
	
	@Test public void
	verifyBodyReturnsCorrectIndex(){
		given().
			pathParam("index", index).
		when().
			get("http://localhost:7003/fib/{index}").
		then().
			assertThat().
			statusCode(200).
		and().
			assertThat().
			contentType(ContentType.JSON).
		and().
			body(equalTo(expectedResult));		
	}
	
	@Parameters
	public static Collection input(){
		return Arrays.asList(new Object[][]{
			{0,"0"},
			{8,"21"},
			{-1,"1"},{-8,"-21"}
		});
	}
	
	
	
	
}
