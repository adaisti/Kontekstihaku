/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import java.util.ArrayList;

/**
 *
 * Luokka toteuttaa Trie-rakenteeseen kuuluvan solmun
 * 
 * @author Ada
 */
public class Solmu {
    
    private char arvo;
    public ArrayList<Solmu> lapset;
    private int moneenkoSanaanKuuluu;
    private int yleisyys;
    
    public Solmu(char arvo) {
        this.arvo = arvo;
        this.lapset = new ArrayList();
        this.moneenkoSanaanKuuluu = 0;
        this.yleisyys = 0;
    }
    
    /**
     * Metodi lisää solmulle lapsen, jos sitä ei ole solmulla ennestään
     * @param lapsi 
     */
    
    public void lisaaLapsi(Solmu lapsi) {
        if (!this.lapset.contains(lapsi)) {
            this.lapset.add(lapsi);
        }
    }
    
    /**
     * Metodi poistaa lapsen
     * @param lapsi 
     */
    
    public void poistaLapsi(Solmu lapsi) {
        if (this.lapset.contains(lapsi)) {
            this.lapset.remove(lapsi);
        }
    }
    
    /**
     * Metodi kasvattaa solmua hyödyntävien sanojen määrää yhdellä
     */
    
    public void lisaaKuuluvienSanojenMaaraa() {
        this.moneenkoSanaanKuuluu++;
        this.lisaaYleisyytta();
    }
    
    /**
     * Metodi vähentää solmua hyödyntävien sanojen määrää yhdellä
     */
    
    public void vahennaKuuluvienSanojenMaaraa() {
        this.moneenkoSanaanKuuluu--;
        this.vahennaYleisyytta();
    }
    
    /**
     * Metodi lisää yleisyyttä
     */
    
    public void lisaaYleisyytta() {
        this.yleisyys++;
    }
    
    /**
     * Metodi vähentää yleisyyttä
     */
    
    public void vahennaYleisyytta() {
        this.yleisyys--;
    }
    
    /**
     * Metodi palauttaa yleisyyden
     * @return yleisyys
     */
    
    public int yleisyys() {
        return this.yleisyys;
    }
    
    /**
     * Metodi palauttaa solmun yleisimmän lapsen
     * @return yleisin lapsi
     */
    
    public Solmu yleisinLapsi() {
        Solmu yleisin = this.getLapset().get(0);
        for (Solmu lapsi : lapset) {
            if (lapsi.yleisyys() > yleisin.yleisyys()) {
                yleisin = lapsi;
            }
        }
        return yleisin;
    }
    
    /**
     * Metodi kertoo, moniko sana hyödyntää solmun säilömää merkkiä
     * @return sanojen määrä
     */
    
    public int moneenkoSanaanKuuluu() {
        return moneenkoSanaanKuuluu;
    }
    
    /**
     * Metodi etsii solmun lapsista annetun solmun
     * @param lapsi
     * @return solmu jos on lapsissa, muuten null
     */
    
    public Solmu etsiLapsi(Solmu lapsi) {
        for (Solmu listalapsi : lapset) {
            if (listalapsi.equals(lapsi)) {
                return listalapsi;
            }
        }
        return null;
    }
    
    /**
     * Metodi palauttaa solmun lapset
     * @return lapset
     */
    
    public ArrayList<Solmu> getLapset() {
        return this.lapset;
    }
    
    /**
     * 
     * @param merkki
     * @return 
     */
    
    public Solmu etsiLastenArvoista(char merkki) {
        for (Solmu lapsi : lapset) {
            if (lapsi.arvo() == merkki) {
                return lapsi;
            }
        }
        return null;
    }
    
    /**
     * Metodi palauttaa solmun sisältämän merkin
     * @return merkki
     */
    
    public char arvo() {
        return this.arvo;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (o == null) {
            return false;
        }
        
        if (o.getClass() != Solmu.class) {
            return false;
        }
        
        Solmu verrattava = (Solmu) o;
        return this.arvo == verrattava.arvo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.arvo;
        return hash;
    }
    
    @Override
    public String toString() {
        return Character.toString(this.arvo);
    }
}
