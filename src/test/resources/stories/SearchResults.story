Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: Search and verify results on ebay wesite for a non-registered user.
!-- This scenario can be reused for another items as well
Meta:
@001
Given I am a non-registered customer
And I navigate to www.ebay.co.uk
When I search for an item <itemName>
Then I get a list of matching results
And the resulting items cards show: postage price, No of bids, price or show BuyItNow tag
Then I can sort the results by Lowest Price
And the results are listed in the page in the correct order
Then I can sort the results by Highest Price
And the results are listed in the page in the correct order
Then I can filter the results by Buy it now
And all the results shown in the page have the Buy it now tag
Examples:
|itemName|
|shirt   |


Scenario: Search per category on ebay website for a non-registered user.
Meta:
@002
Given I am a non-registered customer
And I navigate to www.ebay.co.uk
When I enter a <searchTerm> and select a <searchCategory>
Then I get a list of matching results
And I can verify that the results shown as per the the <searchCategory>
Examples:
|searchTerm |searchCategory |
|Bikes      | Cycling       |


Scenario: Search and navigate through results pages for a non-registered user.
Meta:
@003
Given I am a non-registered customer
And I navigate to www.ebay.co.uk
When I search for an item shirt
Then I get a list of matching results
And the results show more than one page
Then the user can navigate through the pages to continue looking at the items