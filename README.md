# SampleCucumberFramework
Cucumber Introduction <br>
A cucumber is a tool based on Behavior Driven Development (BDD) framework which is used to write acceptance tests for the web application. It allows automation of functional validation in easily readable and understandable format (like plain English) to Business Analysts, Developers, Testers, etc.<br>
<br>
Cucumber feature files can serve as a good document for all. There are many other tools like JBehave which also support BDD framework. Initially, Cucumber was implemented in Ruby and then extended to Java framework. Both the tools support native JUnit.<br>
<br>
Behavior Driven Development is an extension of Test Driven Development and it is used to test the system rather than testing the particular piece of code. We will discuss more the BDD and style of writing BDD tests.<br>
<br>
Cucumber can be used along with Selenium, Watir, and Capybara etc. Cucumber supports many other languages like Perl, PHP, Python, Net etc. In this tutorial, we will concentrate on Cucumber with Java as a language.<br>
<br>
Cucumber Basics
In order to understand cucumber, we need to know all the features of cucumber and its usage.<br>
<br>
#1) Feature Files:<br><br>
<br>
Feature files are the essential part of cucumber which is used to write test automation steps or acceptance tests. This can be used as the live document. The steps are the application specification. All the feature files end with .feature extension.<br>
<br>
Sample feature file:<br>
<br>
Feature: Login Functionality Feature<br>
<br>
In order to ensure Login Functionality works,<br>
I want to run the cucumber test to verify it is working<br>
<br>
Scenario: Login Functionality<br>
<br>
Given user navigates to HTTPS://SOME.COM<br>
When user logs in using Username as “USER” and Password “PASSWORD”<br>
Then login should be successful<br>
<br>
Scenario: Login Functionality<br>
<br>
Given user navigates to HTTPS://SOME.COM<br>
When user logs in using Username as “USER1” and Password “PASSWORD1”<br>
Then error message should be thrown<br>
<br>
#2) Feature:<br>
<br>
This gives information about the high-level business functionality (Refer to the previous example) and the purpose of Application under test. Everybody should be able to understand the intent of feature file by reading the first Feature step. This part is basically kept brief.<br>
<br>
#3) Scenario:
<br><br>
Basically, a scenario represents a particular functionality which is under test. By seeing the scenario user should be able to understand the intent behind the scenario and what the test is all about. Each scenario should follow given, when and then format. This language is called as “gherkin”.<br>
<br>
Given: As mentioned above, given specifies the pre-conditions. It is basically a known state.<br>
When: This is used when some action is to be performed. As in above example, we have seen when the user tries to log in using username and password, it becomes an action.<br>
Then: The expected outcome or result should be placed here. For Instance: verify the login is successful, successful page navigation.<br>
Background: Whenever any step is required to perform in each scenario then those steps need to be placed in Background. For Instance: If a user needs to clear database before each scenario then those steps can be put in a background.<br>
And: And is used to combine two or more same type of action.<br>
