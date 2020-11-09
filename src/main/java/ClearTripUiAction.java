import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClearTripUiAction extends ClearTripRepo {
    public void bookFlight(String fromCity, String toCity) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(clickOnRoundTrip()));
        clickOnRoundTrip().click();
        searchFromCity().clear();
        searchFromCity().sendKeys(fromCity);
        selectFromCityDropDown(fromCity);
        searchToCity().clear();
        searchToCity().sendKeys(toCity);
        selectToCityDropDown(toCity);
        clickOnDateIcon().get(0).click();

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
