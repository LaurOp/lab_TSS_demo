package mutanti_neechivalenti;

import Helpers.CaptureConsole;
import Helpers.RandomString;
import com.tss.Demo;
import com.tss.Mutant;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class mutanti_neechi {
    private final Mutant demo = new Mutant();
    private final RandomString randomString = new RandomString();


    @Test
    public void TCneechi_5_20_lower_special_TO_FAIL(){
        assertFalse(demo.mutant_neechivalent_omorat(randomString.generateLower(5) + "@"));
        assertFalse(demo.mutant_neechivalent_omorat(randomString.generateLower(5) + "1"));
    }

    @Test
    public void TCneechi_NU_omorat_5_20_lower_special_TO_PASS(){
        assertFalse(demo.mutant_neechivalent_NU_omorat(randomString.generateLower(5) + "@"));
        assertFalse(demo.mutant_neechivalent_NU_omorat(randomString.generateLower(5) + "1"));
    }

    @Test   // This catches the mutant
    public void TCneechi_NU_omorat_over20Char_TO_FAIL(){
        assertFalse(demo.mutant_neechivalent_NU_omorat(randomString.generate(21)));
    }

}
