package mutantEchivalent;

import Helpers.CaptureConsole;
import Helpers.RandomString;
import com.tss.Demo;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MCDC {
    private final Demo demo = new Demo();
    private final RandomString randomString = new RandomString();

    @Rule
    public final CaptureConsole captureConsoleRule = new CaptureConsole();

    @Test
    public void TC1_under5Char(){
        assertFalse(demo.mutant_echivalent(""));
        assertFalse(demo.mutant_echivalent("a"));
        assertFalse(demo.mutant_echivalent("ab"));
        assertFalse(demo.mutant_echivalent("abc"));
        assertFalse(demo.mutant_echivalent("abcd"));
    }

    @Test
    public void TC2_over20Char(){
        assertFalse(demo.mutant_echivalent(randomString.generate(21)));
    }

    @Test
    public void TC3_5_20_lower_special(){
        assertFalse(demo.mutant_echivalent(randomString.generateLower(5) + "@"));
        assertFalse(demo.mutant_echivalent(randomString.generateLower(5) + "1"));
    }

    @Test
    public void TC4_5_20_lower(){
        assert demo.mutant_echivalent(randomString.generateLower(5));
        assert captureConsoleRule.getOutput().contains("Lowercase");
        System.out.flush();
        assert demo.mutant_echivalent(randomString.generateLower(20));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC5_5_20_upper_special(){
        assertFalse(demo.mutant_echivalent(randomString.generateUpper(5) + "@"));
        assertFalse(demo.mutant_echivalent(randomString.generateUpper(5) + "1"));
    }

    @Test
    public void TC6_5_20_upper(){
        assert demo.mutant_echivalent(randomString.generateUpper(5));
        assert captureConsoleRule.getOutput().contains("Uppercase");
        System.out.flush();
        assert demo.mutant_echivalent(randomString.generateUpper(20));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC7_5_20_mixt_special(){
        assertFalse(demo.mutant_echivalent(randomString.generate(5) + "@"));
        assertFalse(demo.mutant_echivalent(randomString.generate(5) + "1"));
    }

    @Test
    public void TC8_5_20_mixt(){
        assert demo.mutant_echivalent(randomString.generate(5));
        assert demo.mutant_echivalent(randomString.generate(20));
    }
}
