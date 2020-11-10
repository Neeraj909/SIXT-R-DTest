import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ClearTripUiAction extends ClearTripRepo {
    public static Select select;
    public void bookFlight(String fromCity, String toCity,String adults,String children) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(clickOnRoundTrip()));
        clickOnRoundTrip().click();
        searchFromCity().clear();
        searchFromCity().sendKeys(fromCity);
        meditate(5);
        selectFromCityDropDown(fromCity," ui-id-1");
        searchToCity().clear();
        searchToCity().sendKeys(toCity);
        meditate(5);
        selectFromCityDropDown(toCity,"ui-id-2");
        clickOnDateIcon().get(0).click();
        typeDepartDate(23,11,2020);
        meditate(3);
        typeDepartDate(25,12,2020);
        select=selectClass(selectAdults());
        select.selectByValue(adults);
        select=selectClass(selectChildren());
        select.selectByValue(children);
    }
    public void searchAndClickOnFlight(String mailId){
        clickSearchFlight().click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf( clickOnButton("Book").get(0)));
        clickOnButton("Book").get(0).click();
        String parentWindow=getDriver().getWindowHandle();
        for (String childWindowHandle : getDriver().getWindowHandles()) {
            if (!childWindowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(childWindowHandle);
                clickOnButton("Continue").get(0).click();
                getWebDriverWait().until(ExpectedConditions.visibilityOf(setAccountInfo("Mobile number").get(0)));
                setAccountInfo("Mobile number").get(0).sendKeys("1234567890");
                setAccountInfo("Email address").get(0).sendKeys(mailId);
                selectCheckBox().get(2).click();
                clickOnButton("Continue").get(1).click();
                setAccountInfo("First name").get(0).sendKeys("Neeraj");
                setAccountInfo("First name").get(1).sendKeys("Anisha");
                setAccountInfo("First name").get(2).sendKeys("Betu");
                setAccountInfo("Last name").get(0).sendKeys("Sharma");
                setAccountInfo("Last name").get(1).sendKeys("Sharma");
                setAccountInfo("Last name").get(2).sendKeys("Sharma");
                setAccountInfo("DD / MM / YYYY").get(0).sendKeys("01/01/1992");
                setAccountInfo("DD / MM / YYYY").get(1).sendKeys("01/01/1992");
                setAccountInfo("DD / MM / YYYY").get(2).sendKeys("01/01/2010");
                for(int i=10;i<setData().size();i=i+2){
                    setData().get(i).findElement(By.xpath(".//div/div/button")).click();
                    setData().get(i).findElements(By.xpath(".//div/div/div/ul/li")).get(0).click();
                }
                for(int i=11;i<setData().size();i=i+2){
                    setData().get(i).findElement(By.xpath(".//div/div/div/div/input")).sendKeys("India");
                }

                clickOnButton("Continue to payment").get(0).click();
            }
        }

    }
    public void searchFlight() throws InterruptedException {
        clickSearchFlight().click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf( clickOnButton("Book").get(0)));
        clickOnButton("Book").get(0).click();
        String parentWindow=getDriver().getWindowHandle();
        for (String childWindowHandle : getDriver().getWindowHandles()) {
            if (!childWindowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(childWindowHandle);
                getWebDriverWait().until(ExpectedConditions.visibilityOf(clickOnContinue()));
                meditate(3);
                clickOnContinue().click();
                getWebDriverWait().until(ExpectedConditions.visibilityOf(loginContinue()));
                setMailId().sendKeys("sharmaneeraj8988155@gmail.com");
                loginContinue().click();
                select=selectClass(setPersonDetail("AdultTitle1"));
                select.selectByVisibleText("Mr");
                select=selectClass(setPersonDetail("AdultTitle2"));
                select.selectByVisibleText("Mr");
                select=selectClass(setPersonDetail("ChildTitle1"));
                select.selectByVisibleText("Mstr");
                select=selectClass(setPersonDetail("AdultDobDay1"));
                select.selectByVisibleText("1");
                select=selectClass(setPersonDetail("AdultDobMonth1"));
                select.selectByVisibleText("Jan");
                select=selectClass(setPersonDetail("AdultDobYear1"));
                select.selectByVisibleText("1992");
                select=selectClass(setPersonDetail("AdultDobDay2"));
                select.selectByVisibleText("1");
                select=selectClass(setPersonDetail("AdultDobMonth2"));
                select.selectByVisibleText("Jan");
                select=selectClass(setPersonDetail("AdultDobYear2"));
                select.selectByVisibleText("1992");
                select=selectClass(setPersonDetail("ChildDobDay1"));
                select.selectByVisibleText("1");
                select=selectClass(setPersonDetail("ChildDobMonth1"));
                select.selectByVisibleText("Jan");
                select=selectClass(setPersonDetail("ChildDobYear1"));
                select.selectByVisibleText("2010");
                setPersonName("AdultFname1").sendKeys("Neeraj");
                setPersonName("AdultFname2").sendKeys("Anisha");
                setPersonName("AdultLname1").sendKeys("Sharma");
                setPersonName("AdultLname2").sendKeys("Sharma");
                setPersonName("ChildFname1").sendKeys("Betu");
                setPersonName("ChildLname1").sendKeys("Sharma");
                selectFromCityDropDown("India","ui-id-1");
                selectFromCityDropDown("India","ui-id-2");
                selectFromCityDropDown("India","ui-id-3");
                setPersonName("contact1").sendKeys("1234567890");
                clickTravellerButton().click();
                getWebDriverWait().until(ExpectedConditions.visibilityOf(makePayment()));
                Assert.assertEquals(makePayment().isDisplayed(), true);


            }
        }
    }

    public void selectFromCityDropDown(String fromCity,String id) {
        for (WebElement city : selectFromCity(id)) {
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
