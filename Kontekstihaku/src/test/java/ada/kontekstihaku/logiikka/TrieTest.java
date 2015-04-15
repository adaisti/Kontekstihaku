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
        trie = new Trie();
    }

    @Test
    public void testAlusta() {
        trie.lisaa("suklaa");
        assertTrue(trie.sisaltaa("suklaa"));
    }

    @Test
    public void testSisaltaa_3args() {
        trie.lisaa("suklaa");
        assertTrue(trie.sisaltaa("suklaa", trie.alkusolmu, 0));
    }

    @Test
    public void testSisaltaa_StringLoytaaJosOn() {
        trie.lisaa("suklaa");
        assertTrue(trie.sisaltaa("suklaa"));
    }

    @Test
    public void testSisaltaa_StringEiLoydaJosEiOle() {
        trie.lisaa("suklaa");
        assertFalse(trie.sisaltaa("kaali"));
    }

    @Test
    public void testLisaa() {
        trie.lisaa("sukka");
        assertTrue(trie.sisaltaa("sukka"));
    }

    @Test
    public void testLisaaMonta() {
        trie.lisaa("suklaa");
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
        trie.lisaa("a");
        assertTrue(trie.sisaltaa("s"));
        assertTrue(trie.sisaltaa("a"));
        assertTrue(trie.sisaltaa("suk"));
    }

    @Test
    public void testSanojenMaaraaLisataan() {
        trie.lisaa("suklaa");
        trie.lisaa("sukka");
        assertEquals(trie.alkusolmu.moneenkoSanaanKuuluu(), 2);
        trie.lisaa("aasi");
        assertEquals(trie.alkusolmu.etsiLastenArvoista('s').moneenkoSanaanKuuluu(), 2);
    }
    
    @Test
    public void sanojenMaaraToimiiPoistaessa() {
        trie.lisaa("chang");
        trie.lisaa("ang");
        assertEquals(trie.alkusolmu.moneenkoSanaanKuuluu(), 2);
        trie.poista("ang");
        assertEquals(trie.alkusolmu.moneenkoSanaanKuuluu(), 1);
    }
    
    @Test
    public void sanojenMaaraToimiiPoistaessaKaks() {
        trie.lisaa("chang");
        trie.lisaa("cha");
        assertEquals(trie.alkusolmu.etsiLastenArvoista('c').moneenkoSanaanKuuluu(), 2);
        trie.poista("cha");
        assertEquals(trie.alkusolmu.etsiLastenArvoista('c').moneenkoSanaanKuuluu(), 1);
    }

}
