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
public class SolmuTest {
    Solmu solmu;
    
    public SolmuTest() {
    }
    
    @Before
    public void setUp() {
        solmu = new Solmu('A');
    }

    @Test
    public void testLisaaLapsi() {
        Solmu uus = new Solmu('B');
        solmu.lisaaLapsi(uus);
        assertTrue(solmu.lapset.contains(uus));
    }

    @Test
    public void testLisaaKuuluvienSanojenMaaraa() {
//        Solmu uus = new Solmu('B');
//        solmu.lisaaLapsi(uus);
//        solmu.lisaaLapsi(new Solmu('$'));
        solmu.lisaaKuuluvienSanojenMaaraa();
        assertEquals(1, solmu.moneenkoSanaanKuuluu());
    }

    @Test
    public void testEtsiLapsi() {
        Solmu uus = new Solmu('B');
        solmu.lisaaLapsi(uus);
        assertEquals(solmu.etsiLapsi(uus), uus);
    }

    @Test
    public void testGetLapset() {
        Solmu uus = new Solmu('B');
        solmu.lisaaLapsi(uus);
        assertEquals(solmu.lapset.size(), 1);
    }

    @Test
    public void testEtsiLastenArvoista() {
        Solmu uus = new Solmu('B');
        solmu.lisaaLapsi(uus);
        assertEquals(solmu.etsiLastenArvoista('B'), uus);
    }

    @Test
    public void testArvo() {
        assertEquals('A', solmu.arvo());
    }

    @Test
    public void testEquals() {
        assertTrue(new Solmu('A').equals(solmu));
    }

    @Test
    public void testToString() {
        assertEquals("A", solmu.toString());
    }
    
}
