#Author: Bhanu
Feature: Test scenarios for Products Cart feature

  Background: 
    Given user open the browser
    And user navigates to the Demoblaze site

  @tag1
  Scenario: To verify products can be added and deleted in the Cart
    When user clicks on "Laptops" under Categories
    And user clicks on product "Sony vaio i5" link
    Then check product page for "Sony vaio i5" is displayed with price "$790 *includes tax"
    When user clicks on 'Add to cart' button
    Then verify alert popup displayed with text "Product added"
    When user clicks on "Home" menu link
    And user clicks on "Monitors" under Categories
    And user clicks on product "ASUS Full HD" link
    Then check product page for "ASUS Full HD" is displayed with price "$230 *includes tax"
    When user clicks on 'Add to cart' button
    Then verify alert popup displayed with text "Product added"
    When user clicks on "Cart" menu link
    Then verify product with title "Sony vaio i5" and price "790" is added in the cart
    Then verify product with title "ASUS Full HD" and price "230" is added in the cart
    When user clicks Delete for product with title "ASUS Full HD" in the cart
    Then verify product with title "ASUS Full HD" is removed from the cart

  @tag2
  Scenario: To verify user can Place Order successfully after products are added in the Cart
    When user clicks on "Laptops" under Categories
    And user clicks on product "MacBook air" link
    Then check product page for "MacBook air" is displayed with price "$700 *includes tax"
    When user clicks on 'Add to cart' button
    Then verify alert popup displayed with text "Product added"
    When user clicks on "Home" menu link
    And user clicks on "Monitors" under Categories
    And user clicks on product "ASUS Full HD" link
    Then check product page for "ASUS Full HD" is displayed with price "$230 *includes tax"
    When user clicks on 'Add to cart' button
    Then verify alert popup displayed with text "Product added"
    When user clicks on "Cart" menu link
    Then verify product with title "MacBook air" and price "700" is added in the cart
    Then verify product with title "ASUS Full HD" and price "230" is added in the cart
    And check Total price of "930" is shown in the cart
    When user clicks on 'Place Order' button
    Then check order modal with "Total: 930" is displayed
    When user enter order form details as:
     #| Name | Country | City  | Credit card      | Month | Year |
      | Anil | India   | Delhi | 1234111122220000 |    01 | 2025 |
    Then check popup with 'Success' icon is displayed
    Then verify popup shows "Thank you for your purchase!" with details as:
      | 930 USD | 1234111122220000 | Anil |
    When user clicks OK on confirmation popup
    Then verify that demoblaze home page is displayed

  @tag3
  Scenario: To verify user cannot Place Order without required fields (Name and Card Number)
    When user clicks on "Laptops" under Categories
    And user clicks on product "Sony vaio i7" link
    Then check product page for "Sony vaio i7" is displayed with price "$790 *includes tax"
    When user clicks on 'Add to cart' button
    Then verify alert popup displayed with text "Product added"
    When user clicks on "Cart" menu link
    Then verify product with title "Sony vaio i7" and price "790" is added in the cart
    And check Total price of "790" is shown in the cart
    When user clicks on 'Place Order' button
    Then check order modal with "Total: 790" is displayed
    When user enter order form details as:
     #| Name | Country | City | Credit card | Month | Year |
      | John |         |      |             |       |      |
    Then verify alert popup displayed with text "Please fill out Name and Creditcard."
    When user enter order form details as:
     #| Name | Country | City | Credit card | Month | Year |
      | John |         |      | 12341111000 |       |      |
    Then check popup with 'Success' icon is displayed
    Then verify popup shows "Thank you for your purchase!" with details as:
      | 790 USD | 12341111000 | John |
    When user clicks OK on confirmation popup
    Then verify that demoblaze home page is displayed

  @tag4
  Scenario: Verify products added in cart by a user are not visible after user has log out, and are visible when user logs in again
    When user clicks on "Log in" menu link
    Then check Login dialog is displayed
    When I enter Username "b_suri" and Password "welcome2023" and click on Log in
    Then verify welcome message is displayed with text "Welcome b_suri"
    When user clicks on "Phones" under Categories
    And user clicks on product "Nokia lumia 1520" link
    Then check product page for "Nokia lumia 1520" is displayed with price "$820 *includes tax"
    When user clicks on 'Add to cart' button
    Then verify alert popup displayed with text "Product added."
    When user clicks on "Cart" menu link
    Then verify product with title "Nokia lumia 1520" and price "820" is added in the cart
    And check Total price of "820" is shown in the cart
    When user clicks on "Log out" menu link
    Then verify user is logged out
    When user clicks on "Cart" menu link
    Then verify the Cart table is empty
    When user clicks on "Log in" menu link
    Then check Login dialog is displayed
    When I enter Username "b_suri" and Password "welcome2023" and click on Log in
    Then verify welcome message is displayed with text "Welcome b_suri"
    Then verify product with title "Nokia lumia 1520" and price "820" is added in the cart
    And check Total price of "820" is shown in the cart
    When user clicks on 'Place Order' button
    Then check order modal with "Total: 820" is displayed
    When user enter order form details as:
     #| Name  | Country | City | Credit card | Month | Year |
      | Bhanu |         |      | 12341111000 |       |      |
    Then check popup with 'Success' icon is displayed
    And verify popup shows "Thank you for your purchase!" with details as:
      | 820 USD | 12341111000 | Bhanu |
    When user clicks OK on confirmation popup
    Then verify that demoblaze home page is displayed
