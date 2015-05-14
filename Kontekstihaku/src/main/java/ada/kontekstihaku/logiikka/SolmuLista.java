/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * Luokka toteuttaa Solmuille Listan taulukoiden avulla
 * 
 * @author Ada
 * @param <T>
 */
public class SolmuLista<T> extends Lista<T> {

    private T[] t;
    
    public SolmuLista() {
        t = (T[]) new Solmu[0];
    }
   
    /**
     * Metodi palauttaa listan koon
     * @return listan koko
     */
    
    @Override
    public int size() {
        return t.length;
    }
    
    /**
     * Metodi tutkii onko joukko tyhjä
     * @return true jos on tyhjä
     */
    
    @Override
    public boolean isEmpty() {
        if (t.length == 0) {
            return true;
        }
        return false;
    }
    
    /**
    * Metodi tutkii sisältääkö lista jotain
    * @param o
    * @return true jos sisältää
    */

    @Override
    public boolean contains(Object o) {
        
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi lisää listaan annetun objektin
     * @param e
     * @return true jos lisääminen onnistui
     */
    
    @Override
    public boolean add(T e) {
        
        if (e == null) {
            return false;
        }
        
        if (e instanceof Solmu) {
            Solmu uusi = (Solmu) e;
            Solmu[] uusit = new Solmu[t.length + 1];
            
            
            for (int i = 0; i < t.length; i++) {
                uusit[i] = (Solmu) t[i];
            }
            uusit[t.length] = uusi;

            t = (T[]) uusit;
            return true;
        }
        return false;
    }
    
    /**
     * Metodi poistaa objektin listasta
     * @param o
     * @return true jos poistaminen onnistui
     */

    @Override
    public boolean remove(Object o) {
        
        if (o == null) {
            return false;
        }
        
        if (!contains((T) o)) {
            return false;
        }
        
        int indeksi = indexOf(o);
        Solmu[] uusit = new Solmu[t.length - 1];
        
        for (int i = 0; i < indeksi; i++) {
            uusit[i] = (Solmu) t[i];
        }
        
        for (int i = indeksi; i < t.length - 1; i++) {
            uusit[i] = (Solmu) t[i + 1];
        }
        
        t = (T[]) uusit;
        
        return true;
    }
    
    /**
     * Metodi tyhjentää listan kaikesta
     */
    
    @Override
    public void clear() {
        T[] uusit = (T[]) new Solmu[0];
        t = uusit;
        
    }
    
    /**
     * Metodi tutkii missä indeksissä jokin objekti on
     * 
     * @param o
     * @return objektin indeksi
     */
    
    @Override
    public int indexOf(Object o) {
        
        Solmu etsittava = (Solmu) o;
        
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals(etsittava)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Metodi palauttaa annetussa indeksissä olevan objektin
     * @param index
     * @return objekti
     */
    
    @Override
    public T get(int index) {
        return t[index];
    }
    
    @Override
    public String toString() {
        String lista = "[";
        lista += t[0];
        
        for (int i = 1; i < t.length; i++) {
            lista += ", ";
            lista += t[i];
        }
        
        lista += "]";
        return lista;
    }
    
}