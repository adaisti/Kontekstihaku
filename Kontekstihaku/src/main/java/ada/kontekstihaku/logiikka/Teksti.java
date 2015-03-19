/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kontekstihaku.logiikka;

import java.util.ArrayList;

/**
 *
 * @author Ada
 */
public class Teksti {
    
    private String teksti;
    private ArrayList<String> virkkeet;
    private ArrayList<String> saneet;
    
    public Teksti(String teksti) {
        this.teksti = teksti;
        this.virkkeet = new ArrayList<>();
        this.saneet = new ArrayList<>();
    }
    
    public void jaottele() {
        String[] osat = this.teksti.split(" ");
        String virke = "";
        
        for (int i = 0; i < osat.length; i++) {
            saneet.add(osat[i]);
            virke += osat[i];
            virke += " ";
            if (onLopetusmerkki(osat[i].charAt(osat[i].length() - 1))) {
                virkkeet.add(virke);
                virke = "";
            }
        }
    }
    
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
