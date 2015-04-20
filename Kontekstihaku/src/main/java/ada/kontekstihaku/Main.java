/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku;

import ada.kontekstihaku.logiikka.*;
import ada.kontekstihaku.logiikka.Generoija;
import ada.kontekstihaku.kayttoliittyma.*;

/**
 *
 * Main-luokka
 * 
 * @author Ada
 */

public class Main {
    
    public static void main(String[] args) {
        
        
        Teksti teksti = new Teksti("kisa kisko kii tuli vesi veri vasta kisko vasta kisko");
        
        Generoija gen = new Generoija(teksti.getTrie(), teksti.getTilastoTrie());
        System.out.println(teksti.getTrie().sisaltaa("kisko"));
        System.out.println(teksti.getTrie().sisaltaaNainAlkavanSanan("ki"));
        System.out.println(gen.generoiRandomSanaAlunPerusteella("kis"));
        System.out.println(gen.generoiYleisinSana(teksti.getTilastoTrie().alkusolmu));
        System.out.println(gen.generoiYleisinSanaAlunPerusteella("v"));
    }
    
    
    public static void tulostaSolmut(Solmu solmu) {
        
        if (solmu.arvo() == '$') return;
        
        System.out.println(solmu.arvo() + ": " + solmu.moneenkoSanaanKuuluu());
        
        for (Solmu lapsi : solmu.lapset) {
            tulostaSolmut(lapsi);
        }
        System.out.println("----");
    }
    
}
