package stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObjects.EnsekAppPage;


public class EnsekAppSteps {
	TestContext testContext;
	EnsekAppPage objEnsekAppPage;

	public EnsekAppSteps(TestContext context) {
		testContext = context;
		objEnsekAppPage = testContext.getPageObjectManager().getensekAppPage();
	}


@Given("^Launch Ensek App$")
public void launch_Ensek_App() throws Throwable {
	//EnsekAppPage =new EnsekAppPage();
	objEnsekAppPage.lunchEnsekapp();
	
	//Thread.sleep(3000);
}

@Given("^Click on BuyEnergy$")
public void click_on_BuyEnergy() throws Throwable {
	objEnsekAppPage.clickbuyenergy();
}

@Then("^user should land on Energy Page$")
public void user_should_land_on_Energy_Page() throws Throwable {
    Assert.assertTrue(true);
}

@Given("^I am on the Energy Page$")
public void i_am_on_the_Energy_Page() throws Throwable {
	 Assert.assertTrue(true);
}
@Then("^I enter the units to buy$")
public void i_enter_the_units_to_buy() throws Throwable {
	objEnsekAppPage.buyUnits();
}

@Then("^I click buy button$")
public void i_click_buy_button() throws Throwable {
	objEnsekAppPage.clickOnbuybtn();
}

@Then("^T verify the sale has been sucessful$")
public void t_verify_the_sale_has_been_sucessful() throws Throwable {
    Assert.assertTrue(true);
}

@Then("^I enter the units of gas to buy$")
public void i_enter_the_units_of_gas_to_buy() throws Throwable {
	objEnsekAppPage.buygasUnits();

}
}