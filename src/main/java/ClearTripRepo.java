import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClearTripRepo extends UiBase{


    public WebElement clickOnRoundTrip(){
        return getDriver().findElement(By.cssSelector("#RoundTrip"));
    }
    public WebElement clickOnOneWay(){
       return getDriver().findElement(By.cssSelector("#OneWay"));
    }
    public List<WebElement> selectFromCity(){
        return getDriver().findElements(By.cssSelector("ul#ui-id-1>li>a"));
    }
    public List<WebElement> selectToCity(){
        return getDriver().findElements(By.cssSelector("ul#ui-id-2>li>a"));
    }
    public WebElement searchFromCity(){
        return  getDriver().findElement(By.cssSelector("#FromTag"));
    }
    public WebElement searchToCity(){
        return  getDriver().findElement(By.cssSelector("#toTag"));
    }
    public List<WebElement> clickOnDateIcon(){
        return getDriver().findElements(By.cssSelector(".icon.ir.datePicker"));
    }
}
