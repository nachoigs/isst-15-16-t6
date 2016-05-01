package es.upm.dit.isst.tfg.test;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import es.upm.dit.isst.tfg.dao.*;
import es.upm.dit.isst.tfg.model.*;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


public class TestcaseTFG {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  TFGDAOImpl tfgdao;
  private TFG tfg;

  @Before
  public void setUp() throws Exception {
	tfgdao = TFGDAOImpl.getInstance();
    driver = new FirefoxDriver();
    baseUrl = "http://1-dot-vivid-kite-126323.appspot.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCaseTFG() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Es_upm_dit_isst_tfg")).click();
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("nachoperegrino94@gmail.com");
    driver.findElement(By.id("next")).click();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("titulo")).clear();
    driver.findElement(By.id("titulo")).sendKeys("titulo");
    driver.findElement(By.id("resumen")).clear();
    driver.findElement(By.id("resumen")).sendKeys("resumen");
    driver.findElement(By.id("tutor")).clear();
    driver.findElement(By.id("tutor")).sendKeys("tutor@gmail.com");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    
    driver.get(baseUrl + "/es_upm_dit_isst_tfg");
    
    List<WebElement> fila = driver.findElements(By.xpath("//table/tbody/tr/td"));
    assertEquals(fila.get(5).getText(),"1");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
