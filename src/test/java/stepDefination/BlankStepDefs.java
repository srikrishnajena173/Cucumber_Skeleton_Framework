package stepDefination;

import static org.testng.AssertJUnit.assertEquals;
import baseComponent.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModel.smaplePage;

public class BlankStepDefs extends BaseClass {
	public static String excelPath = "C:\\Users\\KRISHNA\\eclipse-workspace\\SampleCucumberProject\\src\\test\\resources\\testData\\TestData-seleniumframework.xlsx";
	public static String sheetPath = "SignInContactUs";

	@Before
	public void lunchApp() {
		readXLSXFile(excelPath, sheetPath);
		System.out.println("Lunch Application");
	}

	@When("^I open seleniumframework website$")
	public void i_open_seleniumframework_website() throws Throwable {
		lunchChromeBrowser(
				"https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}

	@Then("^I validate title and URL$")
	public void i_print_title_and_URL() throws Throwable {
		smaplePage obj = new smaplePage(driver);
		writeValue(excelPath, "Sheet3", 0, obj.getVal());
		System.out.println("doen");

	}

	@After
	public void quitDriver() {
		//closeBrowser();
	}
}