Feature: Ensek Basic Functionality 



Scenario: Verify EnergyPage feature 
	Given  Launch Ensek App 
	And Click on BuyEnergy 
	Then user should land on Energy Page 
	
Scenario: Verify buy  Electricity 
	Given  Launch Ensek App 
	And Click on BuyEnergy 
	Then I enter the units to buy 
	Then I click buy button 
	Then T verify the sale has been sucessful 
Scenario: Verify buy  gas 
	Given  Launch Ensek App 
	And Click on BuyEnergy 
	Then I enter the units of gas to buy 
	Then I click buy button 
	Then T verify the sale has been sucessful