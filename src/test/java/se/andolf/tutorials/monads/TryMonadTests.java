package se.andolf.tutorials.monads;


import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TryMonadTests {

    @Test
    void successfulTry() throws Throwable {
        final int value = Try.ofThrowable(() -> Integer.valueOf("1")).get();
        assertEquals(1, value);
    }

    @Test
    void successfulTryWithMapping() throws Throwable {
        final int value = Try.ofThrowable(() -> Integer.valueOf("1"))
                .map(integer -> integer+1)
                .get();
        assertEquals(2, value);
    }

    @Test
    void successfulTryWithFlatMap() throws Throwable {
        final int value = Try.ofThrowable(() -> Integer.valueOf("10"))
                .flatMap(n -> Try.ofThrowable(() -> n / 2))
                .get();
        assertEquals(5, value);
    }

    @Test
    void failureTryWhenGetting() {
        assertThrows(NumberFormatException.class, () -> Try.ofThrowable(() -> Integer.valueOf("a")).get());
    }

    @Test
    void failedTryWithFlatMap() {
        assertThrows(NumberFormatException.class, () -> Try.ofThrowable(() -> 1)
                .flatMap(n -> Try.ofThrowable(() -> Integer.valueOf("T")))
                .get());
    }

    @Test
    void returnDefaultIfExceptionIsThrown() {
        final int value = Try.ofThrowable(() -> Integer.valueOf("T")).orElse(5);
        assertEquals(5, value);
    }

    @Test
    void shouldReturnAnOptionalWithValue() {
        final Optional<Integer> optionalValue = Try.ofThrowable(() -> Integer.valueOf("5")).toOptional();
        assertTrue(optionalValue.isPresent());
    }

    @Test
    void shouldReturnAnEmptyOptional() {
        final Optional<Integer> optionalValue = Try.ofThrowable(() -> Integer.valueOf("T")).toOptional();
        assertFalse(optionalValue.isPresent());
    }

    @Test
    void shouldTestIfSuccessfulFalse() {
        assertFalse(Try.ofThrowable(() -> Integer.valueOf("T")).isSuccessful());
    }

    @Test
    void shouldTestIfSuccessfulTrue() {
        assertTrue(Try.ofThrowable(() -> Integer.valueOf("1")).isSuccessful());
    }

    @Test
    void shouldThrowOtherException() {
        assertThrows(IllegalArgumentException.class, () -> Try.ofThrowable(() -> Integer.parseInt("T"))
                .orElseThrow(IllegalArgumentException::new));
    }

    @Test
    void getTheUncheckedValue() {
        assertEquals(1, (int) Try.ofThrowable(() -> Integer.parseInt("1")).getUnchecked());
    }

    @Test
    void getTheUncheckedException() {
        assertThrows(RuntimeException.class, () -> Try.ofThrowable(() -> Integer.parseInt("T")).getUnchecked());
    }
}
