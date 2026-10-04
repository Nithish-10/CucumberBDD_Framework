Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for Product search in both home and offers page
  Given User is on GreenCart Landing page
  When User searched with Shortname "<Name>" and extracted actual name of product
  And Added "3" items of the selected product to cart
  Then User proceed to checkout and validate the "<Name>" items in checkout page
  And Verify user has ability to enter promo code and place the order

Examples:
  | Name |
  | Tom  |
  | Cucu |
  | Beet |
