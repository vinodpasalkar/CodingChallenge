 Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Get all items and validate that LON, MAN, CAM and LCS were returned in the response
Meta:
@004
Given I get all the items
Then City LON should be present in it
Then City MAN should be present in it
Then City CAM should be present in it
Then City LCS should be present in it

Scenario: Get each item (LON, MAN, CAM and LCS) individually and validate the response
!-- we can execute same scenario for each city separately.
Meta:
@005
Given I get the data for city <cityName>
Then It contains valid data for <cityName>
Examples:
|cityName|
|LON     |


Scenario: Try to get information for non-existent locations and validate the response
!-- Try to hit the get data api for Newyork city
Meta:
@006
Given I get the data for city NEW
Then It returns invalid response

Scenario: Write a test that would validate new item addition using POST and the response
returns all the items.
Meta:
@007
Given I add a new city PAC
When I get all the items
Then City LON should be present in it
Then City MAN should be present in it
Then City CAM should be present in it
Then City LCS should be present in it
Then City PAC should be present in it







