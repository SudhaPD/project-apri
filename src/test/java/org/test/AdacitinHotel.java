package org.test;

import java.util.Date;

import org.adacitin.BookPage;
import org.adacitin.LoginPage;
import org.adacitin.SearchPage;
import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;



public class AdacitinHotel extends BaseClass {
	
		@BeforeClass
		public static void beforeClass() {
			launchBrowser("chrome");
			urlLaunch("https://adactinhotelapp.com/");
			maximize();
			implicitWait(10);
			System.out.println(getUrl());
			System.out.println("Before Class");
			Assert.assertTrue("verify url",getUrl().contains("adactin"));
		}

		@AfterClass
		public static void afterClass() {
//			browserQuit(); 		
			Date d=new Date();
			System.out.println("After Class"+ d);
		}
		
		@Before
		public void before() {
			Date d=new Date();
			System.out.println("Before" + d);
		}
		
		@After
		public  void after() {
			Date d=new Date();
			System.out.println("After" + d);
		}

		@Test
		public void test1() {
			LoginPage l=new LoginPage();
			l.login("Aisha1234", "FR32XP");
			//System.out.println(getAttribute(l.getTxtUsername()));
		//	Assert.assertEquals("verify  user","Aisha1234", getAttribute(l.getTxtUsername()));
			
			System.out.println("Test1");
			
		}
		@Test
		public void test2()  {

			SearchPage s=new SearchPage();
			System.out.println("Test2");
			s.search();
		}
		@Test
		public void test3() throws InterruptedException {

			BookPage b=new BookPage();
			System.out.println("Test3");
			b.order("first","last", "address","1234567812345678", "1234");
		}


}
