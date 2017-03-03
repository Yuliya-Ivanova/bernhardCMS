Meta:
@entity

Narrative:
As a user
I want to create a category from Rooms panel and publish it

Scenario: Navigate to Rooms panel
Given login as a admin
Then the body of app is loaded

When I select Catalog tab of header navigation
Then assert that header tab Catalog is active
Then I assert that secondary tabs are displayed

When I navigate to Rooms tab
Then room tab is opened
And New Category button is displayed

Scenario: New category creating, saving and publishing
When select New Category button
And input in category name field Automation_Test_1
And input in category email field Test1@gmail.com

When I click on Save button
Then created category Automation_Test_1 is displayed in left menu

When I click on Publish button
Then button Publish is not displayed

Scenario: Cleanup steps
When I click on Delete button
Then created category Automation_Test_1 is not displayed in left menu