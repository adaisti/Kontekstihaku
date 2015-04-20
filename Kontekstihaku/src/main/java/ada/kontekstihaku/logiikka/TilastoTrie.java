/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

/**
 *
 * Tähän trie-rakenteeseen voi lisätä saman sanan monta kertaa, ja se laskee, kuinka usein sana on lisättuy
 * 
 * @author Ada
 */
public class TilastoTrie extends Trie {
    
    public TilastoTrie() {
        
    }
    
    /**
     * Metodi lisää sanan jos sitä ei ole triessä tai muuten kasvattaa sen yleisyyttä
     * @param sana 
     */
    
    @Override
    public void lisaa(String sana) {
        if (this.sisaltaa(sana)) {
            Solmu nykyinen = super.alkusolmu;
            nykyinen.lisaaYleisyytta();
            for (int i = 0; i < sana.length(); i++) {
                Solmu lapsi = nykyinen.etsiLastenArvoista(sana.charAt(i));
                lapsi.lisaaYleisyytta();
                nykyinen = lapsi;
            }
            nykyinen.lisaaYleisyytta();
        } else {
            super.lisaaIlmanTarkistusta(sana);
        }
    }
    
    /**
     * Metodi vähentää sanan yleisyyttä triessä ja jos niitä on vain yksi, se poistaa sanan kokonaan
     * @param sana 
     */
    
    @Override
    public void poista(String sana) {
        if (!sisaltaa(sana)) return;
        
        Solmu nykyinen = alkusolmu;
        
        for (int i = 0; i < sana.length(); i++) {
            if (nykyinen.yleisyys() > 1) {
                nykyinen.vahennaYleisyytta();
                Solmu lapsi = nykyinen.etsiLastenArvoista(sana.charAt(i));
                nykyinen = lapsi;
            } else {
                super.poista(sana.substring(i));
            }
        }
    }
    
}
