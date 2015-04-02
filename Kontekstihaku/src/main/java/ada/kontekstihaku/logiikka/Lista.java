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
 * @author Ada
 * @param <T>
 */
public class Lista<T> implements List<T> {

    private T[] t;
    
    public Lista(String sana) {
        t = (T[]) new String [0];
    }
    
    @Override
    public int size() {
        return t.length;
    }

    @Override
    public boolean isEmpty() {
        if (t.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean add(T e) {
        
        if (e == null) {
            return false;
        }
        
        if (e instanceof String) {
            String uusi = (String) e;
            String[] uusit = new String[t.length];
            uusit[t.length] = uusi;
            t = (T[]) uusit;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        
        if (o == null) {
            return false;
        }
        
        if (!contains((T) o)) {
            return false;
        }
        
        int indeksi = indexOf(o);
        String[] uusit = new String[t.length - 2];
        
        for (int i = 0; i < indeksi; i++) {
            uusit[i] = (String) t[i];
        }
        
        for (int i = indeksi; i < t.length - 1; i++) {
            uusit[i] = (String) t[i + 1];
        }
        
        t = (T[]) uusit;
        
        return true;
    }
    
    @Override
    public void clear() {
        T[] uusit = (T[]) new String[0];
        t = uusit;
        
    }
    
    @Override
    public T get(int index) {
        return t[index];
    }
    
    @Override
    public int indexOf(Object o) {
        
        String etsittava = (String) o;
        
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals(etsittava)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
