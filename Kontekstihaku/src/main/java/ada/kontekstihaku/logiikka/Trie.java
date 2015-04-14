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
    
    private Teksti teksti;
    public Solmu alkusolmu;
    
    public Trie(Teksti teksti) {
        this.teksti = teksti;
        this.alkusolmu = new Solmu(' ');
    }
    
    /**
     * Metodi alustaa Trie-rakenteen tekstin perusteella
     */
    
    public void alusta() {
        for (String sane : this.teksti.saneet()) {
            lisaa(sane);
        }
    }
    
    /**
     * Metodi tutkii sisältääkö joku solmu alipuineen annetun sanan
     * @param sana
     * @param solmu
     * @param i
     * @return 
     */
    
    public boolean sisaltaa(String sana, Solmu solmu, int i) {
                
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
     * Metodi lisää Trieen annetun sanan
     * @param sana 
     */
    
    public void lisaa(String sana) {
        
       
        if (sisaltaa(sana, alkusolmu, 0)) {
            return;
        }
        
        if (alkusolmu.etsiLastenArvoista(sana.charAt(0)) == null) {
            luoAlipuu(sana, alkusolmu);
        } else {
            
            Solmu nykyinen = alkusolmu;
            nykyinen.lisaaKuuluvienSanojenMaaraa();
            
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
