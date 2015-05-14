/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ada
 */
public class TilastoTrieTest {
    
    public TilastoTrieTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testLisaa() {
        TilastoTrie tt = new TilastoTrie();
        tt.lisaa("algo");
        tt.lisaa("algo");
        tt.lisaa("koodi");
        assertEquals(tt.alkusolmu.yleisinLapsi().arvo(), 'a');
        
    }
    
    @Test
    public void testLisaaKunOnVainYksiSana() {
        TilastoTrie tt = new TilastoTrie();
        tt.lisaa("algo");
        assertEquals(tt.alkusolmu.yleisinLapsi().arvo(), 'a');
        
    }

    @Test
    public void testPoista() {
        TilastoTrie tt = new TilastoTrie();
        tt.lisaa("algo");
        tt.lisaa("algo");
        tt.lisaa("koodi");
        tt.lisaa("koodi");
        tt.poista("koodi");
        assertEquals(tt.alkusolmu.yleisinLapsi().arvo(), 'a');
    }
    
}
