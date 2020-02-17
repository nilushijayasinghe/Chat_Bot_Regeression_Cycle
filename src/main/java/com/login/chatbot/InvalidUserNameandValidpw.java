package com.login.chatbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class InvalidUserNameandValidpw {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(alwaysRun = true)
    public void invalidUserNameandValidpw() throws Exception{

        driver.get("http://192.168.86.51:802/admin/login.jsf");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt18']")).sendKeys("superuser1");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt21']")).sendKeys("123456");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        assertEquals(driver.findElement(By.xpath("//span[@class='ui-messages-warn-summary']")).getText(),"Invalid User name");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception{
        driver.quit();
    }
}


