/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.tiedostonkasittely;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ada
 */
public class Kirjoittaja {
    
    File tiedosto;
    
    public Kirjoittaja(String tiedostonnimi) {
        this.tiedosto = new File (tiedostonnimi);
    }
    
    public void kirjoitaTiedostoon(String teksti) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto, true);
        kirjoittaja.write(teksti);
        kirjoittaja.close();
    }
    
}
