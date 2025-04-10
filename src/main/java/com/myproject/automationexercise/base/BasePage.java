package com.myproject.automationexercise.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementByLocator(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementByWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(By locator) {
        waitForElementByLocator(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        waitForElementByLocator(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        waitForElementByLocator(locator);
        return driver.findElement(locator).getText();
    }
}