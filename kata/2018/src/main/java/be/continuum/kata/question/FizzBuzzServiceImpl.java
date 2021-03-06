package be.continuum.kata.question;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * FizzBuzzServiceImpl
 *
 * @author bgerard
 * @version 1.0
 */
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private final Map<Integer, String> dividerMap;

    FizzBuzzServiceImpl(final Map<Integer, String> dividerMap) {
        this.dividerMap = dividerMap;
    }

    @Override
    public List<String> transform(
            final int start,
            final int n
    ) {
        return IntStream.range(start, n + 1)
                .mapToObj(this::transform)
                .collect(Collectors.toList());
    }

    @Override
    public String transform(
            final int i
    ) {
        final List<Integer> dividers = dividerMap.keySet()
                .stream()
                .collect(Collectors.filtering(
                        key -> i % key == 0,
                        Collectors.toList()
                ));

        if (dividers.isEmpty()) {
            return Objects.toString(i);
        }

        return dividers.stream()
                .sorted(Comparator.naturalOrder())
                .map(dividerMap::get)
                .collect(Collectors.joining());
    }

}
