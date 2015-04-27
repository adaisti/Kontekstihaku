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
        
        
        Lukija lukija = new Lukija();
        Teksti teksti = new Teksti(lukija.lueKalevala());
//        teksti.alustaTrieSanoilla();
//        
        Generoija gen = new Generoija(teksti);
//        
//        System.out.println(gen.generoiYleisinAloitus());
//        System.out.println(gen.generoiRandomSanaAlunPerusteella("väi"));
//        System.out.println(gen.generoiYleisinSanaAlunPerusteella("väin"));
//        System.out.println(gen.generoiYleisinSanaAlunPerusteella("al"));
//        System.out.println(gen.generoiYleisinSanaAlunPerusteella("kipu"));
//        System.out.println(gen.generoiYleisinSanaAlunPerusteella("ven"));
//        System.out.println(gen.generoiYleisinSanaAlunPerusteella("emo"));
        
//        System.out.println(gen.generoiRandomTekstia("a", 8));
//         System.out.println(gen.generoiRandomTekstia("y", 8));
//          System.out.println(gen.generoiRandomTekstia("k", 8));
//           System.out.println(gen.generoiRandomTekstia("e", 8));
//            System.out.println(gen.generoiRandomTekstia("v", 8));
        
        System.out.println(gen.generoiTodennakoistaTekstia("h", 8));
       
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
