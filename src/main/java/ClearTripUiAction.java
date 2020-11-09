import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.UUID;

public class ClearTripUiAction extends ClearTripRepo {
    public static Select select;
    public void bookFlight(String fromCity, String toCity,int date,int month,int year,String adults,String children) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(clickOnRoundTrip()));
        clickOnRoundTrip().click();
        searchFromCity().clear();
        searchFromCity().sendKeys(fromCity);
        selectFromCityDropDown(fromCity);
        searchToCity().clear();
        searchToCity().sendKeys(toCity);
        selectToCityDropDown(toCity);
        clickOnDateIcon().get(0).click();
        typeDepartDate(date,month,year);
        select=selectClass(selectAdults());
        select.selectByValue(adults);
        select=selectClass(selectChildren());
        select.selectByValue(children);
    }
    public void searchAndClickOnFlight(String mailId,String title,String day,String month,String year,String nationality){
        clickSearchFlight().click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(clickOnBookButton()));
        clickOnBookButton().click();
        String parentWindow=getDriver().getWindowHandle();
        for (String childWindowHandle : getDriver().getWindowHandles()) {
            if (!childWindowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(childWindowHandle);
                clickOnContinue().click();
                getWebDriverWait().until(ExpectedConditions.visibilityOf(setMailId()));
                setMailId().clear();
                setMailId().sendKeys("sharmaneeraj8988155@gmail.com");
                loginContinue().click();
                select=selectClass(setPersonTitle());
                select.selectByValue(title);
                setFirstName().sendKeys(UUID.randomUUID().toString());
                setLastName().sendKeys(UUID.randomUUID().toString());
                setDatePfBirth(day,month,year);
                selectFromCityDropDown(nationality);
                clickTravellerButton().click();
                getWebDriverWait().until(ExpectedConditions.visibilityOf(makePayment()));
                Assert.assertTrue(makePayment().isDisplayed(),"make payment option is not displayed");
            }
        }

    }
    public void setDatePfBirth(String day,String month,String year){
        select=selectClass(selectDay());
        select.selectByValue(day);
        select=selectClass(selectMonth());
        select.selectByValue(month);
        select=selectClass(selectYear());
        select.selectByValue(year);

    }

    public void selectFromCityDropDown(String fromCity) {
        for (WebElement city : selectFromCity()) {
            if (city.getText().contains(fromCity)) {
                city.click();
                break;
            }
        }

    }

    public void selectToCityDropDown(String toCity) {
        for (WebElement city : selectToCity()) {
            if (city.getText().contains(toCity)) {
                city.click();
                break;
            }
        }

    }


}
