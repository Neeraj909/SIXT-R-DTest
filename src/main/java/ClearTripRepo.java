import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClearTripRepo extends UiBase{


    public WebElement clickOnRoundTrip(){
        return getDriver().findElement(By.cssSelector("##RoundTrip"));
    }

}
