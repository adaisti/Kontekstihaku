/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * Luokka kokoaa erilaisia tekstien tutkimiseen käytettäviä metodeja
 * 
 * @author Ada
 */
public class Teksti {
    
    private String teksti;
    private ArrayList<String> virkkeet;
    private ArrayList<String> saneet;
    private ArrayList<String> sanaparit;
    private HashSet<String> sananmuodot;
    private Trie trie;
    private Trie paritrie;
    private TilastoTrie tt;
    private TilastoTrie paritt;
        
    
    public Teksti(String teksti) {
        this.teksti = teksti;
        this.virkkeet = new ArrayList<>();
        this.saneet = new ArrayList<>();
        this.sanaparit = new ArrayList();
        this.sananmuodot = new HashSet<>();
        this.trie = new Trie();
        this.paritrie = new Trie();
        this.tt = new TilastoTrie();
        this.paritt = new TilastoTrie();
        
        for (String sane : saneet) {
            sananmuodot.add(sane);
        }
    }
    
    /**
     * Metodi jakaa annetun tekstin saneiksi ja virkkeiksi
     */
    
    public void jaottele() {
        String[] osat = this.teksti.split(" ");
        String virke = "";
        
        for (int i = 0; i < osat.length; i++) {
            saneet.add(osat[i].toLowerCase());
            virke += osat[i];
            virke += " ";
            
            if (osat[i].length() < 1) continue;
            
            if (onLopetusmerkki(osat[i].charAt(osat[i].length() - 1))) {
                virkkeet.add(virke);
                virke = "";
            }
        }
    }
    
    /**
     * Metodi jakaa tekstin saneiksi
     */
    
    public void jaotteleSaneiksi() {
        String[] osat = this.teksti.split(" ");
        
        for (int i = 0; i < osat.length; i++) {
            this.saneet.add(siisti(osat[i]));
        }
        
    }
    
    public void jaotteleSanePareiksi() {
        String[] osat = this.teksti.split(" ");
        
        for (int i = 0; i < osat.length - 1; i++) {
            this.sanaparit.add(siisti(osat[i]) + " " + siisti(osat[i + 1]));
        }
    }
    
    
    /**
     * Metodi siistii sanan
     * @param sana 
     * @return  siistitty
     */
    
    public String siisti(String sana) {
        sana = sana.toLowerCase();
        sana = sana.replace(",", "");
        sana = sana.replace(".", "");
        sana = sana.replace("!", "");
        sana = sana.replace("?", "");
        sana = sana.replace(":", "");
        sana = sana.replace(";", "");
        sana = sana.replace("\"", "");
        return sana;
    }
    
    /**
     * Metodi alustaa trien
     */
    
    public void alustaTrieSanoilla() {
        this.jaotteleSaneiksi();
        for (String sane : saneet) {
            trie.lisaa(sane);
            tt.lisaa(sane);
        }
    }
    
    /**
     * Metodi alustaa trien sanapareilla
     */
    
    public void alustaTrieSanapareilla() {
        this.jaotteleSanePareiksi();
        for (String sanapari : sanaparit) {
            paritrie.lisaa(sanapari);
            paritt.lisaa(sanapari);
        }
    }
    
    
    
    /**
     * Metodi palauttaa tilastotrien
     * @return tilastotrie
     */
    
    public TilastoTrie getTilastoTrie() {
        return this.tt;
    }
    
    /**
     * Metodi palauttaa Trien
     * @return 
     */
    
    public Trie getTrie() {
        return this.trie;
    }
    
    public TilastoTrie getPariTt() {
        return this.paritt;
    }
    
    public Trie getPariTrie() {
        return this.paritrie;
    }
    
    /**
     * Metodi etsii annetulle saneelle kaikki sen edessä ja takana olevat saneet
     * @param sananmuoto
     * @return lista 2 sanan kokoisista konteksteista
     */
    
    public ArrayList<String> peruskontekstit(String sananmuoto) {
        ArrayList<String> kontekstit = new ArrayList();
        String konteksti = "";
        
        for (String esiintyma : esiintymat(sananmuoto)) {
            String osat[] = esiintyma.split(" ");
            
            for (int i = 0; i < osat.length; i++) {
                if (osat[i].equals(sananmuoto)) {
                    if (i > 0 && i < osat.length - 1) {
                        konteksti += osat[i - 1];
                        konteksti += "_";
                        konteksti += osat[i + 1];
                    } else if (i == 0) {
                        konteksti += "_";
                        konteksti += osat[i + 1];
                    } else if (i == osat.length - 1) {
                        konteksti += osat[i - 1];
                        konteksti += "_";
                    }
                    kontekstit.add(konteksti);
                    konteksti = "";
                }
            }
        }
        return kontekstit;
    }
    
    /**
     * Metodi etsii kahdelle sanalle yhteiset peruskontekstit eli tilanteet joissa ne ovat samojen sanojen ympäröiminä
     * @param sana1
     * @param sana2
     * @return molemmille sanoille yhteiset peruskontekstit
     */
    
    public ArrayList<String> yhteisetPeruskontekstit(String sana1, String sana2) {
        ArrayList<String> yhteisetKontekstit = new ArrayList();
        ArrayList<String> ekanPeruskontekstit = peruskontekstit(sana1);
        ArrayList<String> tokanPeruskontekstit = peruskontekstit(sana2);
        for (String konteksti : ekanPeruskontekstit) {
            if (tokanPeruskontekstit.contains(konteksti)) {
                yhteisetKontekstit.add(konteksti);
            }
        }
        return yhteisetKontekstit;
    }
    
    /**
     * Metodi listaa kaikki sanat jotka ovat ainakin kerran esiintyneet samanlaisessa kontekstissa kuin
     * annettu sana
     * @param sana
     * @return samoissa yhteyksissä esiintyneet sanat
     */
    
    public ArrayList<String> samankaltaisiaSanoja(String sana) {
        ArrayList<String> samankaltaiset = new ArrayList();
        for (String sananmuoto : this.sananmuodot) {
            if (!yhteisetPeruskontekstit(sana, sananmuoto).isEmpty()) {
                samankaltaiset.add(sananmuoto);
            }
        }
        return samankaltaiset;
    }
    
    
    /**
     * Metodi etsii annetun sanan esiintymät tekstissä
     * @param sana
     * @return 
     */
    
    public ArrayList<String> esiintymat(String sana) {
        
        sana = sana.toLowerCase();
        String haettava = " ";
        haettava += sana;
        haettava += " ";
        if (!this.saneet.contains(sana)) {
            return new ArrayList();
        } else {
            return etsiEsiintymia(haettava);
        }
    }
    
    /**
     * Metodi etsii kaikki annetun merkkijonon esiintymät eli löytää sen myös, vaikka se olisi osa muuta sanaa
     * @param sana
     * @return lista virkkeistä, joissa esiintyy
     */
    
    public ArrayList<String> etsiEsiintymia(String sana) {
        jaottele();
        ArrayList<String> esiintymat = new ArrayList();
        for (String virke : this.virkkeet) {
            if (virke.contains(sana)) {
                esiintymat.add(virke);
            }
        }
        return esiintymat;
    }
    
    /**
     * Metodi tutkii onko jokin merkki lopetusmerkki
     * @param merkki
     * @return true jos on lopetusmerkki
     */
    
    public boolean onLopetusmerkki(char merkki) {
        if (merkki == '.' || merkki == '!' || merkki == '?') {
            return true;
        }
        return false;
    }
    
   
    public ArrayList<String> virkkeet() {
        return this.virkkeet;
    }
    
    public ArrayList<String> saneet() {
        return this.saneet;
    }
}
