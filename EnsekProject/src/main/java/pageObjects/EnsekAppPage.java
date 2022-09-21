package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnsekAppPage {

	WebDriver driver ;
	public EnsekAppPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	EnsekAppPage EnsekAppPage;

	@FindBy(xpath = "//a[normalize-space()='Buy energy »']")
	public WebElement buyEnergylink;

	@FindBy(xpath = "//h2[contains(text(),'Buy Energy')]")
	public WebElement BuyEnergyDisplay;

	@FindBy(xpath = "(//*[@id=\"energyType_AmountPurchased\"])[2]")
	public WebElement BuyUnits;

	@FindBy(xpath = "//tbody/tr[3]/td[4]/input[1]")
	public WebElement Buybtn;
	
	@FindBy(xpath = "(//*[@id=\"energyType_AmountPurchased\"])[1]")
	public WebElement BuygasUnits;
	
	@FindBy(xpath = "//h2[contains(text(),'Sale Confirmed')]")
	public WebElement SaleconfirmedDisplayed;

	
	
	public void lunchEnsekapp() {
		driver.get(" https://ensekautomationcandidatetest.azurewebsites.net");
		//Selenium.LocalDriver.driver.get(" https://ensekautomationcandidatetest.azurewebsites.net");

	}

	public String BuyEnergyDispaly() {
		return BuyEnergyDisplay.getText();
	}

	public void clickbuyenergy() {

		buyEnergylink.click();

	}

	public void buyUnits() throws InterruptedException {

		BuyUnits.sendKeys("20");
        Thread.sleep(3000);
	}

	public void buygasUnits() throws InterruptedException {
		BuygasUnits.sendKeys("22");
        Thread.sleep(3000);
	}
	
	
	public void clickOnbuybtn() {

		Buybtn.click();
	}

	public String saleconfirmedDisplayed() {
		return SaleconfirmedDisplayed.getText();
	}

	
	
	
//	public EnsekAppPage() {
//		driver = Selenium.LocalDriver.driver;
//		PageFactory.initElements(driver, this);
//	}

}
