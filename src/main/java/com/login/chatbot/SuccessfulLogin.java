package com.login.chatbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SuccessfulLogin {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{

        System.setProperty("webdriver.chrome.driver","/home/nilushi/Documents/chatbot/seleniumTestrunJenkins/libs/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox"); //Bypass OS security model
        //options.addArguments("--start-maximized");
        //options.addArguments("--disable-dev-shm-usage");
       // options.addArguments("--headless");
        //webDriver = new ChromeDriver(options);

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void successfulLogin() throws Exception{

        driver.get("http://192.168.86.51:802/admin/login.jsf");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt18']")).sendKeys("superuser");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt21']")).sendKeys("123456");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//img[@id='j_idt17']")).click();

        driver.findElement(By.xpath("//a[@id='j_idt22:j_idt23']")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception{
        driver.quit();
    }


}
