/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.kayttoliittyma;

import ada.kontekstihaku.logiikka.Generoija;
import ada.kontekstihaku.logiikka.Teksti;
import ada.kontekstihaku.tiedostonkasittely.Lukija;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * Luokka vastaa käyttöliittymän toteutuksesta
 * 
 * @author Ada
 */
public class Kayttoliittyma {
    
    private Teksti teksti;
    private Generoija generoija;
    private Scanner skanneri;
    private Lukija lukija;
    
    public Kayttoliittyma(Scanner lukija) {
        this.skanneri = lukija;
        this.lukija = new Lukija();
    }
    
    public void kaynnista() throws FileNotFoundException {
        System.out.println("Tervetuloa Adan tekstintarkasteluohjelman pariin!");
        System.out.println("");
        
        alusta();
        
        System.out.println("Kiitos hei!");
    }
    
    public void alusta() throws FileNotFoundException {
        System.out.println("Valitse lähdeteksti:");
        System.out.println("  1. Kotus");
        System.out.println("  2. Kalevala");
        
        String valinta = skanneri.nextLine();
        
        if (valinta.equals("1")) {
            this.teksti = new Teksti("");
            lukija.lueKotuksenSanatTriehen(teksti.getTrie());
            generoija = new Generoija(teksti);
            kasitteleKotus(); 
        } else if (valinta.equals("2")) {
            this.teksti = new Teksti(lukija.lueKalevala());
            generoija = new Generoija(teksti);
//            teksti.alustaTrieSanapareilla();
            teksti.alustaTrieSanoilla();
            while (true) {
                tulostaValikko();
                String komento = skanneri.nextLine();
                if (komento.isEmpty()) return;
                tulkitseKomento(komento);
            }
        } else {
            alusta();
        }
    }
    
    public void tulkitseKomento(String komento) {
        
        switch (komento) {
            
            case "1":
                yleinenSana();
                break;
            case "2":
                randomSana();
                break;
            case "3":
                yleisin();
                break;
            case "4":
                random();
                break;
            case "5":
                yleistaTekstia();
                break;
            case "6":
                satunnaistaTekstia();
                break;
//            case "7":
//                kontekstit();
//                break;
//            case "8":
//                samanlaiset();
        }
    }
    
    public void samanlaiset() {
        System.out.println("Anna sana:");
        String sana = skanneri.nextLine();
        System.out.println(teksti.samankaltaisiaSanoja(sana));
    }
    
    public void kontekstit() {
        System.out.println("Anna sana:");
        String sana = skanneri.nextLine();
        System.out.println(teksti.peruskontekstit(sana));
    }
    
    public void random() {
        System.out.println(generoija.generoiRandomSana(teksti.getTrie().alkusolmu));
    }
    
    public void satunnaistaTekstia() {
        System.out.println("Kuinka pitkä teksti?");
        int sanoja = 0;
        
        try {
            sanoja = Integer.parseInt(skanneri.nextLine());
        } catch (Exception e) {
            System.out.println("Anna pituus kokonaislukuna!");
            satunnaistaTekstia();
            return;
        }
        
        System.out.println("Anna alku");

        String alku = skanneri.nextLine();
        
        System.out.println(generoija.generoiRandomTekstia(alku, sanoja));
    }
    
    
    public void yleistaTekstia() {
        System.out.println("Kuinka pitkä teksti?");
        int sanoja = 0;
        
        try {
            sanoja = Integer.parseInt(skanneri.nextLine());
        } catch (Exception e) {
            System.out.println("Anna pituus kokonaislukuna!");
            yleistaTekstia();
            return;
        }
        
        System.out.println("Anna alku");

        String alku = skanneri.nextLine();
        
        System.out.println(generoija.generoiTodennakoistaTekstia(alku, sanoja));
    }
    
    public void yleisin() {
        System.out.println(generoija.generoiYleisinAloitus());
    }
    
    public void yleinenSana() {
        System.out.println("Anna alku:");
        String alku = skanneri.nextLine();
        System.out.println(generoija.generoiYleisinSanaAlunPerusteella(alku));
    }
    
    public void randomSana() {
        System.out.println("Anna alku:");
        String alku = skanneri.nextLine();
        System.out.println(generoija.generoiRandomSanaAlunPerusteella(alku));
    }
    
    public void tulostaValikko() {
        System.out.println("Anna komento");
        System.out.println("  1. Generoi yleinen sana alun perusteella");
        System.out.println("  2. Generoi satunnainen sana alun perusteella");
        System.out.println("  3. Generoi yleisin sana");
        System.out.println("  4. Generoi satunnainen sana");
        System.out.println("  5. Generoi yleistä tekstiä alun perusteella");
        System.out.println("  6. Generoi satunnaista tekstiä alun perusteella");
//        System.out.println("  7. Etsi sanalle konteksteja");
//        System.out.println("  8. Etsi samankaltaisissa konteksteissa esiintyviä sanoja");
        System.out.println("Tyhjä komento lopettaa ohjelman");
    }
    
    public void kasitteleKotus() {
        System.out.println("Voit generoida sanoja alun perusteella.");
        System.out.println("Tyhjä sana lopettaa ohjelman käytön.");
        while (true) {
            System.out.println("Anna alku:");
            String alku = skanneri.nextLine();
            if (alku.isEmpty()) break;
            System.out.println(generoija.generoiRandomSanaAlunPerusteella(alku));
        }
    }
    
    
    
}
