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
    public List<WebElement> selectFromCity(String id){

        return getDriver().findElements(By.cssSelector("ul[id='"+id+"']>li>a"));
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
    public List<WebElement> clickOnButton(String text)
    {
        return getDriver().findElements(By.xpath("//button[text()='"+text+"']"));
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
    public WebElement setPersonDetail(String name){
        return getDriver().findElement(By.cssSelector("select[name='"+name+"']"));
    }
    public WebElement setPersonName(String name){
        return getDriver().findElement(By.cssSelector("input[name='"+name+"']"));
    }

    public WebElement clickTravellerButton(){
        return getDriver().findElement(By.cssSelector("#travellerBtn"));
    }
    public WebElement makePayment(){
        return getDriver().findElement(By.cssSelector("#paymentSubmit"));
    }
    public List<WebElement> setAccountInfo(String text){
        return getDriver().findElements(By.cssSelector("input[placeholder='"+text+"']"));
    }
    public List<WebElement> selectCheckBox(){
        return getDriver().findElements(By.cssSelector(".flex.flex-start.p-relative.flex-middle"));
    }
    public List<WebElement> setData(){
        return getDriver().findElements(By.xpath("//div[@class='row']"));
    }

}
