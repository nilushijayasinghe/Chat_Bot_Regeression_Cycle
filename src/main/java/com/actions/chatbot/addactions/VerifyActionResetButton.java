package com.actions.chatbot.addactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class VerifyActionResetButton {

    private WebDriver driver;



    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{

        System.setProperty("webdriver.chrome.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);

    }

    @Test(alwaysRun = true)
    public void VerifyActionResetButton ()throws Exception{

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

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();


    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception{
        driver.quit();

    }
}
