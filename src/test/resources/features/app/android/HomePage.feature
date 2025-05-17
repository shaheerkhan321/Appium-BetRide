Feature: Home Page Testing App

 @android @final

    Scenario: Verify user is able to Login to application
    Given User is on Get Ride Requests screen
    When User taps on "تخطي >"
    Then User should see "اختر لغتك المفضلة"
    When User taps on "English"
    And User taps on "تأكيد اللغة"
    Then User should see "Enter your Whatsapp number"
    When User taps on Phone Number field
    And User type "650629209" in Phone Number field
    And User clicks on Accept Agreements and Terms checkbox
    And User taps on "Submit"
    Then User should see "OTP Verification"
    When user enter "12345" in otp field
    Then User should see "Your Status:"
    When user taps on profile button
    And User taps on the "Logout"
    Then user should see Alert Message
    When User taps on "Yes"
    Then User should see "Enter your Whatsapp number"









    # And User enters "0000" in email field
    # And User taps on Password field
    # And User enters "Cl3@rC@pt10ns!" in password field
    # And User taps on Signin button
    # Then User should see Select Environment screen
    # When User taps on Production
    # And User taps on Save button
    # Then User should see home screen
    # When User taps on Email field
    # And User enters "ahsan.kahn+996@vimient.com" in email field
    # And User taps on Password field
    # And User enters "Vista!@#135!@#" in password field
    # And User taps on Signin button
    # Then User should see welcome screen
    # When User taps on continue button
    # And User taps on next button
    # Then User should see Wellness Dashboard
    # When User taps on menu button
    # And User taps on Signout button
    # Then User should see home screen





#    Then  [Home Page] Verify the Version Code version code : 106


#  Scenario: Verify the version code and version name display on home page
#    Given [Home Page] App should open successfully
#    Then  [Home Page] Verify the Version Code version code : 106
#    And   [Home Page] Verify the Version Name version name : 12.0
#
#   @android @final
#  Scenario: Verify the Immediate button and its feature is working as requirement
#    Given [Home Page] App should open successfully
#    Then [Home Page] Verify the Immediate Update button is visible
#    When [Home Page] User tap on Immediate Update Button
#    When [Home Page] User tap on Button 1
#    Then [Home Page] Verify that Result 1 is displayed
#    When [Home Page] User tap on Button 2
#    Then [Home Page] Verify that Result 2 is displayed
#    When [Home Page] User tap on Button 3
#    Then [Home Page] Verify that Result 3 is displayed
#
#  @android @final
#  Scenario: Verify the Flexible button and its feature is working as requirement
#    Given [Home Page] App should open successfully
#    Then [Home Page] Verify the Flexible Update button is visible
#    When [Home Page] User tap on Flexible Update Button
#    When [Home Page] User tap on Button 1
#    Then [Home Page] Verify that Result 1 is displayed
#    When [Home Page] User tap on Button 2
#    Then [Home Page] Verify that Result 2 is displayed
#    When [Home Page] User tap on Button 3
#    Then [Home Page] Verify that Result 3 is displayed
#
#
#  @android @final
#  Scenario: Verify the app opens and see home screen
#    Given [Home Page] App should open successfully
#    Then [Home Page] Verify that The App title is displayed on home page
#
#  @android @final
#  Scenario: Should be able to navigate through different tabs
#    Given [Home Page] App should open successfully
#    When I tap on Echo Box tab
#    And I press back button
#    When I tap on Login Screen tab
#    And I press back button
#    When I tap on Clipboard Demo tab
#    And I press back button
#    Then [Home Page] Verify that The App title is displayed on home page
##
#
#  @android @final
#  Scenario: Should be able to add text in echo box and assert the result
#    Given [Home Page] App should open successfully
#    When I tap on Echo Box tab
#    And I type hello world in text field on echo box screen
#    And I tap on save button
#    Then I should see hello world echoed text on echo box screen
#
#
#  @android @final
#  Scenario: Should be able to scroll through options to select below options
#    Given [Home Page] App should open successfully
#    When I tap on List Demo tab
#    And I scroll to Stratus accessibility id
#    And I tap on Stratus option
#    And I wait 4 seconds
#    Then I should see popup
#
#  @android @final
#  Scenario: Should be able to accept and dismiss popup
#    Given [Home Page] App should open successfully
#    When I tap on List Demo tab
#    And I scroll to Stratus accessibility id
#    And I tap on Stratus option
#    And I wait 4 seconds
#    Then I should see popup
#    And I accept popup
#    And I tap on Stratus option
#    And I wait 4 seconds
#    Then I should see popup
#    And I dismiss popup