/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import ada.kontekstihaku.logiikka.Trie;
import java.util.Random;

/**
 *
 * Luokka kokoaa automaattiseen tekstin generoimiseen liittyviä toimintoja
 * 
 * @author Ada
 */
public class Generoija {
    
    private Trie trie;
    
    public Generoija(Trie trie) {
        this.trie = trie;
    }
    
    /**
     * Metodi generoi sattumanvaraisesti triestä löytyvän sanan annetun alun perusteella
     * @param alku
     * @return generoitu sana
     */
    
    public String generoiRandomSanaAlunPerusteella(String alku) {
        
        if (!trie.sisaltaaNainAlkavanSanan(alku)) {
            return "";
        }
        
        Solmu nykyinen = trie.alkusolmu;
        
        for (int i = 0; i < alku.length(); i++) {
            Solmu lapsi = nykyinen.etsiLastenArvoista(alku.charAt(i));
            nykyinen = lapsi;
        }
        
        String sana = alku;
        
        sana += generoiRandomSana(nykyinen);
        
        return sana;
    }
    
    /**
     * Metodi generoi sattumanvaraisen sanan, joka löytyy triestä
     * @param nykyinen
     * @return generoitu sana
     */
    
    public String generoiRandomSana(Solmu nykyinen) {
        Random random = new Random();
        String sana = "";
        
         while (!nykyinen.getLapset().isEmpty()) {
            Solmu arvottuLapsi = nykyinen.getLapset().get(random.nextInt(nykyinen.getLapset().size()));
            if (arvottuLapsi.arvo() == '$') break;
            sana += Character.toString(arvottuLapsi.arvo());
            nykyinen = arvottuLapsi;
        }
        return sana;
    }
    
}
