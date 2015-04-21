/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.tiedostonkasittely;

import ada.kontekstihaku.logiikka.TilastoTrie;
import ada.kontekstihaku.logiikka.Trie;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ada
 */
public class Lukija {
    
    private File tiedosto;
    
    public Lukija() {
        
    }
    
    public Lukija (String tiedostonnimi) {
        this.tiedosto = new File (tiedostonnimi);
    }
    
    public String lueTiedosto() throws FileNotFoundException {
        String teksti = "";
        Scanner lukija = new Scanner(this.tiedosto);
        
        while (lukija.hasNextLine()) {
            teksti += lukija.nextLine();
            teksti += "\n";
        }
        
        lukija.close();
        return teksti;
    }
    
    public void lueKotuksenSanatTriehen(Trie trie) throws FileNotFoundException {
        Scanner lukija = new Scanner(new File ("src/main/resources/kotus-sanalista_v1.xml"));
        
        while (lukija.hasNextLine()) {
            
            String rivi = lukija.nextLine();
            rivi = rivi.substring(7);
            String osat[] = rivi.split("<");
            String sana = osat[0];
            trie.lisaaIlmanTarkistusta(sana);
        }
        lukija.close();
    }
    
    public String lueKalevala() throws FileNotFoundException {
        Scanner lukija = new Scanner(new File ("src/main/resources/kalevala.txt"));
        
        String teksti = "";
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            if (!((rivi.length() < 35 && rivi.contains("runo")) || rivi.isEmpty())) {
                teksti += rivi;
                teksti += " ";
            }
        }
        lukija.close();
        return teksti;
    }
    
}
