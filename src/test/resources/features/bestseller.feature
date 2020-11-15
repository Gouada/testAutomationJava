@spiegelCultureBestseller
#noinspection SpellCheckingInspection,NonAsciiCharacters
Feature: Spiegel Kultur Bestseller

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    Then I bring "Kultur" menu into view
    And I click TopMenu "Kultur"
    Then I click culture SPIEGEL-Bestseller


  @bestsellerbooks
  Scenario Outline: Bestseller Books
    Then I click bestseller <menu>
    Then I scroll to a random bestseller
    Then I click mehr anzeigen
    #Then I click page up 1
    #Then I click page down 1
    #Then I click arrow down 2
    Then I move mouse over kaufen
    Then I click bei <vendor> kaufen
    Then I close the <vendor> tab
    Examples:
      | menu| vendor |
      | Sachbuch | Thaila |
      | Belletristik | Amazon |
      | Kinder/ Jugend | Thaila |
    #Examples:
     # | |



  @bestsellerDVD
  Scenario Outline: Bestseller DVD
    Then I click bestseller DVD
    Then I click the bestseller sub_menu TV & Hobby
    Then I scroll to a random bestseller
    Then I click mehr anzeigen
    #Then I click page up 1
    #Then I click page down 1
    Then I move mouse over kaufen
    Then I click bei <vendor> kaufen
    Then I close the <vendor> tab
    Examples:
      | vendor|
      | Amazon |
      | Thaila |

  @bestsellerRatgeber
  Scenario Outline: Bestseller Ratgeber
    Then I click bestseller Ratgeber
    Then I click the bestseller sub_menu <sub_menu>
    Then I scroll to a random bestseller
    Then I click mehr anzeigen
    #Then I click page up 1
    #Then I click page down 1
    Then I move mouse over kaufen
    Then I click bei <vendor> kaufen
    Then I close the <vendor> tab
    Examples:
      | sub_menu| vendor |
      | Leben & Gesundheit | Thaila |
      | Essen & Trinken | Amazon |
      | Natur & Garten | Thaila |
      | Hobby & Kreativität| Amazon |

  @bestsellerKinderBuch
  Scenario Outline: Bestseller KinderBuch
    Then I click bestseller Kinder/ Jugend
    Then I click the bestseller sub_menu <sub_menu>
    Then I scroll to a random bestseller
    Then I click mehr anzeigen
    #Then I click page up 1
    #Then I click page down 1
    Then I move mouse over kaufen
    Then I click bei <vendor> kaufen
    Then I close the <vendor> tab
    Examples:
      | sub_menu| vendor |
      | Kinderbuch | Amazon |
      | Jugendbuch | Thaila |
      | Bilderbuch | Thaila |
      | Hörbuch| Amazon |
