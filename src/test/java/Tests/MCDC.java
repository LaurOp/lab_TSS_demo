package Tests;

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
        assertFalse(demo.method(""));
        assertFalse(demo.method("a"));
        assertFalse(demo.method("ab"));
        assertFalse(demo.method("abc"));
        assertFalse(demo.method("abcd"));
    }

    @Test
    public void TC2_over20Char(){
        assertFalse(demo.method(randomString.generate(21)));
    }

    @Test
    public void TC3_5_20_lower_special(){
        assertFalse(demo.method(randomString.generateLower(5) + "@"));
        assertFalse(demo.method(randomString.generateLower(5) + "1"));
    }

    @Test
    public void TC4_5_20_lower(){
        assert demo.method(randomString.generateLower(5));
        assert captureConsoleRule.getOutput().contains("Lowercase");
        System.out.flush();
        assert demo.method(randomString.generateLower(20));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC5_5_20_upper_special(){
        assertFalse(demo.method(randomString.generateUpper(5) + "@"));
        assertFalse(demo.method(randomString.generateUpper(5) + "1"));
    }

    @Test
    public void TC6_5_20_upper(){
        assert demo.method(randomString.generateUpper(5));
        assert captureConsoleRule.getOutput().contains("Uppercase");
        System.out.flush();
        assert demo.method(randomString.generateUpper(20));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC7_5_20_mixt_special(){
        assertFalse(demo.method(randomString.generate(5) + "@"));
        assertFalse(demo.method(randomString.generate(5) + "1"));
    }

    @Test
    public void TC8_5_20_mixt(){
        assert demo.method(randomString.generate(5));
        assert demo.method(randomString.generate(20));
    }
}