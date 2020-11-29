@spiegelLeftMenuNavigation
Feature: Spiegel Left Menu Navigation

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    And I click TopMenuButton

  #@startSpiegelForNavigation
  #Scenario: Start Spiegel
   # Given I start Spiegel
    #Then I click Akzeptieren und weiter

  @search
  Scenario Outline: search
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
      | Obama |
      | Lebron James |
      | Thaler Richard |
      | Kahneman Daniel |
      | Fama Eugene |
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
        |Technik | Wissenschaft |
        |Weltall | Wissenschaft |
        |Medizin | Wissenschaft |
        |Familie | Leben |
        #|Börse   |Wirtschaft|
        |Young-Money-Blog | Wirtschaft |
        |Städte der Zukunft | Wirtschaft |
        |Champions League | Sport |
        |Business|English|