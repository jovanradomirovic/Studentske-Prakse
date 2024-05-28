/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentske_prakse.domain;

/**
 *
 * @author radom
 */
public class Modul {
    private int ID;
    private String naziv;
    private int smerID;

    public Modul(int ID, String naziv, int smerID) {
        this.ID = ID;
        this.naziv = naziv;
        this.smerID = smerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getSmerID() {
        return smerID;
    }

    public void setSmerID(int smerID) {
        this.smerID = smerID;
    }
    
    
}
