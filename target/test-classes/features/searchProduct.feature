Feature: Search and Place the order for Products

@OffersPage
Scenario: Search Experience for Product search in both home and offers page
Given User is on GreenCart Landing page
When User searched with Shortname "<Name>" and extracted actual name of product
Then User searched for "<Name>" shortname in offers page 
And validate product name in offers page matches with Landing page

Examples:
| Name 	|
| Tom	|
| Cucu	|
| Beet  |
