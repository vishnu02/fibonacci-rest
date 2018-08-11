# Testing Rest Services

There are a number of endpoints in this application.  The following question needs to be answered:

- When does the application STOP returning Fibonacci numbers in their correct sequence?

There are no automated checks for this application.  Treating the application as a black box, produce appropriate automated checks against the applications interfaces.  Consider that there is more than one interface into the application.

- Use only RestAssured or RestEasy to test the REST interface.
- Use only JUnit as a test harness.
- Ensure that your tests can be executed with an appropriate goal from Maven.

# To submit your test
Either fork this repo and share the link, or submit commits to a branch.


# The Test is Submitted
	
	Q: - When does the application STOP returning Fibonacci numbers in their correct sequence?
	
	A: - The application stops returning incorrect sequence at the below endpoint -
	
	Case - 1
	endpoint - http://localhost:7003/fib/range?startIndex=1&finishIndex=10 
		
	actual - 		["1","1","2","3","5","8","13","21","34"]
	
	expected -     ["1","1","2","3","5","8","13","21","34","55"]
	
	Issue/Defect - The actual result do not returns the value of finish Index in the above example -The value 	of finish index is 55, which was not returned.
	
	Case - 2
	endpoint - http://localhost:7003/fib/range?startIndex=10&finishIndex=1
	
	When the start Index is greater than finish index, the application stops returning the result. 
	
# Pre-requisite
	
	1. Maven should be configured
	2. JDK 1.8(Strictly not JDK 1.9) should be installed
	3. The application should be up and running
	
# Execute the tests
	
	mvn test