/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import java.util.Random;

/**
 *
 * Luokka kokoaa automaattiseen tekstin generoimiseen liittyviä toimintoja
 * 
 * @author Ada
 */
public class Generoija {
    
    private Trie trie;
    private TilastoTrie tt;
    private Teksti teksti;
    private Trie pariTrie;
    private TilastoTrie paritt;
    
    public Generoija (Teksti teksti) {
        this.teksti = teksti;
        this.trie = teksti.getTrie();
        this.tt = teksti.getTilastoTrie();
        this.pariTrie = teksti.getPariTrie();
        this.paritt = teksti.getPariTt();
    }
    
    public Generoija(Trie trie, TilastoTrie tt) {
        this.trie = trie;
        this.tt = tt;
    }
    
    public String generoiRandomSanaAlunPerusteella(String alku) {
        return generoiRandomSanaAlunPerusteella(alku, trie);
    }
    
    
    /**
     * Metodi generoi sattumanvaraisesti triestä löytyvän sanan annetun alun perusteella
     * @param alku
     * @return generoitu sana
     */
    
    public String generoiRandomSanaAlunPerusteella(String alku, Trie trie) {
        
        if (!trie.sisaltaaNainAlkavanSanan(alku)) {
            return "";
        }
        
        Solmu nykyinen = trie.alkusolmu;
        
        for (int i = 0; i < alku.length(); i++) {
            Solmu lapsi = nykyinen.etsiLastenArvoista(alku.charAt(i));
            nykyinen = lapsi;
        }
        
        String sana = alku;
        
        sana += generoiRandomSana(nykyinen);
        
        return sana;
    }
    
    /**
     * Metodi generoi sattumanvaraisen sanan, joka löytyy triestä
     * @param nykyinen
     * @return generoitu sana
     */
    
    public String generoiRandomSana(Solmu nykyinen) {
        Random random = new Random();
        String sana = "";
        
        while (!nykyinen.getLapset().isEmpty()) {
            Solmu arvottuLapsi = nykyinen.getLapset().get(random.nextInt(nykyinen.getLapset().size()));
            if (arvottuLapsi.arvo() == '$') break;
            sana += Character.toString(arvottuLapsi.arvo());
            nykyinen = arvottuLapsi;
        }
        return sana;
    }
    
    public String generoiYleisinSanaAlunPerusteella(String alku) {
        return generoiYleisinSanaAlunPerusteella(alku, tt);
    }
    
    /**
     * Metodi generoi yleisimmän jotenkin alkavan sanan
     * @param alku
     * @param tt
     * @return yleisin sana
     */
    
    public String generoiYleisinSanaAlunPerusteella(String alku, TilastoTrie tt) {
        if (!tt.sisaltaaNainAlkavanSanan(alku)) {
            return "";
        }
        
        Solmu nykyinen = tt.alkusolmu;
        
        for (int i = 0; i < alku.length(); i++) {
            Solmu lapsi = nykyinen.etsiLastenArvoista(alku.charAt(i));
            nykyinen = lapsi;
        }
        
        String sana = alku;
        
        sana += generoiYleisinAloitus(nykyinen);
        
        return sana;
    }
    
    
    /**
     * Metodi generoi annetusta solmusta lähtevän yleisimmän sanan(lopun)
     * @param nykyinen
     * @return yleisin sana
     */
    
    public String generoiYleisinAloitus(Solmu nykyinen) {
        String sana = "";
        
        while (!nykyinen.getLapset().isEmpty()) {
            Solmu yleisinLapsi = nykyinen.yleisinLapsi();
            if (yleisinLapsi.arvo() == '$') break;
            sana += Character.toString(yleisinLapsi.arvo());
            nykyinen = yleisinLapsi;
        }
        return sana;
    }
    
    /**
     * Metodi generoi yleisimmän aloituksen koko triessä
     * @return sana tai aloitus
     */
    
    public String generoiYleisinAloitus() {
        return generoiYleisinAloitus(this.tt.alkusolmu);
    }
    
    /**
     * Metodi generoi todennäköistä tekstiä
     * @param alku
     * @param sanoja
     * @return tekstiä
     */
    
    public String generoiTodennakoistaTekstia(String alku, int sanoja) {
        this.teksti.alustaTrieSanapareilla();
        String sanapari = this.generoiYleisinSanaAlunPerusteella(alku, paritt);
        
        if (sanapari.isEmpty()) {
            sanapari = generoiRandomSanaAlunPerusteella(alku);
        }
        
        String luotavaTeksti = "";
        Solmu nykyinen = paritt.alkusolmu;
        String nykyinenSana = "";
        int i = 0;
        
        while(i < sanoja) {
            
            for (int j = 0; j < sanapari.length(); j++) {
                
                Solmu lapsi = nykyinen.etsiLastenArvoista(sanapari.charAt(j));
                luotavaTeksti += Character.toString(lapsi.arvo());
                nykyinen = lapsi;
                
                if (sanapari.charAt(j) == ' ') {
                    j++;
                    for (int k = j; k < sanapari.length(); k++) {
                        lapsi = nykyinen.etsiLastenArvoista(sanapari.charAt(k));
                        nykyinenSana += Character.toString(lapsi.arvo());
                        nykyinen = lapsi;
                        j++;
                    }
                }
            }
            sanapari = this.generoiYleisinSanaAlunPerusteella(nykyinenSana + " ");
            
            if (sanapari.isEmpty()) {
                // voisi tilastoida milloin tänne aina mennään ja miksi
                sanapari = generoiRandomSanaAlunPerusteella(nykyinenSana + " ", paritt);
            }
            
            i++;
            nykyinenSana = "";
            nykyinen = paritt.alkusolmu;
        }  
        return luotavaTeksti;
    }
    
    public String generoiRandomTekstia(String alku, int sanoja) {
        
        this.teksti.alustaTrieSanapareilla();
        String sanapari = this.generoiRandomSanaAlunPerusteella(alku, pariTrie);
        String luotavaTeksti = "";
        Solmu nykyinen = pariTrie.alkusolmu;
        String nykyinenSana = "";
        int i = 0;
        
        while(i < sanoja) {
            
            for (int j = 0; j < sanapari.length(); j++) {
                
                Solmu lapsi = nykyinen.etsiLastenArvoista(sanapari.charAt(j));
                luotavaTeksti += Character.toString(lapsi.arvo());
                nykyinen = lapsi;
                
                if (sanapari.charAt(j) == ' ') {
                    j++;
                    for (int k = j; k < sanapari.length(); k++) {
                        lapsi = nykyinen.etsiLastenArvoista(sanapari.charAt(k));
                        nykyinenSana += Character.toString(lapsi.arvo());
                        nykyinen = lapsi;
                        j++;
                    }
                }
            }
            sanapari = this.generoiRandomSanaAlunPerusteella(nykyinenSana + " ", pariTrie);
            i++;
            nykyinenSana = "";
            nykyinen = pariTrie.alkusolmu;
        }  
        return luotavaTeksti;
    }
    
    
    
    
}
