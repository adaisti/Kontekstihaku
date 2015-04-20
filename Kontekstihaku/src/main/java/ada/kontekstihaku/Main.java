/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku;

import ada.kontekstihaku.logiikka.*;
import ada.kontekstihaku.logiikka.Generoija;
import ada.kontekstihaku.kayttoliittyma.*;
import ada.kontekstihaku.tiedostonkasittely.*;
import java.io.FileNotFoundException;

/**
 *
 * Main-luokka
 * 
 * @author Ada
 */

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        
//        Teksti teksti = new Teksti("varas kisko kii tuli vesi veri kisko kisko vasta varas");
//        
//        Generoija gen = new Generoija(teksti.getTrie(), teksti.getTilastoTrie());
//        System.out.println(teksti.getTrie().sisaltaa("kisko"));
//        System.out.println(teksti.getTrie().sisaltaaNainAlkavanSanan("ki"));
//        System.out.println(gen.generoiRandomSanaAlunPerusteella("kis"));
//        System.out.println(gen.generoiYleisinAloitus(teksti.getTilastoTrie().alkusolmu));
//        System.out.println(gen.generoiYleisinSanaAlunPerusteella("va"));
        
        Trie trie = new Trie();
        TilastoTrie tt = new TilastoTrie();
        
        Lukija lukija = new Lukija("src/main/resources/kotus-sanalista_v1.xml");
        lukija.lueKotuksenSanatTriehen(trie);
        
        Generoija gen = new Generoija(trie, tt);
        
        tulostaJokinSana(trie.alkusolmu);
        
//        for (int i = 0; i < 10; i++) {
//            System.out.println(gen.generoiRandomSana(trie.alkusolmu));
//        }
        
    }
    
    
    public static void tulostaSolmut(Solmu solmu) {
        
        if (solmu.arvo() == '$') return;
        
        System.out.println(solmu.arvo());
        
        for (Solmu lapsi : solmu.lapset) {
            tulostaSolmut(lapsi);
        }
    }
    
    public static void tulostaJokinSana(Solmu solmu) {
        if (solmu.arvo() == '$') return;
        
        System.out.println(solmu.arvo());
        
        if (!solmu.getLapset().isEmpty()) {
            tulostaJokinSana(solmu.getLapset().get(0));
        } else {
            return;
        }
    }
}
