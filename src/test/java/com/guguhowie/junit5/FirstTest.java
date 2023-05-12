package com.guguhowie.junit5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@Slf4j
public class FirstTest {


    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
    }


    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        log.info("@AfterAll - executed after all test methods.");
    }


    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        log.info("Success");
    }

    @Test
    @Disabled("Not implemented yet")
    void testShowSomething() {
    }


    @Test
    void lambdaExpressions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(numbers.stream()
                .mapToInt(Integer::intValue)
                .sum() > 5, "Sum should be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }

    @Test
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void assumptionThat() {
        String someString = "Just a string";
        assumingThat(
                someString.equals("Just a string"),
                () -> assertEquals(2 + 2, 6)
        );
    }


    private List<String> in = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
    private List<String> out = new ArrayList<>(Arrays.asList("Cześć", "Tak", "Nie"));

    @TestFactory
    Stream<DynamicTest> translateDynamicTestsFromStream() {

        return in.stream()
                .map(word -> DynamicTest.dynamicTest("Test translate " + word, () -> {
                    int id = in.indexOf(word);
                    assertEquals(out.get(id), translate(word));
                }));
    }

    private String translate(String word) {
        if ("Hello".equalsIgnoreCase(word)) {
            return "Cześć";
        } else if ("Yes".equalsIgnoreCase(word)) {
            return "Tak";
        } else if ("No".equalsIgnoreCase(word)) {
            return "Nie";
        }
        return "Error";
    }


    @Test
    @Disabled("Disabled test example")
    void disabledTest() {
        fail();
    }
}
