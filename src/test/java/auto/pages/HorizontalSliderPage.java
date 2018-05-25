package auto.pages;

/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import auto.utility.Services;

public class HorizontalSliderPage extends Services {

  private final static String HEADING = "Horizontal Slider";
  private String xpathHeading = "//h3";

  private String xpathSlider = "//input";



  public HorizontalSliderPage(WebDriver driver) {
    super(driver);
  }

  public void verifyHorizontalSliderPageHeader() {
    waitForElement(xpathHeading);
    WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
    String actualHeading = headerEle.getText();
    assertEquals(actualHeading, HEADING,
        "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
  }

  public void hirizontalSlide() throws InterruptedException {

    WebElement ele = getWebElement(xpathSlider);

    Dimension dimension = ele.getSize();
    System.out.println(dimension);
    System.out.println(dimension.getWidth());
    System.out.println(dimension.getHeight());

    Actions actions = new Actions(driver);
    actions.dragAndDropBy(ele, dimension.getWidth(), 0).build().perform();
    Thread.sleep(3000);


  }
}
