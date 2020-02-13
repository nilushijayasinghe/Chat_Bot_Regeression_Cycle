package com.actions.chatbot.searchactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyUpdateAction {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp()throws Exception{

        System.setProperty("webdriver.chrome.driver","/home/nilushi/Documents/chatbot/Chat_Bot_Regeression_Cycle/libs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

    }

    @Test(alwaysRun = true)
    public void verifyUpdateAction()throws Exception{

        driver.get("http://192.168.86.51:802/admin/login.jsf");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt18']")).sendKeys("superuser");

        driver.findElement(By.xpath("//input[@id='j_idt13:j_idt21']")).sendKeys("123456");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//li[@id='menuform:subAction']//i[@class='layout-menuitem-toggler fa fa-fw fa-angle-down']")).click();

        driver.findElement(By.xpath("//li[@id='menuform:addAction']//a")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='j_idt34:txtName']")).sendKeys("WHIT House");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//textarea[@id='txtPattern']")).sendKeys("A hotel");

        driver.findElement(By.xpath("//span[@class='ui-button-text ui-c'][contains(text(),'Add')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='menuform:searchAction']//a")).click();

        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//*[contains(text(),'WHIT House')]"));
        actions.contextClick(elementLocator).perform();
        WebElement elementOpen;
        driver.findElement(By.xpath("//div[@id='j_idt64']//li[2]//a[1]")).click();

        driver.findElement(By.xpath("//input[@id='j_idt34:txtName']")).clear();

        driver.findElement(By.xpath("//input[@id='j_idt34:txtName']")).sendKeys("WHIT House new");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown()throws Exception{
        driver.quit();
    }
}
