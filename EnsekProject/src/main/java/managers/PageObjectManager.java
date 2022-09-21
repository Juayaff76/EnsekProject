package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.EnsekAppPage;

public class PageObjectManager<StaffListSteps, StaffListPage> {

	private WebDriver driver;

	private EnsekAppPage ensekAppPage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public EnsekAppPage getensekAppPage() {
		return (ensekAppPage == null) ? ensekAppPage = new EnsekAppPage(driver) : ensekAppPage;
	}

}
