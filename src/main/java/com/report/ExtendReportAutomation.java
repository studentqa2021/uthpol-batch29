package com.report;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class ExtendReportAutomation {

	
	protected ExtentHtmlReporter htmlreporter;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeTest
	public void before() {
		htmlreporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "./Extents Report.html"));
		htmlreporter.loadXMLConfig(new File(System.getProperty("user.dir") + "./extent-config.xml"), true);
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setAutoCreateRelativePathMedia(true);
		htmlreporter.config().setDocumentTitle("AutomationTesting Report");
		htmlreporter.config().setReportName("TestReport");

		extent = new ExtentReports();
		extent.setSystemInfo("Company Name ", "Smart Tech");
		extent.setSystemInfo("Project Name ", "QA Portal");
		extent.setSystemInfo("Application Name ", "Online Banking Portal");
		extent.setSystemInfo("Application Version ", "1.0.1");
		extent.setSystemInfo("Testing environment ", "QA");
		extent.setSystemInfo("Software Engineer Name", System.getProperty("user.name"));
		extent.attachReporter(htmlreporter);

	}

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		String testName = method.name();
		test = extent.createTest(testName);


	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws Exception {//interface ItestLisener (@Lisener)

		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel(result.getName() + "Test Failed", ExtentColor.RED));
			test.log(Status.FAIL, "The test status::" + result.getStatus() + ":: Test FAIL");
			test.fail("Test Failed and check the screen shot below", MediaEntityBuilder
					.createScreenCaptureFromPath("./target/Screen shot/Login Test status.png").build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName() + "Test Passed", ExtentColor.GREEN));
			test.log(Status.PASS, "The test status::" + result.getStatus() + ":: Test Passed");
			
			test.pass("Test passed and check Screen shot below", MediaEntityBuilder
					.createScreenCaptureFromPath("./target/Screen shot/Login Test status.png").build());

		} else {
			test.skip(MarkupHelper.createLabel(result.getName() + "Test Skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
			test.log(Status.SKIP, "The test status::" + result.getStatus() + ":: Test SKIP");

		}

	}

	@AfterTest
	public void sfterSuite() {
		extent.flush();

	}
	
	
}
