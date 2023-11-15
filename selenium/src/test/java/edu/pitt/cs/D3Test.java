// Generated by Selenium IDE
package edu.pitt.cs;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.devtools.v109.runtime.model.WebDriverValue;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL; 

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");

    driver = new ChromeDriver(options);

    //driver = new ChromeDriver();

    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tEST1LINKS() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.linkText("Reset"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.linkText("Reset"));
      String attribute = element.getAttribute("href");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/reset");
  }
  @Test
  public void tEST2RESET() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=true\";document.cookie = \"3=false\";");
    driver.get("http://localhost:8080/");
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    driver.findElement(By.xpath("//li[8]/a")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST3CATALOG() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//li[2]/img"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.xpath("//li[2]/img"));
      String attribute = element.getAttribute("src");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/images/cat2.jpg");
  }
  @Test 
  public void tEST4LISTING() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.get("http://localhost:8080/");
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST5RENTACAT() {
    driver.get("http://localhost:8080/rent-a-cat");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[@onclick=\'rentSubmit()\']"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[@onclick=\'returnSubmit()\']"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.id("rentID"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.id("returnID"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.id("rentID"));
      Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
      assertTrue(isEditable);
    }
    {
      WebElement element = driver.findElement(By.id("returnID"));
      Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
      assertTrue(isEditable);
    }
  }
  @Test
  public void tEST6RENT() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//li[2]/a")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("Rented out"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST7RETURN() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=true\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//li[2]/a")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("2");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST8FEEDACAT() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    assertThat(driver.findElement(By.xpath("//button[@onclick=\'feedSubmit()\']")).getText(), is("Feed"));
  }
  @Test
  public void tEST9FEED() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("6");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.id("feedResult")).click();
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Nom, nom, nom."));
  }
  @Test
  public void tEST10GREETACAT() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false; path=/greet-a-cat\";document.cookie = \"2=false; path=/greet-a-cat\";document.cookie = \"3=false; path=/greet-a-cat\";");
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.xpath("//div[2]/h4")).getText(), is("Meow!Meow!Meow!"));
  }
  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("http://localhost:8080/greet-a-cat/Jennyanydots");
    js.executeScript("document.cookie = \"1=false; path=/greet-a-cat/Jennyanydots\";document.cookie = \"2=false; path=/greet-a-cat/Jennyanydots\";document.cookie = \"3=false; path=/greet-a-cat/Jennyanydots\";");
    driver.get("http://localhost:8080/greet-a-cat/Jennyanydots");
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.xpath("//div[2]/h4")).getText(), is("Meow! from Jennyanydots."));
  }
  @Test
  public void tEST12RENT() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//li[2]/a")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("Rented out"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("Rented out"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Failure!"));
  }
  @Test
  public void tEST13RENT() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//li[2]/a")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("-1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Failure!"));
  }
  @Test
  public void tEST14RETURN() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//li[2]/a")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("2");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Failure!"));
  }
  @Test
  public void tEST15RETURN() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//li[2]/a")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("-1");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.xpath("//div/ul/li[3]")).click();
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Failure!"));
  }
  @Test
  public void tEST16FEEDACAT() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    {
      WebElement element = driver.findElement(By.id("catnips"));
      Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
      assertTrue(isEditable);
    }
  }
  @Test
  public void tEST17FEED() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("5");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.id("feedResult")).click();
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Cat fight!"));
  }
  @Test
  public void tEST18FEED() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    assertThat(driver.findElement(By.xpath("//div/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("-1");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.id("feedResult")).click();
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Cat fight!"));
  }
  @Test
  public void tEST19CATALOG() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//li/img"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.xpath("//li/img"));
      String attribute = element.getAttribute("src");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/images/cat1.jpg");
  }
  @Test
  public void tEST20CATALOG() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//li[3]/img"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.xpath("//li[3]/img"));
      String attribute = element.getAttribute("src");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/images/cat3.jpg");
  }
  @Test
  public void tEST21LINKS() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.linkText("Catalog"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.linkText("Catalog"));
      String attribute = element.getAttribute("href");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/");
  }
  @Test
  public void tEST22LINKS() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.linkText("Feed-A-Cat"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.linkText("Feed-A-Cat"));
      String attribute = element.getAttribute("href");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/feed-a-cat");
  }
  @Test
  public void tEST23LINKS() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.linkText("Feed-A-Cat"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.linkText("Feed-A-Cat"));
      String attribute = element.getAttribute("href");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/feed-a-cat");
  }
  @Test
  public void tEST24LINKS() {
    driver.get("http://localhost:8080/");
    {
      List<WebElement> elements = driver.findElements(By.linkText("Greet-A-Cat"));
      assert(elements.size() > 0);
    }
    {
      WebElement element = driver.findElement(By.linkText("Greet-A-Cat"));
      String attribute = element.getAttribute("href");
      vars.put("x", attribute);
    }
    assertEquals(vars.get("x").toString(), "http://localhost:8080/greet-a-cat");
  }
  @Test
  public void tEST25LINKS() {
    driver.get("http://localhost:8080/");
    vars.put("links", js.executeScript("return [\"/\", \"/rent-a-cat\", \"/feed-a-cat\", \"/greet-a-cat\", \"/reset\"]"));
    vars.put("titles", js.executeScript("return [\"Catalog\", \"Rent-A-Cat\", \"Feed-A-Cat\", \"Greet-A-Cat\", \"Reset\"]"));
    ArrayList collectionLinks = (ArrayList) vars.get("links");
    for (int iLink = 0; iLink < collectionLinks.size() - 1; iLink++) {
      vars.put("link", collectionLinks.get(iLink));
      driver.get("http://localhost:8080" + collectionLinks.get(iLink).toString());
      ArrayList collectionTitles = (ArrayList) vars.get("titles");
      for (int iTitle = 0; iTitle < collectionTitles.size() - 1; iTitle++) {
        vars.put("title", collectionTitles.get(iTitle));
        {
          List<WebElement> elements = driver.findElements(By.linkText("vars.get(title).toString()"));
          assert(elements.size() > 0);
        }
      }
    }
  }
  @Test
  public void tEST26LISTING() {
    driver.get("http://localhost:8080/");
    vars.put("links", js.executeScript("return [\"/\", \"/rent-a-cat\", \"/feed-a-cat\", \"/greet-a-cat\", \"/reset\"]"));
    ArrayList collectionLinks = (ArrayList) vars.get("links");
    for (int iLink = 0; iLink < collectionLinks.size() - 1; iLink++) {
      vars.put("link", collectionLinks.get(iLink));
      driver.get("http://localhost:8080" + collectionLinks.get(iLink).toString());
      {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li"));
        assert(elements.size() > 0);
      }
      {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li[2]"));
        assert(elements.size() > 0);
      }
      {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li[3]"));
        assert(elements.size() > 0);
      }
      {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li[4]"));
        assert(elements.size() == 0);
      }
    }
  }
  @Test
  public void tEST27LISTING() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=true\";document.cookie = \"3=false\";");
    driver.get("http://localhost:8080/");
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
}
