package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void item_name_does_not_change() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals("foo", sut.items[0].name);
    }

    @Test
    public void sellinValueIsDecreasing(){
        // Arrange
        Item[] items = new Item[] { new Item("foo", 23, 0) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(22, sut.items[0].sellIn);
    }

    @Test
    public void qualityValueIsDecreasing() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 23, 50) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(49, sut.items[0].quality);

    }

    @Test
    public void qualityDoesNotBecomeNegative() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 23, 0) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(0, sut.items[0].quality);

    }

    @Test
    public void sellinValueGetsNegative(){
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(-1, sut.items[0].sellIn);
    }

    @Test
    public void sellingQualityDecresingTwiceAfterSellbyDate(){
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 40) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(38, sut.items[0].quality);
    }
    @Test
    public void bugQualitySeemsToExceedRecMaximum(){
        // Arrange
        Item[] items = new Item[] { new Item("foo", 25, 60) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(59, sut.items[0].quality);
    }
    @Test
    public void agedBrieQualityIncreases(){
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 25, 20) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(21, sut.items[0].quality);
    }
    @Test
    public void agedBrieQualityCappedAtMaximum(){
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 25, 50) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(50, sut.items[0].quality);
    }

    @Test
    public void LegendaryItem_QualityUnchanged(){
        // Arrange
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 25, 80) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(80, sut.items[0].quality);
    }

}


