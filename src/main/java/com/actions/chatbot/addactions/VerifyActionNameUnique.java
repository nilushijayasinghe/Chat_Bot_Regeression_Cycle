package com.actions.chatbot.addactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class VerifyActionNameUnique {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{

        //System.setProperty("webdriver.gecko.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/geckodriver");
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

    }

    @Test(alwaysRun = true)
    public void verifyActionNameUnique() throws Exception{
        driver.get("http://192.168.86.51:802/admin/login.jsf");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt18']")).sendKeys("superuser");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt21']")).sendKeys("123456");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//li[@id='menuform:subAction']//i[@class='layout-menuitem-toggler fa fa-fw fa-angle-down']")).click();

        driver.findElement(By.xpath("//li[@id='menuform:addAction']//a")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='j_idt34:txtName']")).sendKeys("Chili's");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//textarea[@id='txtPattern']")).sendKeys("nice place");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c'][contains(text(),'Add')]")).click();

        //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

        Thread.sleep(3000);

        assertEquals(driver.findElement(By.xpath("//div[@id='cmpBtnSet:messages_container']")).getText(),"This action name is already have in system!");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown()throws Exception{
        driver.quit();
    }
}
