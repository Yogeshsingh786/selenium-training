Feature: Addition Calculator 

Background: User accesses calculator on browser 
	Given User is on Propine Addition Calculator 
	
@positive 
Scenario Outline: User enters valid numbers as inputs for addition 
	When User enters First Number as "<FirstNumber>" and Second Number as "<SecondNumber>" 
	Then User should get addition result as "<Result>" 
	Examples: 
		|FirstNumber|SecondNumber|Result|
		|2|5|7|
		|0|0|0|
		|-1|5|4|
		|2|-5|-3|
		|-2|-5|-7|
		|1.235|-0.255|0.98|
		|-1.235|-0.255|-1.49|
		|-1.55|-0.45|-2|
		|999999999999999999|999999999999999999999|1.001e+21|
		|999.00|111.01|1110.01|
		
@negative 
Scenario Outline: User enters valid inputs but with blank spaces for addition 
	When User enters First Number as "<FirstNumber>" and Second Number as "<SecondNumber>" 
	Then User should get addition result as "<Result>" 
	Examples: 
		|FirstNumber|SecondNumber|Result|
		||5|NaN|
		|2||NaN|
		|||NaN|
		|-89-|-11-|NaN|
		|abc|xyz|NaN|
		|1.0f|2.4f|NaN|
		|10H|110H|NaN|
		|$12|$12|NaN|
		|-|-|NaN|
		|$|$|NaN|
				
				
				
		