package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDouble_Fake {

    private static final String GENERIC = "generic";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String LEGENDARY_SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int LEGENDARY_ITEM_QUALITY = 80;

    @Test
    public void GenericItem_SellIn_Decreases() {
        Item[] items = stockOneOfEachItem();
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(9, sut.items[0].sellIn);
    }

    @Test
    public void LegendaryItem_QualityDoesNotChange() {
        Item[] items = stockOneOfEachItem();
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(LEGENDARY_ITEM_QUALITY, sut.items[5].quality);
    }


    private Item[] stockOneOfEachItem() {
        return new Item[]{
                new Item(GENERIC, 10, 20),
                new Item(AGED_BRIE, 5, 10),
                new Item(BACKSTAGE_PASS, 20, 7),
                new Item(BACKSTAGE_PASS, 3, 15),
                new Item(BACKSTAGE_PASS, -1, 0),
                new Item(LEGENDARY_SULFURAS, 25, LEGENDARY_ITEM_QUALITY),
        };
    }
}
