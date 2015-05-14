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
public class ListaTest {
    
    public ListaTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSize() {
        Lista<String> l = new Lista();
        l.add("a");
        l.add("b");
        l.add("c");
        assertEquals(3, l.size());
    }

    @Test
    public void testIsEmptyToimiiTyhjalla() {
        Lista<String> l = new Lista();
        assertEquals(true, l.isEmpty());
    }
    
    @Test
    public void testIsEmptyToimiiTaydella() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        assertEquals(false, l.isEmpty());
    }

    @Test
    public void testContainsLoytaaKunOn() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        assertEquals(true, l.contains("ruoka"));
    }

    @Test
    public void testContainsEiLoydaKunEiOle() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        assertEquals(false, l.contains("kaali"));
    }
    
    @Test
    public void testClear() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        l.clear();
        assertEquals(true, l.isEmpty());
    }

    @Test
    public void testGetLoytaaKunOn() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        assertEquals("ruoka", l.get(0));
    }
    
    @Test
    public void testGetEiLoydaKunEiOle() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        assertEquals("ruoka", l.get(0));
    }

    @Test
    public void testIndexOfLoytaaKunOn() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        assertEquals(0, l.indexOf("ruoka"));
    }

    @Test
    public void testIndexOfEiLoydaKunEiOle() {
        Lista<String> l = new Lista();
        assertEquals(-1, l.indexOf("ruoka"));
    }
    
    @Test
    public void testAddLisaaKunEiOleViela() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        assertEquals(true, l.contains("ruoka"));
    }
    
    @Test
    public void testAddLisaaKunOnJo() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        l.add("ruoka");
        assertEquals("ruoka", l.get(1));
    }
    
    @Test
    public void toStringToimii() {
        Lista<String> l = new Lista();
        l.add("ruoka");
        l.add("nam");
        assertEquals("[ruoka, nam]", l.toString());
    }
    
}
