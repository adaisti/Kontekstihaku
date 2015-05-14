/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.tiedostonkasittely;

import ada.kontekstihaku.logiikka.Trie;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ada
 */
public class LukijaTest {
    
    Lukija l;
    
    public LukijaTest() {
    }
    
    @Before
    public void setUp() {
        l = new Lukija();
    }

    
    @Test
    public void testLueKotuksenSanatTriehen() throws Exception {
        Trie trie = new Trie();
        l.lueKotuksenSanatTriehen(trie);
        assertTrue(trie.sisaltaa("taivas"));
    }

    @Test
    public void testLueKalevala() throws Exception {
        assertTrue(l.lueKalevala().contains("Väinämöinen"));
    }
    
}
