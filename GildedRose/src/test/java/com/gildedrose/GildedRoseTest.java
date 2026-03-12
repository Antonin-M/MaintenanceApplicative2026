package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void items5_10() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new Item("test", 5,10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(4, app.items[1].sellIn);
        assertEquals(13, app.items[1].quality);

        assertEquals("test", app.items[2].name);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(9, app.items[2].quality);
    }

    @Test
    void items0_10() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 0, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
                new Item("test", 0,10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);

        assertEquals("test", app.items[2].name);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(8, app.items[2].quality);
    }

    @Test
    void items15_100() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 15, 100),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 100),
                new Item("test", 15,100)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(100, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(14, app.items[1].sellIn);
        assertEquals(100, app.items[1].quality);

        assertEquals("test", app.items[2].name);
        assertEquals(14, app.items[2].sellIn);
        assertEquals(99, app.items[2].quality);
    }

    @Test
    void items5_49() {
        Item[] items = new Item[]{
                new Item("Aged Brie", -5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("test", 5,49)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(4, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);

        assertEquals("test", app.items[2].name);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(48, app.items[2].quality);
    }

    @Test
    void items50_49() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 50, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 50, 49),
                new Item("test", 50,49)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(49, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(49, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);

        assertEquals("test", app.items[2].name);
        assertEquals(49, app.items[2].sellIn);
        assertEquals(48, app.items[2].quality);
    }

    @Test
    void items10_49() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("test", 10,49)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);

        assertEquals("test", app.items[2].name);
        assertEquals(9, app.items[2].sellIn);
        assertEquals(48, app.items[2].quality);
    }

    @Test
    void Sulfura() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 0, 100),
                new Item("Sulfuras, Hand of Ragnaros", 10, 80),
                new Item("Sulfuras, Hand of Ragnaros", -5, 50),
                new Item("Sulfuras, Hand of Ragnaros", -10, -10),

        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(100, app.items[0].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals(10, app.items[1].sellIn);
        assertEquals(80, app.items[1].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(-5, app.items[2].sellIn);
        assertEquals(50, app.items[2].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[3].name);
        assertEquals(-10, app.items[3].sellIn);
        assertEquals(-10, app.items[3].quality);
    }

    @Test
    void item() {
        Item i =  new Item("foo", 0, 0);
        assertEquals("foo, 0, 0",i.toString());
    }

}
