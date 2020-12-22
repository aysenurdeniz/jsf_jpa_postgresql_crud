/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KullaniciFacade;
import entity.Kullanici;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author anurd
 */
@Named("kullaniciCont")
@ViewScoped
public class KullaniciController implements Serializable {

    private Kullanici kullanici;
    @EJB
    private KullaniciFacade kf;

    public void create() {
        this.kf.create(kullanici);
        this.kullanici = new Kullanici();
    }

    public List<Kullanici> getRead() {
        return this.kf.findAll();
    }

    public void updateForm(Kullanici k) {
        this.kullanici = k;
    }

    public void update() {
        this.kf.edit(kullanici);
        this.kullanici = new Kullanici();
    }

    public void delete(Kullanici k) {
        this.kf.remove(k);
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            return this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

}
