Feature: E-Commerce Checkout Automation

  @test
  Scenario: Add vegetables to cart and checkout with valida promo
    Given I am on the products page
    When I add "Brocolli", "Pomegranate", "Mushroom", "Walnuts", "Beetroot" to cart
    Then cart should have "5" items
    And total price should match calculated sum
    When I proceed to checkout and apply promo "rahulshettyacademy"
    Then discount should be applied and order placed successfully

