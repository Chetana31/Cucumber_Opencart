Feature: User Registration 

	@regression
		Scenario Outline: Succesfull add MyInfo
			Given the user navigates to the MyInfo
			When user enters the Personal Details
				| firstname | Cucumber |
				| lasttname | Demo |
				| Employee Id | 123123 |
				| Other Id    | 321321 |
			And the user clicks on the Save button
			Then the user should be refresh MyInfo Page
		
	