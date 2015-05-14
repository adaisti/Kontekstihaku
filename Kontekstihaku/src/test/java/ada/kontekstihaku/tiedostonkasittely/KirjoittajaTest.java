/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.tiedostonkasittely;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ada
 */
public class KirjoittajaTest {
    
    public KirjoittajaTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testAlustetaanOikeinKunEiOleTiedostoa() throws Exception {
        Kirjoittaja k = new Kirjoittaja("src/tiedosto.txt");
        assertFalse(k.tiedosto.exists());
    }
    
}
