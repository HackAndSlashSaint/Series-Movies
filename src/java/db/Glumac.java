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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "glumac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glumac.findAll", query = "SELECT g FROM Glumac g")})
public class Glumac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "glu_id")
    private Integer gluId;
    @Size(max = 45)
    @Column(name = "glu_ime")
    private String gluIme;
    @Size(max = 45)
    @Column(name = "glu_prezime")
    private String gluPrezime;
    @Column(name = "glu_godiste")
    @Temporal(TemporalType.DATE)
    private Date gluGodiste;
    @Size(max = 45)
    @Column(name = "glu_drzava")
    private String gluDrzava;
    @JoinTable(name = "glumac_video", joinColumns = {
        @JoinColumn(name = "glu_id", referencedColumnName = "glu_id")}, inverseJoinColumns = {
        @JoinColumn(name = "vid_id", referencedColumnName = "vid_id")})
    @ManyToMany
    private Set<Video> videoSet;
    @OneToMany(mappedBy = "gluId")
    private Set<Slika> slikaSet;

    public Glumac() {
    }

    public Glumac(Integer gluId) {
        this.gluId = gluId;
    }

    public Integer getGluId() {
        return gluId;
    }

    public void setGluId(Integer gluId) {
        this.gluId = gluId;
    }

    public String getGluIme() {
        return gluIme;
    }

    public void setGluIme(String gluIme) {
        this.gluIme = gluIme;
    }

    public String getGluPrezime() {
        return gluPrezime;
    }

    public void setGluPrezime(String gluPrezime) {
        this.gluPrezime = gluPrezime;
    }

    public Date getGluGodiste() {
        return gluGodiste;
    }

    public void setGluGodiste(Date gluGodiste) {
        this.gluGodiste = gluGodiste;
    }

    public String getGluDrzava() {
        return gluDrzava;
    }

    public void setGluDrzava(String gluDrzava) {
        this.gluDrzava = gluDrzava;
    }

    @XmlTransient
    public Set<Video> getVideoSet() {
        return videoSet;
    }

    public void setVideoSet(Set<Video> videoSet) {
        this.videoSet = videoSet;
    }

    @XmlTransient
    public Set<Slika> getSlikaSet() {
        return slikaSet;
    }

    public void setSlikaSet(Set<Slika> slikaSet) {
        this.slikaSet = slikaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gluId != null ? gluId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glumac)) {
            return false;
        }
        Glumac other = (Glumac) object;
        if ((this.gluId == null && other.gluId != null) || (this.gluId != null && !this.gluId.equals(other.gluId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Glumac[ gluId=" + gluId + " ]";
    }
    
}
