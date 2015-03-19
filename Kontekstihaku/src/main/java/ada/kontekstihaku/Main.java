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
        
        Teksti teksti = new Teksti("Ollako vai eikö olla? Kas siinä pulma! Jalompaa onko vaiti ottaa vastaan pahansuovan onnen turmannuolet, vai aseella selvä tehdä murheistaan? Lopettaa ne kerta kaikkiaan. Kuolla, nukkua vain, nukkua! Ja kenties nähdä unta?");
        
        System.out.println(teksti.etsiEsiintymia("vai").size());
        
    }
    
}
