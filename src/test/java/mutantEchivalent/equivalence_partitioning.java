package mutantEchivalent;

import Helpers.CaptureConsole;
import Helpers.RandomString;
import com.tss.Demo;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class equivalence_partitioning {

    private final Demo demo = new Demo();
    private final RandomString randomString = new RandomString();

    @Rule
    public final CaptureConsole captureConsoleRule = new CaptureConsole();

    @Test
    public void TC1_zeroChar_letters() {
        assertFalse(demo.mutant_echivalent(""));
    }

    @Test
    public void TC2_oneFourChar_letters(){
        assertFalse(demo.mutant_echivalent(randomString.generate(1)));
        assertFalse(demo.mutant_echivalent(randomString.generate(4)));
    }

    @Test
    public void TC3_twentyoneChar_letters(){
        assertFalse(demo.mutant_echivalent(randomString.generate(21)));
    }

    @Test
    public void TC4_fiveToTwentyChar_mixLetters(){
        assert demo.mutant_echivalent(randomString.generate(5));
        assert demo.mutant_echivalent(randomString.generate(20));
    }

    @Test
    public void TC5_fiveToTwentyChar_lowerLetters(){
        assert demo.mutant_echivalent(randomString.generateLower(5));
        assert captureConsoleRule.getOutput().contains("Lowercase");
        System.out.flush();
        assert demo.mutant_echivalent(randomString.generateLower(20));
        assert captureConsoleRule.getOutput().contains("Lowercase");
    }

    @Test
    public void TC6_fiveToTwentyChar_upperLetters(){
        assert demo.mutant_echivalent(randomString.generateUpper(5));
        assert captureConsoleRule.getOutput().contains("Uppercase");
        System.out.flush();
        assert demo.mutant_echivalent(randomString.generateUpper(20));
        assert captureConsoleRule.getOutput().contains("Uppercase");
    }

    @Test
    public void TC7_oneFourChar_number(){
        assertFalse(demo.mutant_echivalent("1"));
        assertFalse(demo.mutant_echivalent("abc1"));
    }

    @Test
    public void TC8_oneFourChar_specialChar(){
        assertFalse(demo.mutant_echivalent("@"));
        assertFalse(demo.mutant_echivalent("abc@"));
    }

    @Test
    public void TC9_fiveToTwentyChar_number(){
        assertFalse(demo.mutant_echivalent(randomString.generate(4) + "1"));
        assertFalse(demo.mutant_echivalent(randomString.generate(19) + "1"));
    }

    @Test
    public void TC10_fiveToTwentyChar_specialChar(){
        assertFalse(demo.mutant_echivalent(randomString.generate(4) + "@"));
        assertFalse(demo.mutant_echivalent(randomString.generate(19) + "@"));
    }

    @Test
    public void TC11_twentyOneChar_number(){
        assertFalse(demo.mutant_echivalent(randomString.generate(20) + "1"));
    }

    @Test
    public void TC12_twentyOneChar_specialChar(){
        assertFalse(demo.mutant_echivalent(randomString.generate(20) + "@"));
    }


}
