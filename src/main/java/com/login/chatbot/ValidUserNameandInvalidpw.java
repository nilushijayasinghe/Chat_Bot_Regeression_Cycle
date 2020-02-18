package com.login.chatbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ValidUserNameandInvalidpw {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{

        System.setProperty("webdriver.gecko.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/geckodriver");
        driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        //driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(alwaysRun = true)
    public void validUserNameandInvalidpw () throws Exception{

        driver.get("http://192.168.86.51:802/admin/login.jsf");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt18']")).sendKeys("superuser");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt21']")).sendKeys("1234567");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        assertEquals(driver.findElement(By.xpath("//span[@class='ui-messages-warn-summary']")).getText(),"Invalid Password");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception{
        driver.quit();

    }
}
