package com.intents.chatbot.addintents;

import com.sun.org.apache.bcel.internal.generic.DREM;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyQuickIntentCreation {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{

        System.setProperty("webdriver.gecko.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/geckodriver");
        driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/chromedriver");
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(alwaysRun = true)
    public void verifyQuickIntentCreation()throws Exception{
        driver.get("http://192.168.86.51:802/admin/login.jsf");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt18']")).sendKeys("superuser");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt21']")).sendKeys("123456");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//li[@id='menuform:subIntent']//i[@class='layout-menuitem-toggler fa fa-fw fa-angle-down']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='menuform:intent-quick-creation']//a")).click();

        driver.findElement(By.xpath("//input[@id='j_idt35:txtName']")).sendKeys("Laureate Park");

        driver.findElement(By.xpath("//div[@id='txtGroup']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='txtGroup_2']")).click();

        driver.findElement(By.xpath("//input[@id='tabs:cmpPattern:txtPattern']")).sendKeys("Laureate Park details");

        driver.findElement(By.xpath("//button[@id='tabs:j_idt82:btnAdd']//span[@class='ui-button-text ui-c'][contains(text(),'Add')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='tabs:cmpPattern:txtPattern']")).sendKeys("Parks in Lake Nona");

        driver.findElement(By.xpath("//button[@id='tabs:j_idt82:btnAdd']//span[@class='ui-button-text ui-c'][contains(text(),'Add')]")).click();

        driver.findElement(By.xpath("//input[@id='cmpPattern:txtPattern']")).sendKeys("Brightly colored bungalows, townhomes, cottages and multi-story houses are complemented by modern design and technology features");

        driver.findElement(By.xpath("//button[@id='j_idt141:btnAdd']//span[@class='ui-button-text ui-c'][contains(text(),'Add')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();


    }

    @AfterClass(alwaysRun = true)
    public void tearDown()throws Exception{
        driver.quit();
    }
}
