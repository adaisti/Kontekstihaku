/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.tiedostonkasittely;

import ada.kontekstihaku.logiikka.Trie;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ada
 */
public class Lukija {
    
    private File tiedosto;
    
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
        Scanner lukija = new Scanner(this.tiedosto);
        
        while (lukija.hasNextLine()) {
            
            String rivi = lukija.nextLine();
            if (rivi.contains("<")) continue;
            String[] osat = rivi.split("<");
            String sanaJaLuokka = osat[1];
            if (sanaJaLuokka.contains(">")) continue;
            String[] osat2 = sanaJaLuokka.split(">");
            String sana = osat2[1];
            trie.lisaa(sana);
        }
        lukija.close();
    }
    
}
