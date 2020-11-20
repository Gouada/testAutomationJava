@spiegelCoronavirus
Feature: Coronavirus

  Background:
    Given I start Spiegel
    Then I click Akzeptieren und weiter
    #And I click TopMenu "SPIEGEL+"
    Then I click TopMenu "Coronavirus"

  @first_sectionCoronaVirus
  Scenario: Spiegel Coronavirus read section 1 articles
    Then I click first article of "first" section
    Then I click page down 3
    Then I go back to "Coronavirus - DER SPIEGEL"
    Then I click last article of "first" section
    Then I click page down 3
    Then I go back to "Coronavirus - DER SPIEGEL"
    Then I paginate to "next" page
    Then I click page down 3
    Then I paginate to "previous" page
    Then I click a random article of "first" section
    Then I click page down 3

  Scenario: Spiegel Coronavirus read random section articles
    Then I scroll to "random" section
    Then I click first article of "random" section
    Then I click page down 3
    Then I close the tab
    #Then I go back to "Coronavirus - DER SPIEGEL"
    Then I click a random article of "random" section
    Then I click page down 3
    Then I close the tab
    #Then I go back to "Coronavirus - DER SPIEGEL"

  #@end
  Scenario: Spiegel Coronavirus read alle Beiträge section articles
    Then I scroll to "alle_Beitraege" section
    Then I scroll to alle Beitraege "last" article
    Then I scroll to alle Beitraege "random" article
    Then I click a "random" article of alle Beitraege section
    Then I click page down 3
    Then I go back to "Coronavirus - DER SPIEGEL"
    Then I paginate to "next" page
