/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import java.util.ArrayList;

/**
 *
 * Luokka toteuttaa sananmuotojen säilömiseen ja hakemiseen soveltuvan trie-tietorakenteen
 * 
 * @author Ada
 */
public class Trie {
    
    public Solmu alkusolmu;
    
    public Trie() {
        this.alkusolmu = new Solmu(' ');
    }
    
    
    /**
     * Metodi tutkii sisältääkö joku solmu alipuineen annetun sanan
     * @param sana
     * @param solmu
     * @param i
     * @return 
     */
    
    public boolean sisaltaa(String sana, Solmu solmu, int i) {
                
        if (sana.isEmpty()) return false;
        
        for (Solmu lapsi : solmu.getLapset()) {
            if (lapsi.arvo() == sana.charAt(i)) {
                if (i == sana.length() - 1) {
                    if (lapsi.etsiLastenArvoista('$') != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
                else {
                    return sisaltaa(sana, lapsi, i + 1);
                }
            }
        }
        
        return false;
    }
    
    /**
     * Metodi tutkii sisältääkö Trie annetun sanan
     * @param sana
     * @return true jos sisältää
     */
    
    public boolean sisaltaa(String sana) {
        return sisaltaa(sana, alkusolmu, 0);
    }
    
    /**
     * Metodi tutkii sisältääkö Trie näin alkavan sanan
     * @param sana
     * @param solmu
     * @param i
     * @return true jos sisältää
     */
    
    public boolean sisaltaaNainAlkavanSanan(String sana, Solmu solmu, int i) {
                 
        for (Solmu lapsi : solmu.getLapset()) {
            if (lapsi.arvo() == sana.charAt(i)) {
                if (i == sana.length() - 1) {
                    return true;
                }
                else {
                    return sisaltaaNainAlkavanSanan(sana, lapsi, i + 1);
                }
            }
        }
        
        return false;
    }
    
    /**
     * Metodi tutkii sisältääkö Trie näin alkavan sanan
     * @param alku
     * @return true jos sisältää
     */
    
    public boolean sisaltaaNainAlkavanSanan(String alku) {
        return sisaltaaNainAlkavanSanan(alku, alkusolmu, 0);
    }
    
    /**
     * Metodi poistaa sanan puusta
     * @param sana 
     */
    
    public void poista(String sana) {
        if (!sisaltaa(sana)) {
            return;
        }
        
        Solmu nykyinen = alkusolmu;
        
        for (int i = 0; i < sana.length(); i++) {
            nykyinen.vahennaKuuluvienSanojenMaaraa();
            Solmu lapsi = nykyinen.etsiLastenArvoista(sana.charAt(i));
            
            if (lapsi.moneenkoSanaanKuuluu() == 1) {
                nykyinen.poistaLapsi(lapsi);
                return;
            } else {
                nykyinen = lapsi;
            }
           
        }
        
    }
    
    
    
    /**
     * Metodi lisää Trieen annetun sanan
     * @param sana 
     */
    
    public void lisaa(String sana) {
        
        if (sisaltaa(sana, alkusolmu, 0)) {
            return;
        }
        
        lisaaIlmanTarkistusta(sana);
        
    }
    
    public void lisaaIlmanTarkistusta(String sana) {
        
        if (sana.isEmpty()) return;
        
        alkusolmu.lisaaKuuluvienSanojenMaaraa();
        
        if (alkusolmu.etsiLastenArvoista(sana.charAt(0)) == null) {
            luoAlipuu(sana, alkusolmu);
        } else {
            
            Solmu nykyinen = alkusolmu;
            
            for (int i = 0; i < sana.length(); i++) {
                Solmu oikeaLapsi = nykyinen.etsiLastenArvoista(sana.charAt(i));
                
                if (oikeaLapsi == null) {
                    luoAlipuu(sana.substring(i, sana.length()), nykyinen);
                    return;
                } else {
                    nykyinen = oikeaLapsi;
                    nykyinen.lisaaKuuluvienSanojenMaaraa();
                    
                    if (i == sana.length() - 1) {
                        Solmu lopetus = new Solmu('$');
                        nykyinen.lisaaLapsi(lopetus);
                        lopetus.lisaaKuuluvienSanojenMaaraa();
                    }
                    
                }
            }
        }
    }
    
    /**
     * Metodi luo annetulle solmulle alipuun annetusta sanasta
     * @param sana
     * @param vanhempi 
     */
    
    public void luoAlipuu(String sana, Solmu vanhempi) {
        
        Solmu nykyinen = vanhempi;
        for (int i = 0; i < sana.length(); i++) {
            Solmu lapsi = new Solmu(sana.charAt(i));
            nykyinen.lisaaLapsi(lapsi);
            nykyinen = lapsi;
            nykyinen.lisaaKuuluvienSanojenMaaraa();
        }
        Solmu lapsi = new Solmu('$');
        nykyinen.lisaaLapsi(lapsi);
        lapsi.lisaaKuuluvienSanojenMaaraa();
    }
    
}
