package be.gerard.kata.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

/**
 * GildedRoseServiceTest
 *
 * @author bgerard
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class GildedRoseServiceTest {

    private static final LocalDate INITIAL_DATE = LocalDate.now();

    private static final List<Item> ITEMS = List.of(
            Item.builder()
                    .name("+5 Dexterity Vest")
                    .creationDate(INITIAL_DATE)
                    .sellIn(10)
                    .initialQuality(20)
                    .category(Item.Category.REGULAR)
                    .build(),
            Item.builder()
                    .name("Aged Brie")
                    .creationDate(INITIAL_DATE)
                    .sellIn(2)
                    .initialQuality(0)
                    .category(Item.Category.BRIE)
                    .build(),
            Item.builder()
                    .name("Elixir of the Mongoose")
                    .creationDate(INITIAL_DATE)
                    .sellIn(5)
                    .initialQuality(7)
                    .category(Item.Category.REGULAR)
                    .build(),
            Item.builder()
                    .name("Sulfuras, Hand of Ragnaros")
                    .creationDate(INITIAL_DATE)
                    .sellIn(0)
                    .initialQuality(80)
                    .category(Item.Category.LEGENDARY)
                    .build(),
            Item.builder()
                    .name("Sulfuras, Hand of Ragnaros")
                    .creationDate(INITIAL_DATE)
                    .sellIn(-1)
                    .initialQuality(80)
                    .category(Item.Category.LEGENDARY)
                    .build(),
            Item.builder()
                    .name("Backstage passes to a TAFKAL80ETC concert")
                    .creationDate(INITIAL_DATE)
                    .sellIn(15)
                    .initialQuality(20)
                    .category(Item.Category.BACKSTAGE_PASSES)
                    .build(),
            Item.builder()
                    .name("Backstage passes to a TAFKAL80ETC concert")
                    .creationDate(INITIAL_DATE)
                    .sellIn(10)
                    .initialQuality(49)
                    .category(Item.Category.BACKSTAGE_PASSES)
                    .build(),
            Item.builder()
                    .name("Backstage passes to a TAFKAL80ETC concert")
                    .creationDate(INITIAL_DATE)
                    .sellIn(5)
                    .initialQuality(49)
                    .category(Item.Category.BACKSTAGE_PASSES)
                    .build(),
            Item.builder()
                    .name("Conjured Mana Cake")
                    .creationDate(INITIAL_DATE)
                    .sellIn(3)
                    .initialQuality(6)
                    .category(Item.Category.CONJURED)
                    .build()
    );

    @InjectMocks
    private GildedRoseService gildedRoseService;

    @Test
    void go() {
        INITIAL_DATE.datesUntil(INITIAL_DATE.plusDays(30))
                .map(date -> gildedRoseService.calculateQualityByDate(ITEMS, date))
                .forEach(result -> result.forEach(pair -> System.out.println(String.format(
                        "%s: %d --> %d",
                        pair.getFirst().getName(),
                        pair.getFirst().getInitialQuality(),
                        pair.getSecond()
                ))));

        // THEN
        Assertions.assertThat("").isEqualTo("");
    }

}
