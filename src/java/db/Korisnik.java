/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kojot
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kor_id")
    private Integer korId;
    @Size(max = 45)
    @Column(name = "kor_ime")
    private String korIme;
    @Size(max = 45)
    @Column(name = "kor_prezime")
    private String korPrezime;
    @Size(max = 45)
    @Column(name = "kor_email")
    private String korEmail;
    @Size(max = 45)
    @Column(name = "kor_sifra")
    private String korSifra;
    @Column(name = "kor_registrovan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date korRegistrovan;
    @Column(name = "kor_poslednjaprijava")
    @Temporal(TemporalType.TIMESTAMP)
    private Date korPoslednjaprijava;
    @Column(name = "kor_admin")
    private Integer korAdmin;
    @OneToMany(mappedBy = "korId")
    private Set<Komentar> komentarSet;

    public Korisnik() {
    }

    public Korisnik(Integer korId) {
        this.korId = korId;
    }

    public Integer getKorId() {
        return korId;
    }

    public void setKorId(Integer korId) {
        this.korId = korId;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getKorPrezime() {
        return korPrezime;
    }

    public void setKorPrezime(String korPrezime) {
        this.korPrezime = korPrezime;
    }

    public String getKorEmail() {
        return korEmail;
    }

    public void setKorEmail(String korEmail) {
        this.korEmail = korEmail;
    }

    public String getKorSifra() {
        return korSifra;
    }

    public void setKorSifra(String korSifra) {
        this.korSifra = korSifra;
    }

    public Date getKorRegistrovan() {
        return korRegistrovan;
    }

    public void setKorRegistrovan(Date korRegistrovan) {
        this.korRegistrovan = korRegistrovan;
    }

    public Date getKorPoslednjaprijava() {
        return korPoslednjaprijava;
    }

    public void setKorPoslednjaprijava(Date korPoslednjaprijava) {
        this.korPoslednjaprijava = korPoslednjaprijava;
    }

    public Integer getKorAdmin() {
        return korAdmin;
    }

    public void setKorAdmin(Integer korAdmin) {
        this.korAdmin = korAdmin;
    }

    @XmlTransient
    public Set<Komentar> getKomentarSet() {
        return komentarSet;
    }

    public void setKomentarSet(Set<Komentar> komentarSet) {
        this.komentarSet = komentarSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korId != null ? korId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korId == null && other.korId != null) || (this.korId != null && !this.korId.equals(other.korId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Korisnik[ korId=" + korId + " ]";
    }

    public void setKorId(Korisnik k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
