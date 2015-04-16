/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku;

import ada.kontekstihaku.logiikka.*;
import ada.kontekstihaku.kayttoliittyma.*;

/**
 *
 * Main-luokka
 * 
 * @author Ada
 */

public class Main {
    
    public static void main(String[] args) {
        
        
        Teksti teksti = new Teksti("kisa kisko kii tuli vesi veri vasta kisa");
        
        Generoija gen = new Generoija(teksti.getTrie());
        System.out.println(teksti.getTrie().sisaltaaNainAlkavanSanan("kis"));
        System.out.println(gen.generoiRandomSanaAlunPerusteella("kis"));
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
