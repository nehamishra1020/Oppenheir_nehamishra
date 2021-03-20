package stepdeftest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.http.HttpRequestFactory;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class testdemo {
	

	
	
	
	private  static  final  String  BASE_URL  =  "localhost:8080";
	String birthday = "10031990";
	String gender = "Male";
	String name = "ABC";
	String natid = "India";
	String salary = "1000";
	String tax = "20";
	String birthday2 = "10031980";
	String gender2 = "Male";
	String name2 = "XYZ";
	String natid2 = "Ind23";
	String salary2 = "5000";
	String tax2 = "50";
	RequestSpecification request;
	private  static  Response response;
	private  static  String  jsonString;
	WebDriver driver;
	WebElement uploadElement;
	
	@Test

	@Given("^Post the API$")
	public void post_the_API() throws Throwable {
		//RestAssured.baseURI  =  BASE_URL;
		RestAssured.port=8080;
		request  =  RestAssured.given();
		request.header("Content-Type",  "application/json"); 
	}
	
	
	@When("^Provide Valid details$")
	public void provide_Valid_details() throws Throwable {
		response  =  request.body("{ \"birthday\":\""  +  birthday  +  "\", \"gender\":\""  +  gender  +  "\", \"name\":\""  +  name  +  "\", \"natid\":\""  +  natid  +  "\", \"salary\":\""  +  salary  +  "\", \"tax\":\""  +  tax  +  "\"}")
				  .post("/calculator/insert");	

	}
	
	@When("^Provide Valid  multiple details$")
	public void provide_Valid_multiple_details() throws Throwable {
		response  =  request.body("{ \"birthday\":\""  +  birthday2  +  "\", \"gender\":\""  +  gender2  +  "\", \"name\":\""  +  name2  +  "\", \"natid\":\""  +  natid2  +  "\", \"salary\":\""  +  salary2  +  "\", \"tax\":\""  +  tax2  +  "\"}")
				  .post("/calculator/insertMultiple");	
	}
	

	@Then("^Status_code equals (\\d+)$")
	public void status_code_equals(int arg) throws Throwable {
		Assert.assertEquals(arg, response.getStatusCode());
	}
	
	 
	
	 
	@Then("^response contains IsLogin equals \"([^\"]*)\"$")
	    public void response_contains_IsPosted_equals_(String message) {
		    Assert.assertEquals(message, getJsonPath(response, "IsPosted"));
	    }	

	 
	 public String getJsonPath(Response response, String key) {
			String resp = response.asString();
			JsonPath js = new JsonPath(resp);
			return js.get(key).toString();
		}
	 
	 
	 @Given("^Navigate to the URL$")
	 public void navigate_to_the_URL() throws Throwable {
		 
		 System.setProperty("webdriver.chrome.driver", "C://SeleniumSoftware//chromedriver_win32//chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.navigate().to("http://localhost:8080/");
		  
	    
	 }

	 @When("^Click on the upload button$")
	 public void click_on_the_upload_button() throws Throwable {
	 	WebElement uploadElement = driver.findElement(By.xpath("//*[@class='custom-file-input']"));
	 	//uploadElement.click();
	 }

	 @Then("^Upload the CSV file$")
	 public void upload_the_CSV_file() throws Throwable {
		 uploadElement.sendKeys("C://SeleniumSoftware//taxcalculater.csv");
	 }
	 
	 
	 @Given("^Hit the Get API$")
	 public void hit_the_Get_API() throws Throwable {
		 RestAssured.port=8080;
			request  =  RestAssured.given();
			request.header("Content-Type",  "application/json"); 
		   response = request.get("/calculator/taxRelief");
	 }
	 
	
	 
	 @Then("^Verify the text$")
	 public void verify_the_text() throws Throwable {
	   String text = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div/div")).getText();
	   System.out.println(text);
	   Assert.assertEquals(text,"Cash dispensed");
	 }
	 
	 @When("^Click on the Dispense Now in UI$")
	 public void click_on_the_Dispense_Now_in_UI() throws Throwable {
	 WebElement DsipenseButton = driver.findElement(By.xpath("//*[@id=\"contents\"]/a[2]"));
	 DsipenseButton.click();
	 }
	 
	 @Then("^Close the browser$")
	 public void close_the_browser() throws Throwable {
	  driver.close();
	 }
	 
	 
	 @Given("^Calculation of Tax Relief based on formulae$")
	 public void calculation_of_Tax_Relief_based_on_formulae() throws Throwable {
	    int Age =20;
	    String Gender= "Male";
	    int Sal =1000;
	    int Tax=20;
	    int	TaxRelief;
	  
	    
	    
	    if (Age <=18 && Gender == "Male") {
	    	
	    	TaxRelief = (int) (((Sal-Tax) * 1 ) + 0);	
	    	System.out.println("Tax Relief is " +TaxRelief);
	    	
	    }else if (Age >18 && Age <=35 && Gender == "Male")
	    {TaxRelief = (int) (((Sal-Tax) * 0.8 ) + 0);
	    System.out.println("Tax Relief is " +TaxRelief);
	    }else if (Age >35 && Age <=50 && Gender == "Male")
	    {TaxRelief = (int) (((Sal-Tax) * 0.5 ) + 0);
	    System.out.println("Tax Relief is " +TaxRelief);
	    } if (Age >50 && Age <=35 && Gender == "Male")
	    {TaxRelief = (int) (((Sal-Tax) * 0.367 ) + 0);
	    System.out.println("Tax Relief is " +TaxRelief);
	    }else if ( Age >=76 && Gender == "Male")
	    {TaxRelief = (int) (((Sal-Tax) * 0.05 ) + 0);
	    System.out.println("Tax Relief is " +TaxRelief);
	    }else if (Age <=18 && Gender == "Female") {
	    	
	    	TaxRelief = (int) (((Sal-Tax) * 1 ) + 500);	
	    	System.out.println("Tax Relief is " +TaxRelief);
	    	
	    }else if (Age >18 && Age <=35 && Gender == "Female")
	    {TaxRelief = (int) (((Sal-Tax) * 0.8 ) + 500);
	    System.out.println("Tax Relief is " +TaxRelief);
	    }else if (Age >35 && Age <=50 && Gender == "Female")
	    {TaxRelief = (int) (((Sal-Tax) * 0.5 ) + 500);
	    System.out.println("Tax Relief is " +TaxRelief);
	    }else if (Age >50 && Age <=35 && Gender == "Female")
	    {TaxRelief = (int) (((Sal-Tax) * 0.367 ) + 500);
	    System.out.println("Tax Relief is " +TaxRelief);
	    }else if ( Age >=76 && Gender == "Female")
	    {TaxRelief = (int) (((Sal-Tax) * 0.05 ) + 500);
	    System.out.println("Tax Relief is " +TaxRelief);
	    
	    
	    
	 }



}
}
