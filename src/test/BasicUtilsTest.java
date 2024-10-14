package test;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import main.BasicUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

public class BasicUtilsTest {
    @Test
    public void reversingArbitraryStringProducesCorrectResult() {
        Assertions.assertEquals(
                "txet modnar", BasicUtils.reversed("random text")
        );

        Assertions.assertEquals(
                "bd#sa6f3basż;", BasicUtils.reversed(";żsab3f6as#db")
        );
    }

    @Test
    public void reversingNullReturnsNull() {
        Assertions.assertNull(BasicUtils.reversed(null));
    }

    //1
    @Test
    public void countingArbitraryStringsVowels() {
        Assertions.assertEquals(2, BasicUtils.vowelCount("Mazhar"));
    }

    //2
    @Test
    public void countingEmptyStringNotHaveAnyVowels() {
        Assertions.assertEquals(0, BasicUtils.vowelCount(""));
    }

    //3
    @Test
    public void countingOnlyVowelsOnString() {
        Assertions.assertEquals(
                5, BasicUtils.vowelCount("euioa")
        );
    }

    //4
    @Test
    public void countingOnlyConsonantsOnString() {
        Assertions.assertEquals(
                0, BasicUtils.vowelCount("qwrtypsdfghjklzxcvbnm")
        );
    }

    //5
    @Test
    public void countingVowelsOnNullString() {
        Assertions.assertEquals(0, BasicUtils.vowelCount(null));
    }

    @TestFactory
    public Stream<DynamicTest> countingVowelsTest() {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        return vowels.stream().
                map(
                        vowel -> (DynamicTest.dynamicTest(vowel.toString(),
                                () -> Assertions.assertTrue(BasicUtils.isVowel(vowel))))
                );
    }

}