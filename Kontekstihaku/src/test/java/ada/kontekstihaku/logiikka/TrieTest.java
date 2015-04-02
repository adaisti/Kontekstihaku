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
public class TrieTest {

    private Trie trie;

    public TrieTest() {
    }

    @Before
    public void setUp() {
        Teksti teksti = new Teksti("suklaa");
        trie = new Trie(teksti);
        trie.alusta();
    }

    @Test
    public void testAlusta() {
        assertTrue(trie.sisaltaa("suklaa"));
    }

    @Test
    public void testSisaltaa_3args() {
        assertTrue(trie.sisaltaa("suklaa", trie.alkusolmu, 0));
    }

    @Test
    public void testSisaltaa_StringLoytaaJosOn() {
        assertTrue(trie.sisaltaa("suklaa"));
    }

    @Test
    public void testSisaltaa_StringEiLoydaJosEiOle() {
        assertTrue(!trie.sisaltaa("kaali"));
    }

    @Test
    public void testLisaa() {
        trie.lisaa("sukka");
        assertTrue(trie.sisaltaa("sukka"));
    }

    @Test
    public void testLisaaMonta() {
        trie.lisaa("sukka");
        trie.lisaa("suklaa");
        trie.lisaa("sukkien");
        assertTrue(trie.sisaltaa("sukka"));
        assertTrue(trie.sisaltaa("suklaa"));
        assertTrue(trie.sisaltaa("sukkien"));
        assertFalse(trie.sisaltaa("sukk"));
        assertFalse(trie.sisaltaa("sukkie"));
    }

    @Test
    public void testLisaaHuonoja() {
        trie.lisaa("s");
        trie.lisaa("su");
        trie.lisaa("suk");
        assertTrue(trie.sisaltaa("s"));
        //assertFalse(trie.sisaltaa("sukk"));
        //assertFalse(trie.sisaltaa("a"));
    }

    @Test
    public void testLuoAlipuu() {
    }

}
