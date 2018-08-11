package academy.dd.fibonacci.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import io.restassured.http.ContentType;
@RunWith(Parameterized.class)
public class FibonacciServiceRangeTest {
	private final String baseUrl = "http://localhost:7003/fib/range";
	
	private int startIndex;
	private int finishIndex;
	private List<String> expectedResult;
	

	public FibonacciServiceRangeTest(int startIndex,int finishIndex, String[] expectedResult){
		super();
		this.startIndex=startIndex;
		this.finishIndex=finishIndex;
		this.expectedResult=new ArrayList<String>(Arrays.asList(expectedResult));
	}
	
	@Test public void
	verifyBodyReturnsCorrectIndex(){
		given().
			param("startIndex", startIndex).
		and().
			param("finishIndex", finishIndex).
		when().
			get(baseUrl).
		then().
			assertThat().
			statusCode(200).
		and().
			assertThat().
			contentType(ContentType.JSON).
		and().
			body("$", equalTo(expectedResult));		
	}
	
	@Parameters
	public static Collection input(){
		return Arrays.asList(new Object[][]{
			{0,1,new String[]{"0","1"}},
			{0,3,new String[]{"0","1","1","2"}},
			{3,3,new String[]{"2"}},
			{3,1,new String[]{}}
		});
	}
}
