@spiegelCulture
Feature: Spiegel Kultur

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    Then I bring "Kultur" menu into view
    And I click TopMenu "Kultur"

    @culture
    Scenario Outline: navigate on culture sub-menu
      Then I click culture <menu>
      Then I click a "random" article of alle Beitraege section
      Then I click page down 3
      Then I navigate back to <menu> - Kultur - DER SPIEGEL
      Examples:
        |menu|
        | Kino |
        | Musik |
        | TV |
        | Literatur |
        |Streaming  |
        |Kunst      |
