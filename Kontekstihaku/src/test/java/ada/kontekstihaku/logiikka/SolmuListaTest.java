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
public class SolmuListaTest {
    
    public SolmuListaTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSize() {
        SolmuLista<Solmu> l = new SolmuLista();
        l.add(new Solmu('a'));
        l.add(new Solmu('a'));
        l.add(new Solmu('a'));
        assertEquals(3, l.size());
    }

    @Test
    public void testIsEmptyOnTyhja() {
        SolmuLista<Solmu> l = new SolmuLista();
        assertTrue(l.isEmpty());
    }
    
    @Test
    public void testIsEmptyToimiiTaydella() {
        SolmuLista<Solmu> l = new SolmuLista();
        l.add(new Solmu('a'));
        assertEquals(false, l.isEmpty());
    }

    @Test
    public void testContainsKunSisaltaa() {
        SolmuLista<Solmu> l = new SolmuLista();
        Solmu s = new Solmu('a');
        l.add(s);
        assertEquals(true, l.contains(s));
    }
    
    @Test
    public void testContainsKunEiSisalla() {
        SolmuLista<Solmu> l = new SolmuLista();
        l.add(new Solmu('a'));
        assertEquals(false, l.contains(new Solmu('b')));
    }

    @Test
    public void testAdd() {
        SolmuLista<Solmu> l = new SolmuLista();
        Solmu s = new Solmu('a');
        l.add(s);
        assertEquals(true, l.contains(s));
    }

    @Test
    public void testRemove() {
        SolmuLista<Solmu> l = new SolmuLista();
        Solmu s = new Solmu('a');
        l.add(s);
        l.remove(s);
        assertEquals(false, l.contains(s));
    }

    @Test
    public void testClear() {
        SolmuLista<Solmu> l = new SolmuLista();
        Solmu s = new Solmu('a');
        l.add(s);
        l.clear();
        assertEquals(true, l.isEmpty());
    }

    @Test
    public void testIndexOf() {
        SolmuLista<Solmu> l = new SolmuLista();
        Solmu s = new Solmu('a');
        l.add(s);
        assertEquals(0, l.indexOf(s));
    }

    @Test
    public void testGet() {
        SolmuLista<Solmu> l = new SolmuLista();
        Solmu s = new Solmu('a');
        l.add(s);
        assertEquals(s, l.get(0));
    }

    @Test
    public void testToString() {
        SolmuLista<Solmu> l = new SolmuLista();
        Solmu s = new Solmu('a');
        l.add(s);
        assertEquals("[a]", l.toString());
    }
    
}
