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
public class TekstiTest {
    
    private Teksti teksti;
    
    public TekstiTest() {
    }
    
    @Before
    public void setUp() {
        this.teksti = new Teksti("Ollako vai eikö olla? Kas siinä pulma! Jalompaa onko vaiti ottaa vastaan pahansuovan onnen turmannuolet, vai aseella selvä tehdä murheistaan? Lopettaa ne kerta kaikkiaan. Kuolla, nukkua vain, nukkua! Ja kenties nähdä unta?");
    }

    @Test
    public void testJaotteleJakaaVirkkeet() {
        teksti.jaottele();
        assertEquals("Kas siinä pulma! ", teksti.virkkeet().get(1));
    }

    @Test
    public void testJaotteleJakaaSaneet() {
        teksti.jaottele();
        assertEquals("olla?", teksti.saneet().get(3));
    }
    
    @Test
    public void testOnLopetusmerkkiTunnistaaMerkit() {
        assertEquals(true, teksti.onLopetusmerkki('!'));
    }

    @Test
    public void testEsiintymatKunEiEsiinny() {
        assertEquals(0, teksti.esiintymat("hamsteri").size());
    }

    @Test
    public void testEsiintymatLoytaaTasanOikeanMaaran() {
        assertEquals(2, teksti.esiintymat("vai").size());
    }

    @Test
    public void testEtsiEsiintymiaLoytaaKaikkiLauseet() {
        assertEquals(3, teksti.etsiEsiintymia("vai").size());
    }

    @Test
    public void testSaneet() {
    }
    
}
