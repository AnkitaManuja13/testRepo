Feature: To verify the functionality for the WEB FE Application


  Scenario: To verify the Web FE Application Functionality
    Given User hit the Web FE URL
    When User navigation through product categories: Phones, Laptops and Monitors and select Sony Laptop and Accept Pop up Confirmation
    Then  User Navigate to Laptop then Dell i7 8gb and click on Add to cart. Accept pop up confirmation
    Then Navigate to Cart and Delete Dell i7 8gb from cart.
    Then Click on Place order.
    Then Fill in all web form fields and click on purchase
    Then Capture and log purchase Id and Amount.
    Then  Assert purchase amount equals expected.
    Then Click on OK.




