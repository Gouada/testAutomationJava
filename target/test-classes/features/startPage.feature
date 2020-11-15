@spiegelStartPage
#noinspection SpellCheckingInspection,NonAsciiCharacters
Feature: Spiegel StartPage

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter


  #@readlatestNewsArticle
  #Scenario: reading main article
   # Then On start page I click random article of latests_news_section
   # Then I click page down 6
  #  Then I click page up 3
   # Then I go back to "DER SPIEGEL | Online-Nachrichten"

    @readMainArticle
    Scenario: reading main article
    Then I click start page main_article
    Then I click page down 6
    Then I click page up 3
    Then I go back to "DER SPIEGEL | Online-Nachrichten"

  @readNewsSectionArticles
  Scenario: read news section articles
    And I scroll to "news_section" on start page
    Then On start page I click first article of news_section
    Then I click page down 6
    Then I click page up 3
    Then I go back to "DER SPIEGEL | Online-Nachrichten"
    And I scroll to "news section" on start page
    Then I scroll to random article of news_section
    Then On start page I click random article of news_section
    Then I click page down 6
    Then I click page up 3


  @alleRubriken
  Scenario Outline: alle Rubriken
    And I scroll to "alle_rubriken_section" on start page
    Then On start page I click random article of <rubrik>
    Then I click page down 6
    Then I click page up 3
    Then I go back to "DER SPIEGEL | Online-Nachrichten"

    Examples:
      | rubrik|
      | panorama_rubrik |
      | politik_rubrik |
      | wirtschaft_rubrik |
      | manager_magazin_rubrik|

  @stockSection
  Scenario: stock section
    And I scroll to "stock_section" on start page
    Then I click 3 times "stock" section arrow "right"
    Then I click 2 times "stock" section arrow "left"
    Then I click dow jones
    Then I switch to "dow jones" tab
    Then I click page down 2
    Then I switch to "spiegel" tab

  @blockchannel
  Scenario Outline: block channel section
    And I scroll to "block_channel_section" on start page
    Then On start page I click random article of <channel>
    Then I click page down 6
    Then I click page up 3
    Then I go back to "DER SPIEGEL | Online-Nachrichten"

    Examples:
      | channel|
      | geschichte_channel |
      | netzwelt_channel |
      | mobilität_channel |
      | kultur_channel |
      | start_channel |
      | wissenschaft_channel |

  @readLebenSectionArticles
  Scenario: leben section articles
    And I scroll to "leben_section" on start page
    Then On start page I click first article of leben_section
    Then I click page down 6
    Then I click page up 3
    Then I go back to "DER SPIEGEL | Online-Nachrichten"
    And I scroll to "leben_section" on start page
    Then I scroll to random article of leben_section
    Then On start page I click random article of leben_section
    Then I click page down 6
    Then I click page up 3

  @highlightSection
  Scenario: highligh section
    And I scroll to "highlight_section" on start page
    Then On start page I click first article of highlight_section
    Then I click page down 15
    Then I click page up 15
    Then I go back to "DER SPIEGEL | Online-Nachrichten"
