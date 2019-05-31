package be.gerard.kata.gildedrose;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GildedRoseService
 *
 * @author bgerard
 * @version 1.0
 */
@Service
class GildedRoseService {

    List<Pair<Item, Integer>> calculateQualityByDate(
            final Collection<Item> items,
            final LocalDate date
    ) {
        return items.stream()
                .map(item -> Pair.of(
                        item,
                        item.getCategory()
                                .calculateQuality(item, date)
                ))
                .collect(Collectors.toList());
    }

}
