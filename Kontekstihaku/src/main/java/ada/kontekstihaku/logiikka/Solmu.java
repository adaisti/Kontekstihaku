/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ada
 */
public class Solmu {
    
    private char arvo;
    public HashSet<Solmu> lapset;
    
    public Solmu(char arvo) {
        this.arvo = arvo;
        this.lapset = new HashSet();
    }
    
    public void lisaaLapsi(Solmu lapsi) {
        this.lapset.add(lapsi);
    }
    
    public Solmu etsiLapsi(Solmu lapsi) {
        for (Solmu listalapsi : lapset) {
            if (listalapsi.equals(lapsi)) {
                return listalapsi;
            }
        }
        return null;
    }
    
    public HashSet<Solmu> getLapset() {
        return this.lapset;
    }
    
    public Solmu etsiLastenArvoista(char merkki) {
        for (Solmu lapsi : lapset) {
            if (lapsi.arvo() == merkki) {
                return lapsi;
            }
        }
        return null;
    }
    
    public char arvo() {
        return this.arvo;
    }
    
    @Override
    public boolean equals(Object o) {
        
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
