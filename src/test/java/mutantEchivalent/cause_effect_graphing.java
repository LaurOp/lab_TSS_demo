package mutantEchivalent;

import Helpers.CaptureConsole;
import Helpers.RandomString;
import com.tss.Demo;
import com.tss.Mutant;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class cause_effect_graphing {

    private final Mutant demo = new Mutant();
    private final RandomString randomString = new RandomString();

    @Rule
    public final CaptureConsole captureConsoleRule = new CaptureConsole();

    @Test
    public void TC1_under5Char() {
        assertFalse(demo.mutant_echivalent(""));
        assertFalse(demo.mutant_echivalent("a"));
        assertFalse(demo.mutant_echivalent("ab"));
        assertFalse(demo.mutant_echivalent("abc"));
        assertFalse(demo.mutant_echivalent("abcd"));
    }

    @Test
    public void TC2_5to20Char_mixed(){
        for (int i = 5; i < 21; i++) {
            assert demo.mutant_echivalent(randomString.generate(i));
        }
    }

    @Test
    public void TC3_over20Char(){
        assertFalse(demo.mutant_echivalent(randomString.generate(21)));
    }

    @Test
    public void TC4_5to20Char_lowercase(){
        for (int i = 5; i < 21; i++) {
            assert demo.mutant_echivalent(randomString.generateLower(i));
            assert captureConsoleRule.getOutput().contains("Lowercase");
        }
    }

    @Test
    public void TC5_5to20Char_uppercase(){
        for (int i = 5; i < 21; i++) {
            assert demo.mutant_echivalent(randomString.generateUpper(i));
            assert captureConsoleRule.getOutput().contains("Uppercase");
        }
    }

    @Test
    public void TC6_5to20Char_Number_or_Symbol(){
        for (int i = 4; i < 20; i++) {
            assertFalse(demo.mutant_echivalent(randomString.generate(i)+"1"));
        }

        for (int i = 4; i < 20; i++) {
            assertFalse(demo.mutant_echivalent(randomString.generate(i) + "!"));
        }
    }
}
