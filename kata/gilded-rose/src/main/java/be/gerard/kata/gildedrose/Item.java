package be.gerard.kata.gildedrose;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 * Item
 *
 * @author bgerard
 * @version 1.0
 */
@Value
@Builder
class Item {

    private final String name;
    private final LocalDate creationDate;
    private final int sellIn;
    private final int initialQuality;
    private final Category category;

    LocalDate getExpirationDate() {
        return creationDate.plusDays(sellIn);
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Category {
        LEGENDARY(
                (item, remainingSellIn) -> 0
        ) {
            @Override
            public int calculateQuality(
                    final Item item,
                    final int remainingSellIn
            ) {
                return item.getInitialQuality();
            }
        },
        REGULAR(
                (item, remainingSellIn) -> IntStream.range(remainingSellIn, item.getSellIn())
                        .map(i -> i >= 0 ? 1 : 2)
                        .sum()
        ),
        BRIE(
                (item, remainingSellIn) -> REGULAR.depreciationFunction.apply(item, remainingSellIn) * -1
        ),
        CONJURED(
                (item, remainingSellIn) -> REGULAR.depreciationFunction.apply(item, remainingSellIn) * 2
        ),
        BACKSTAGE_PASSES(
                (item, remainingSellIn) -> {
                    if (IntStream.range(remainingSellIn, item.getSellIn()).anyMatch(i -> i <= 0)) {
                        return item.getInitialQuality();
                    }

                    return IntStream.range(remainingSellIn, item.getSellIn())
                            .filter(i -> i > 0)
                            .map(i -> {
                                if (i > 10) {
                                    return -1;
                                } else if (i > 5) {
                                    return -2;
                                } else {
                                    return -3;
                                }
                            })
                            .sum();
                }
        );

        private static final int MIN_QUALITY = 0;
        private static final int MAX_QUALITY = 50;

        private final BiFunction<Item, Integer, Integer> depreciationFunction;

        public int calculateQuality(
                final Item item,
                final LocalDate date
        ) {
            final long daysAfterCreation = item.getCreationDate().until(date, ChronoUnit.DAYS);
            final int remainingSellIn = Math.toIntExact(item.getSellIn() - daysAfterCreation);

            return calculateQuality(item, remainingSellIn);
        }

        public int calculateQuality(
                final Item item,
                final int remainingSellIn
        ) {
            final int quality = item.getInitialQuality() - depreciationFunction.apply(item, remainingSellIn);

            return Math.min(Math.max(quality, MIN_QUALITY), MAX_QUALITY);
        }

    }

}
