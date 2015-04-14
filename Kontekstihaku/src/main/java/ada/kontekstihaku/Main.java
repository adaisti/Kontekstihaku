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
 * @author Ada
 */

public class Main {
    
    public static void main(String[] args) {
        
        
        Teksti teksti = new Teksti("kisa kisko kii tuli vesi veri vasta");
        
        Trie trie = new Trie(teksti);
        trie.alusta();
        
        Solmu s = trie.alkusolmu;
        
        
        tulostaSolmut(s);
        
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
