@spiegelLeftMenuNavigation
#@test-suite
Feature: Spiegel Left Menu Navigation

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    And I click TopMenuButton

  #@startSpiegelForNavigation
  #Scenario: Start Spiegel
   # Given I start Spiegel
    #Then I click Akzeptieren und weiter

  @start
  @search
  Scenario Outline: LeftMenuSearch
    Then I enter <serach_word> and press enter
    Then I click weiter 3
    Then I click zurück 1
    Then I click a "random" article on search results page
    Then I click page down 3
    Then I go back to "Suche - DER SPIEGEL"
    Then I filter results by "Letztes Jahr"
    Then I filter results by "seit 2005"
    Examples:
      | serach_word |
      | Barack Obama |
      | Lebron James |
      | Thaler Richard |
      | Kahneman Daniel |
      | Angela Merkel |

  @leftMenu
  Scenario Outline: Leftmenu
    #And I click TopMenuButton
      #Then I scroll to leftMenu "menu"
      #Then I expand leftMenu "menu"
      #Then I click leftMenu "menu"
    Then I click leftMenu <menu>
    Then I click a "random" article of alle Beitraege section
    Then I click page down 3
      #Then I go back to <subMenu>
    Examples:
      |menu|
      | Job & Karriere |
      | Start |
      | Coronavirus |
      | Meinung |
      | Backstage |
      #| Nachrichtenarchiv |

    #@end
    #@start
    @leftSubmenu
    Scenario Outline: Left Submenu
      #Then I scroll to leftMenu "menu"
      #Then I expand leftMenu "menu"
      #Then I click leftMenu "menu"
      Then I click leftSubMenu <subMenu> in <menu>
      Then I click a "random" article of alle Beitraege section
      Then I click page down 3
      #Then I go back to <subMenu>
      Examples:
        |subMenu  | menu|
        |Bundesregierung | Politik |
        |Afrika | Ausland |
        |Leute | Panorama |
        |Bildung | Panorama |
        |Psychologie | Leben |
        |Technik | Wissenschaft |
        |Weltall | Wissenschaft |
        |Young-Money-Blog | Wirtschaft |
        |Champions League | Sport |

      @end
      Scenario: clossing browser