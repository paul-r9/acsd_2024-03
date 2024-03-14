package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDouble_Dummy {

    private final String IGNORED_STRING = "ignored";
    private final int IGNORED_INT = -99;

    /*
      This test will fail if the item name is null.
      The behavior does not interact with the item name but requires a non-null, non-special name.
     */
    @Test
    public void SellIn_Decreases_GenericItem() {
        // Arrange
        Item[] items = new Item[] { new Item(IGNORED_STRING, 10, IGNORED_INT) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(9, sut.items[0].sellIn);
    }
}
