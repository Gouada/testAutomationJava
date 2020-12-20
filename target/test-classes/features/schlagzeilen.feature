@spiegelSchlagzeilen
#@test-suite-start
#@test-suite-end
#noinspection SpellCheckingInspection,NonAsciiCharacters
Feature: Spiegel Schlagzeilen

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    And I click TopMenu "Schlagzeilen"

  @start
  @end
  @readSchlagzeilenArticle
  Scenario: reading Schlagzeilen article
    Then I click a "first" article of alle Beitraege section
    Then I click page down 6
    Then I go back to "Schlagzeilen - DER SPIEGEL"
    Then I click a "random" article of alle Beitraege section
    Then I click page down 6
    Then I go back to "Schlagzeilen - DER SPIEGEL"