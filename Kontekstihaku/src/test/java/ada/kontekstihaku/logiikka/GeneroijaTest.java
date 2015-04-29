package ada.kontekstihaku.logiikka;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GeneroijaTest {
   
    Generoija gen;
    String aineisto = "Tämä on testi väli virke ja siitä generoidaan sanoja";

   @Before
    public void setUp() {
        Teksti teksti = new Teksti(aineisto);
        teksti.alustaTrieSanoilla();
        gen = new Generoija(teksti);
        
    }
    
    @Test
    public void generoiSanaAineistosta() {
        String s = gen.generoiRandomSanaAlunPerusteella("ge");
        assertEquals("generoidaan", s);
    }
    
    @Test
    public void generoiMontaSanaaAineistosta() {
        ArrayList<String> lista = new ArrayList();
        String[] alut = new String[] {"o", "g", "t", "v", "s"};
        for (int i = 0; i < alut.length; i++) {
             lista.add(gen.generoiRandomSanaAlunPerusteella(alut[i]));
        }
        for (String sana : lista) {
            assertTrue(aineisto.toLowerCase().contains(sana));
        }
    }
    
    @Test
    public void generoiSanaAlullaMitäEiEsiinny() {
        String s = gen.generoiRandomSanaAlunPerusteella("a");
        assertTrue(s.isEmpty());
    }
    
    @Test
    public void generoiSanojaAluillaMitäEiEsiinny() {
        String s = "";
        String[] alut = new String[] {"z", "y", "f", "a", "d"};

        for (int i = 0; i < alut.length; i++) {
             s += gen.generoiRandomSanaAlunPerusteella(alut[i]);
        }
        
        assertTrue(s.isEmpty());
    }
    
    @Test
    public void generoiSanaPidemmälläAlulla() {
        String s = gen.generoiRandomSanaAlunPerusteella("te");
        assertEquals("testi", s);
        assertFalse("tämä".equals(s));
    }
    
    @Test
    public void generoiSanojaPidemmilläAluilla() {
        String[] alut = new String[] {"tes", "san", "gene", "vir", "on"};
        ArrayList<String> sanat = new ArrayList();
        
        for (String sana : alut) {
            sanat.add(gen.generoiRandomSanaAlunPerusteella(sana));
        }
        
        for (String sana : sanat) {
            assertTrue(aineisto.toLowerCase().contains(sana));
        }
        
    }
    
    @Test
    public void generoiSanojaPitkilläAluillaMitäEiOle() {
        String s = "";
        String[] alut = new String[] {"chang", "paras", "yliopisto", "tiralabra", "stiivi"};

        for (String sana : alut) {
            s += gen.generoiRandomSanaAlunPerusteella(sana);
        }
        
        assertTrue(s.isEmpty());
    }
    
}