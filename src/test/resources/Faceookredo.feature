@FaceookSignup
Feature: Facebook

Background: Facebook new account
Given Webdriver launch "https://www.facebook.com"
And Navigate to create new account and click it

Scenario Outline: Create new account
When Fill in firstname "<firstname>"
And Fill in surname "<surname>"
And Fill in mail and password "<mail>""<password>"
And Select date of birth "<date>"
And Select month of birth "<month>"
And Select year of birth "<year>"
And For screenshot "<firstname>"
Then click subbmit
And Broken link "https://www.facebook.com"

Examples:
|firstname|surname |mail					 		|password |date|month|year|
|kiran		|balaji	 |56765433344		|p123456	|10 |Jan	 |1996|
#|varnikha	|thala	 |123586597987|p123457	|12 |May	 |1996|
#|ganesh		|nithin	 |7896562132	|p123458	|5 |Jun	 |2001|
#|suba			|vina	 	 |78956213215		|p123459	|26 |Feb	 |1986|
#|pari			|valavan |23516516565		|p123465	|25 |Jan	 |1980|