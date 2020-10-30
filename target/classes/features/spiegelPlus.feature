@spiegelPlus   @end
Feature: Spiegel 1

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    Then I click SpiegelPlus

  Scenario: Spiegel plus read section 1 articles
    Then I click first article of "first" section
    Then I scroll down
    Then I go back
    Then I click last article of "first" section
    Then I scroll down
    Then I go back
    Then I paginate to "next" page
    Then I scroll down
    Then I paginate to "previous" page
    Then I click a random article of "first" section
    Then I scroll down
    Then I go back

  Scenario: Spiegel plus read random section articles
    Then I scroll to random section
    Then I click first article of "random" section
    Then I scroll down
    Then I go back
    Then I click a random article of "random" section
    Then I scroll down
    Then I go back

  Scenario: Spiegel plus read audio section articles
    Then I scroll to "audio" section
    Then I click first article of "audio" section
    Then I scroll down
    Then I go back
    Then I click a random article of "audio" section
    Then I scroll down
    Then I go back

  Scenario: Spiegel plus read alle Beiträge section articles
    Then I scroll to "alle_Beitraege" section
    Then I scroll to alle Beitraege "last" article
    Then I scroll to alle_Beitraege "random" article
    Then I click a "random" article of alle Beitraege section
    Then I scroll down
    Then I go back