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
        
        //Teksti teksti = new Teksti("Ollako vai eikö olla? Kas siinä pulma! Jalompaa onko vaiti ottaa vastaan pahansuovan onnen turmannuolet, vai aseella selvä tehdä murheistaan? Lopettaa ne kerta kaikkiaan. Kuolla, nukkua vain, nukkua! Ja kenties nähdä unta?");
        
        Teksti teksti = new Teksti("kissa");
        
        Trie trie = new Trie(teksti);
        trie.alusta();
        Solmu s = trie.alkusolmu;
        
        tulostaSolmut(s);
        
//        while(true){
//            if(s.lapset == null) break;
//            for(Solmu l : s.lapset){
//                System.out.println(l.arvo());
//                for(Solmu k : l.lapset){
//                    System.out.println(k.arvo());
//
//                }
//            }
//            
//        }
//        System.out.println(trie.sisaltaa("pulma"));
//        System.out.println(trie.sisaltaa("vai"));
//        System.out.println(trie.sisaltaa("siinä"));
//        System.out.println(trie.sisaltaa("onko"));
        System.out.println(trie.sisaltaa("kissa"));
        System.out.println(trie.sisaltaa("kis"));
        System.out.println(trie.sisaltaa("ssa"));

    }
    
    
    public static void tulostaSolmut(Solmu solmu) {
        
        if (solmu.arvo() == '$') return;
        
        System.out.println(solmu.arvo());
        
        for (Solmu lapsi : solmu.lapset) {
            tulostaSolmut(lapsi);
        }
        
    }
    
}
