package academy.dd.fibonacci.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import io.restassured.http.ContentType;

public class FibonacciServiceDefaultTest {

	@Test public void
	verifyBodyReturnsFirstTenFibonacciItems(){
		given().
			baseUri("http://localhost:7003/").
		when().
			get("/fib").
		then().assertThat().
			statusCode(200).
		and().
			contentType(ContentType.JSON).
		and().
			body("$", equalTo(new ArrayList<String>(Arrays.asList("0","1","1","2","3","5","8","13","21","34"))));
	}
	
	@Test public void
	verifyBodyReturns404WithInvalidPathParams(){
		given().
			pathParam("index", "A").
		when().
			get("http://localhost:7003/fib/{index}").
		then().
			assertThat().
			statusCode(404);
		
	}
	@Test public void
	verifyBodyReturns404WithInvalidFinishIndex(){
		given().
			param("startIndex", 1).
		and().
			param("finishIndex", "A").
		when().
			get("http://localhost:7003/fib/range").
		then().
			assertThat().
			statusCode(404);
	}
	@Test public void
	verifyBodyReturns404WithInvalidStartIndex(){
		given().
			param("startIndex", "A").
		and().
			param("finishIndex", 1).
		when().
			get("http://localhost:7003/fib/range").
		then().
			assertThat().
			statusCode(404);
	}
}
