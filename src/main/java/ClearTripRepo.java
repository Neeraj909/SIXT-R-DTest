import base.UiBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClearTripRepo extends UiBase {


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
        return  getDriver().findElement(By.cssSelector("#ToTag"));
    }
    public List<WebElement> clickOnDateIcon(){
        return getDriver().findElements(By.cssSelector(".icon.ir.datePicker"));
    }
    public void typeDepartDate(int date, int month, int year) {

        String s = "//td[contains(@data-handler,'selectDay') and @data-month='" + (month - 1)
                + "' ]/a[contains(text(),'" + date + "')]";
        getDriver().findElement(By.xpath(s)).click();
    }
    public WebElement selectAdults(){
        return getDriver().findElement(By.cssSelector("#Adults"));
    }
    public WebElement selectChildren(){
        return getDriver().findElement(By.cssSelector("#Childrens"));
    }
    public WebElement clickSearchFlight(){
        return getDriver().findElement(By.cssSelector("#SearchBtn"));
    }
    public WebElement clickOnBookButton()
    {
        return getDriver().findElement(By.cssSelector("//button[text()='Book']"));
    }
    public WebElement clickOnContinue(){
        return getDriver().findElement(By.cssSelector("#itineraryBtn"));
    }
    public WebElement setMailId(){
        return getDriver().findElement(By.cssSelector("#username"));
    }
    public WebElement loginContinue(){
        return getDriver().findElement(By.cssSelector("#LoginContinueBtn_1"));
    }
    public WebElement setPersonTitle(){
        return getDriver().findElement(By.cssSelector("select[name='AdultTitle1']"));
    }
    public WebElement setFirstName(){
        return getDriver().findElement(By.cssSelector("input[name='AdultFname1']"));
    }
    public WebElement setLastName(){
        return getDriver().findElement(By.cssSelector("input[name='AdultLname1']"));
    }

    public WebElement selectDay(){
        return getDriver().findElement(By.cssSelector("#AdultDobDay1"));
    }
    public WebElement selectMonth(){
        return getDriver().findElement(By.cssSelector("#AdultDobMonth1"));
    }
    public WebElement selectYear(){
        return getDriver().findElement(By.cssSelector("#AdultDobYear1"));
    }
    public WebElement clickTravellerButton(){
        return getDriver().findElement(By.cssSelector("#travellerBtn"));
    }
    public WebElement makePayment(){
        return getDriver().findElement(By.cssSelector("#paymentSubmit"));
    }

}
