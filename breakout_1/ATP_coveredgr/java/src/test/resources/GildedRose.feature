Feature: Gilded Rose conjured item
  I want to know the quality is updated properly
  Conjured decrease twice as fast in quality

  Scenario: Conjured item before SellIn date
    Given The item as "Conjured Mana Bun"
    And The item has Sellin of 10
    And the item has Quality of 5
    When I update the quality
    Then I should get item with Quality of 3

  Scenario: Conjured item after SellIn date
    Given The item as "Conjured Mana Bun"
    And The item has Sellin of 0
    And the item has Quality of 10
    When I update the quality
    Then I should get item with Quality of 6

