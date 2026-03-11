package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void items5_10() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new Item("Sulfuras, Hand of Ragnaros", 5, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(4, app.items[1].sellIn);
        assertEquals(13, app.items[1].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(5, app.items[2].sellIn);
        assertEquals(10, app.items[2].quality);
    }

    @Test
    void items0_10() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 0, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
                new Item("Sulfuras, Hand of Ragnaros", 0, 10) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(10, app.items[2].quality);
    }

    @Test
    void items15_100() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 15, 100),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 100),
                new Item("Sulfuras, Hand of Ragnaros", 15, 100)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(100, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(14, app.items[1].sellIn);
        assertEquals(100, app.items[1].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(15, app.items[2].sellIn);
        assertEquals(100, app.items[2].quality);
    }

    @Test
    void item() {
        Item i =  new Item("foo", -999, 0);
        assertEquals("foo, 0, 0",i.toString());
        assert i.sellIn >=0: "On ne peut pas vendre à une valeur négative";
    }

}
