@spiegelPlus
Feature: Spiegel Lpus

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    Then I click SpiegelPlus

  @first_section
  Scenario: Spiegel plus read section 1 articles
    Then I click first article of "first" section
    Then I click page down 3
    Then I go back to "Plus - DER SPIEGEL"
    Then I click last article of "first" section
    Then I click page down 3
    Then I go back to "Plus - DER SPIEGEL"
    Then I paginate to "next" page
    Then I click page down 3
    Then I paginate to "previous" page
    Then I click a random article of "first" section
    Then I click page down 3

  Scenario: Spiegel plus read random section articles
    Then I scroll to "random" section
    Then I click first article of "random" section
    Then I click page down 3
    Then I go back to "Plus - DER SPIEGEL"
    Then I click a random article of "random" section
    Then I click page down 3
    Then I go back to "Plus - DER SPIEGEL"

  Scenario: Spiegel plus read audio section articles
    Then I scroll to "audio" section
    Then I click first article of "audio" section
    Then I click page down 3
    Then I go back to "Plus - DER SPIEGEL"
    Then I click a random article of "audio" section
    Then I click page down 3
    Then I go back to "Plus - DER SPIEGEL"

  @end
  Scenario: Spiegel plus read alle Beiträge section articles
    Then I scroll to "alle_Beitraege" section
    Then I scroll to alle Beitraege "last" article
    Then I scroll to alle Beitraege "random" article
    Then I click a "random" article of alle Beitraege section
    Then I click page down 3
    Then I go back to "Plus - DER SPIEGEL"
    Then I paginate to "next" page
