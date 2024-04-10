package FrameWork.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendeprt {
	
	public static ExtentReports getReportObj()
	{
		
		
		//EtentReporter(Main Class) and ExtentSparkreporter (class to help config changes)classes imp to create report
		String path=System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setReportName("snehalReport");
		htmlReporter.config().setDocumentTitle("AutoResult");
		
		
		//ExtentReports repo=new ExtentReports();
		ExtentReports repo=new ExtentReports();
		repo.attachReporter(htmlReporter);
		repo.setSystemInfo("Tester", "Snehaladsul");
		//repo.createTest(path); lets write first in listners
		return repo;
		}

}
