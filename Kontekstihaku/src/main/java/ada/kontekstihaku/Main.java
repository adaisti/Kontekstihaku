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
import java.util.Scanner;

/**
 *
 * Main-luokka
 * 
 * @author Ada
 */

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner skanneri = new Scanner(System.in);
        Kayttoliittyma kl = new Kayttoliittyma(skanneri);
        
        kl.kaynnista();
       
    }
    
    
    public static void tulostaSolmut(Solmu solmu) {
        
        if (solmu.arvo() == '$') return;
        
        System.out.println(solmu.arvo() + " " + solmu.moneenkoSanaanKuuluu());
        
        for (Solmu lapsi : solmu.lapset) {
            tulostaSolmut(lapsi);
        }
    }
    
    public static void tulostaJokinSana(Solmu solmu) {
        if (solmu.arvo() == '$') return;
        
        System.out.println(solmu.arvo() + solmu.moneenkoSanaanKuuluu());
        
        if (!solmu.getLapset().isEmpty()) {
            tulostaJokinSana(solmu.getLapset().get(0));
        } else {
            return;
        }
    }
}
