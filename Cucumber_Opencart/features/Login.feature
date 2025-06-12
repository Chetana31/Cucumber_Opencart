Feature: User Login with valid credentials 
	
	@sanity @regression
	Scenario: Succesfull login
		Given the user navigates to login page
		When the user enters valid username as "Admin" and password as "admin123"
		And the user click on the login button
		Then the user should be redirected to the My Account page
		
#	@regression
#	Scenario Outline: Login Data Driven
#		Given the user navigates to login page
#		When the user enters valid username as "<username>" and password as "<password>"
#		And the user click on the login button
#		Then the user should be redirected to the My Account page
#		Examples:
#		| username | password  |
#		| Admin    | admin123  |
#		| Admiin   | admin1234 |		
#		| Admin    | admin123  |