@spiegelPlus   @end
Feature: Spiegel 1

  Background:
    Given I start Spiegel

    Then I click Akzeptieren und weiter

  Scenario: surf on menu page
    #Given I start Spiegel
    #Then I click Akzeptieren und weiter
    Then I click SpiegelPlus
    Then I click first article of first section
    Then I scroll down
    Then I go back
    Then I click last article of first section
    Then I scroll down
    Then I go back
    Then I paginate to "next" page
    Then I scroll down
    Then I paginate to "previous" page
    Then I click an random article of first section
    Then I scroll down
    Then I go back


