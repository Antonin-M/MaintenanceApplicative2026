import org.example.CalendarManager;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCalendar {

    @Test
    void addItemInCalendar() {
        CalendarManager calendar = new CalendarManager();
        assertEquals(0, calendar.events.size());

        //REMPLACER TYPE PAR UN ENUM
        //REMPLACER USER PAR UN ID
        calendar.ajouterEvent("RDV_PERSONNEL","rdvPerso","Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 30,"","",0);
        calendar.ajouterEvent("REUNION","rdvReu","Bob",LocalDateTime.of(2026, 6, 15, 16, 40), 32,"","",0);
        calendar.ajouterEvent("PERIODIQUE","rdvPerio","Pierre",LocalDateTime.of(2026, 7, 17, 17, 35), 33,"","",2);

        assertEquals(3, calendar.events.size());

        //RDV PERSONNEL
        assertEquals("RDV_PERSONNEL", calendar.events.get(0).type);
        assertEquals("rdvPerso", calendar.events.get(0).title);
        assertEquals("Benoit", calendar.events.get(0).proprietaire);
        assertEquals(LocalDateTime.of(2026, 5, 14, 15, 45), calendar.events.get(0).dateDebut);
        assertEquals(30, calendar.events.get(0).dureeMinutes);
        assertEquals(0, calendar.events.get(0).frequenceJours);

        //RDV REUNION
        assertEquals("REUNION", calendar.events.get(1).type);
        assertEquals("rdvReu", calendar.events.get(1).title);
        assertEquals("Bob", calendar.events.get(1).proprietaire);
        assertEquals(LocalDateTime.of(2026, 6, 15, 16, 40), calendar.events.get(1).dateDebut);
        assertEquals(32, calendar.events.get(1).dureeMinutes);
        assertEquals(0, calendar.events.get(1).frequenceJours);

        //RDV PERIODIQUE
        assertEquals("PERIODIQUE", calendar.events.get(2).type);
        assertEquals("rdvPerio", calendar.events.get(2).title);
        assertEquals("Pierre", calendar.events.get(2).proprietaire);
        assertEquals(LocalDateTime.of(2026, 7, 17, 17, 35), calendar.events.get(2).dateDebut);
        assertEquals(33, calendar.events.get(2).dureeMinutes);
        assertEquals(2, calendar.events.get(2).frequenceJours);
    }
}
/**

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
 **/