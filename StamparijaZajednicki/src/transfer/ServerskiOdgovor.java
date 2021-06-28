/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Kosta
 */
public class ServerskiOdgovor implements Serializable{
    private Object odgovor;
    private String poruka;
    private boolean uspesno;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, String poruka, boolean uspesno) {
        this.odgovor = odgovor;
        this.poruka = poruka;
        this.uspesno = uspesno;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
    
}
