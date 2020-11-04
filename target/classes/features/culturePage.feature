@spiegelCulture
Feature: Spiegel Lpus

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    Then I bring culture menu into view
    And I click TopMenu culture

    @culture
    Scenario Outline: navigate on culture sub-menu
      Then I click culture <menu>
      Then I click a "random" article of alle Beitraege section
      Then I click page down 3
      Then I go back to "<menu> - Kultur - DER SPIEGEL"
      Examples:
        |menu|
        | Kino |
        | Musik |
        | TV |
        | Literatur |
