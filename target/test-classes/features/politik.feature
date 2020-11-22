@spiegelPolitik
Feature: Spiegel Politk

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    #Then I bring "Kultur" menu into view
    And I click TopMenuButton

    @Bundesregierung
    Scenario Outline: Bundesregierung
      #Then I scroll to leftMenu "menu"
      #Then I expand leftMenu "menu"
      #Then I click leftMenu "menu"
      Then I click leftSubMenu <subMenu> in <menu>
      Then I click a "random" article of alle Beitraege section
      Then I click page down 3
      #Then I go back to <subMenu>
      Examples:
        |subMenu  | menu|
        |Bundestag  | Politik |
        |Bundesregierung | Politik |
        |Afrika | Ausland |
        |Nahost | Ausland |
        |Leute | Panorama |
        |Gesellschaft | Panorama |
        |Bildung | Panorama |
        |Psychologie | Leben |
        |Familie | Leben |
        |Business|English|
