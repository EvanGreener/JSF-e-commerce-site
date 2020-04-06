package com.gb1w20.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Selenium test class for the client front page
 * @author Giancarlo Biasiucci, Saad Khan
 * @version April 6, 2020
 */
public class IndexPageTestIT {
    
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        // Normally an executable that matches the browser you are using must
        // be in the classpath. The webdrivermanager library by Boni Garcia
        // downloads the required driver and makes it available
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }
    
    @After
    public void shutdownTest() {
        //Close the browser
        driver.quit();
    }
    
    @Test
    public void testIndexTitle() throws Exception {
        // And now use this to visit a web site
        driver.get("http://localhost:8080/book_store_project/");
        // Wait for the page to load, timeout after 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Wait for the page to load, timeout after 10 seconds
        wait.until(ExpectedConditions.titleIs("The BookStore"));
    }
    
    @Test
    public void testIndexSearch() throws Exception {
        // And now use this to visit a web site
        driver.get("http://localhost:8080/book_store_project/");
        // Wait for the page to load, timeout after 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Wait for the page to load, timeout after 10 seconds
        wait.until(ExpectedConditions.titleIs("The BookStore"));
        WebElement searchBar = driver.findElement(By.className("searchBar"));
        searchBar.clear();
        searchBar.sendKeys("test");
        
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        searchButton.click();
        wait.until(ExpectedConditions.titleIs("Gallery Page"));
    }
}
