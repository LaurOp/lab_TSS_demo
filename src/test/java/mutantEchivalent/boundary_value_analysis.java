package mutantEchivalent;

import Helpers.CaptureConsole;
import Helpers.RandomString;
import com.tss.Demo;
import com.tss.Mutant;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class boundary_value_analysis {

    private final Mutant demo = new Mutant();
    private final RandomString randomString = new RandomString();

    @Rule
    public final CaptureConsole captureConsoleRule = new CaptureConsole();

    @Test
    public void TC1_4letters() {
        assertFalse(demo.mutant_echivalent(randomString.generate(4)));
    }

    @Test
    public void TC2_5letters() {
        assert demo.mutant_echivalent(randomString.generate(5));
    }

    @Test
    public void TC3_6letters() {
        assert demo.mutant_echivalent(randomString.generate(6));
    }

    @Test
    public void TC4_12letters() {
        assert demo.mutant_echivalent(randomString.generate(12));
    }

    @Test
    public void TC5_19letters() {
        assert demo.mutant_echivalent(randomString.generate(19));
    }

    @Test
    public void TC6_20letters() {
        assert demo.mutant_echivalent(randomString.generate(20));
    }

    @Test
    public void TC7_21letters() {
        assertFalse(demo.mutant_echivalent(randomString.generate(21)));
    }

    @Test
    public void TC8_4letters_lowercase() {
        assertFalse(demo.mutant_echivalent(randomString.generateLower(4)));
    }

    @Test
    public void TC9_5letters_lowercase() {
        assert demo.mutant_echivalent(randomString.generateLower(5));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC10_6letters_lowercase() {
        assert demo.mutant_echivalent(randomString.generateLower(6));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC11_12letters_lowercase() {
        assert demo.mutant_echivalent(randomString.generateLower(12));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC12_19letters_lowercase() {
        assert demo.mutant_echivalent(randomString.generateLower(19));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC13_20letters_lowercase() {
        assert demo.mutant_echivalent(randomString.generateLower(20));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC14_21letters_lowercase() {
        assertFalse(demo.mutant_echivalent(randomString.generateLower(21)));
    }

    @Test
    public void TC15_4letters_uppercase() {
        assertFalse(demo.mutant_echivalent(randomString.generateUpper(4)));
    }

    @Test
    public void TC16_5letters_uppercase() {
        assert demo.mutant_echivalent(randomString.generateUpper(5));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC17_6letters_uppercase() {
        assert demo.mutant_echivalent(randomString.generateUpper(6));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC18_12letters_uppercase() {
        assert demo.mutant_echivalent(randomString.generateUpper(12));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC19_19letters_uppercase() {
        assert demo.mutant_echivalent(randomString.generateUpper(19));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC20_20letters_uppercase() {
        assert demo.mutant_echivalent(randomString.generateUpper(20));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC21_21letters_uppercase() {
        assertFalse(demo.mutant_echivalent(randomString.generateUpper(21)));
    }

    @Test
    public void TC22_5_20_letters_1number() {
        assertFalse(demo.mutant_echivalent(randomString.generate(4) + "1"));
        assertFalse(demo.mutant_echivalent(randomString.generate(19) + "1"));
    }

    @Test
    public void TC23_5_20_letters_1symbol() {
        assertFalse(demo.mutant_echivalent(randomString.generate(4) + "@"));
        assertFalse(demo.mutant_echivalent(randomString.generate(19) + "@"));
    }
}
