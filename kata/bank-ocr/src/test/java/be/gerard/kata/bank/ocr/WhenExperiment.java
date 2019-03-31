package be.gerard.kata.bank.ocr;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WhenExperiment
 *
 * @author bgerard
 * @version 1.0
 */
public class WhenExperiment {

    private static final List<String> REGEX = Arrays.asList(
            "(?=[+-])|(?<=[+-])",
            "(?=[/*])|(?<=[/*])",
            "(?<=^\\w{0,100}\\()|(?=\\)$)"
    );

    public static void b(
            final String formula
    ) {
        final String f = formula.replaceAll("\\s+", "");


    }

    public static void c(
            final String formula
    ) {
    }

    @Test
    void a(

    ) {
        Node.builder()
                .label("component", "MASTER_RETAIL")
                .build();
        Node.builder()
                .label("component", "DEALER_DISCOUNT")
                .build();
        Node.builder()
                .label("component", "DEALER_NET")
                .build();
        Node.builder()
                .label("country", "DEU")
                .build();
        Node.builder()
                .label("country", "CORE")
                .build();

        final String formula = "var_0 * (100 - var_1) * (0.01)".replaceAll("\\s+", "");

        final String f2 = "a + b + c - d * a".replaceAll("\\s+", "");

        final String[] s8 = f2.split("(?=[+-])|(?<=[+-])");
        final String[] s7 = f2.split("(?=[/*])|(?<=[/*])");
        //https://codereview.stackexchange.com/questions/84763/evaluating-an-expression-with-integers-and-as-well-as
        //final String[] s9 = f2.split("\\((?>[^()]|(?R))*\\)");
        final String[] s10 = f2.split("(?<=^\\()(.+)(?=\\)$)"); // (?<=\()(.+)(?=\)) --> (a + (b + c)) --> a + (b + c)
        final String[] s11 = f2.split("(?<=^\\()|(?=\\)$)");
        final String[] s12 = "min(a + b + (c - d))".split("(?<=^\\w{0,100}\\()|(?=\\)$)");

        b("min(a + b + (c - d))");
    }

    @Test
    void d() {
        final Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?|\\w+([(%])?|[+-/*()]"); // "10.0 + a + min(a + b% + (c - d))"
        final Matcher matcher = pattern.matcher("10.0 + a + min(a + b + (c - d))");

        final Stack<String> stack = new Stack<>();

        final List<String> allMatches = new ArrayList<>();

        while (matcher.find()) {
            allMatches.add(matcher.group());
        }

        System.out.println(allMatches);
    }

    @Test
    void e() {
        final Pattern pattern = Pattern.compile("(\\w)\\1*"); // (.)\1+
        final Matcher matcher = pattern.matcher("aaaaaaaaaaaaabbbbbbbbbbbcaaaaaaa");

        final List<String> allMatches = new ArrayList<>();

        while (matcher.find()) {
            allMatches.add(matcher.group());
        }

        System.out.println(allMatches);
    }

    @Test
    void f() {
        final String s1 = "dapag bapart, hoepoe gaapaat hepet".replaceAll("([aeiou]+)p\\1", "$1");

        System.out.println(s1);
    }

    @Test
    void test() {
        // \G --> zero-width assertion // matches the position where the previous match ended
        System.out.println(Arrays.toString(
                "Thequickbrownfoxjumps".split("(?<=\\G.{4})")
        ));
    }

    @Test
    void test2() {
        final Pattern pattern = Pattern.compile("" +
                "(?:.{3})*(.{3})(?:.{3})*\n" +
                "(?:.{3})*(.{3})(?:.{3})*\n" +
                "(?:.{3})*(.{3})(?:.{3})*");
    }

    @RequiredArgsConstructor
    @Builder
    @ToString
    public static class Node {

        @Singular
        private final Map<String, String> labels;

    }

    @RequiredArgsConstructor
    @Builder
    @ToString
    public static class Link {

        @Singular
        private final Map<String, String> labels;

    }

    // (?: ) --> ignore group
    // final Pattern pattern = Pattern.compile("" +
    //         "(?:.{3})*(.{3})(?:.{3})*\n" +
    //         "(?:.{3})*(.{3})(?:.{3})*\n" +
    //         "(?:.{3})*(.{3})(?:.{3})*");

}
