package gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (doesntImproveWithAge(item)) {
                decrementQualityIfNotLegendary(item);
            } else {
                incrementQualityForItemsThatGetBetterWithAge(item);
            }

            decrementSellIn(item);

            if (isExpired(item)) {
                handleExpiredItem(item);
            }
        }
    }

    private static boolean doesntImproveWithAge(Item item) {
        return !item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES);
    }

    private static void incrementQualityForItemsThatGetBetterWithAge(Item item) {
        if (isUnderMaxQuality(item)) {
            incrementItemQuality(item);

            if (item.name.equals(BACKSTAGE_PASSES)) {
                increaseQualityAsConcertNears(item);
            }
        }
    }

    private static void handleExpiredItem(Item item) {
        if (!item.name.equals(AGED_BRIE)) {
            if (!item.name.equals(BACKSTAGE_PASSES)) {
                decrementQualityIfNotLegendary(item);
            } else {
                isNotSellable(item);
            }
        } else {
            if (isUnderMaxQuality(item)) {
                incrementItemQuality(item);
            }
        }
    }

    private static void decrementSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private static void increaseQualityAsConcertNears(Item item) {
        if (isLastTenDays(item)) {
            if (isUnderMaxQuality(item)) {
                incrementItemQuality(item);
            }
        }

        if (isLastFiveDays(item) && (isUnderMaxQuality(item))) {
                incrementItemQuality(item);
        }
    }

    private static boolean isLastTenDays(Item item) {
        return item.sellIn < 11;
    }

    private static boolean isLastFiveDays(Item item) {
        return item.sellIn < 6;
    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private static void isNotSellable(Item item) {
        item.quality = 0;
    }

    private static void decrementQualityIfNotLegendary(Item item) {
        if (hasQuality(item)) {
            if (item.name.startsWith("Conjured")){
                decrementItemQuality(item);
            }
            if (!item.name.equals(SULFURAS)) {
                decrementItemQuality(item);
            }
        }
    }

    private static boolean hasQuality(Item item) {
        return item.quality > 0;
    }

    private static boolean isUnderMaxQuality(Item item) {
        return item.quality < 50;
    }

    private static void decrementItemQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private static void incrementItemQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
