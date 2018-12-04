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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")})
public class Video implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "vid_opis")
    private String vidOpis;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vid_id")
    private Integer vidId;
    @Size(max = 45)
    @Column(name = "vid_ime")
    private String vidIme;
    @Column(name = "vid_datum")
    @Temporal(TemporalType.DATE)
    private Date vidDatum;
    @ManyToMany(mappedBy = "videoSet")
    private Set<Glumac> glumacSet;
    @JoinTable(name = "video_zanr", joinColumns = {
        @JoinColumn(name = "vid_id", referencedColumnName = "vid_id")}, inverseJoinColumns = {
        @JoinColumn(name = "zan_id", referencedColumnName = "zan_id")})
    @ManyToMany
    private Set<Zanr> zanrSet;
    @OneToMany(mappedBy = "vidId")
    private Set<Trailer> trailerSet;
    @OneToMany(mappedBy = "vidId")
    private Set<Slika> slikaSet;
    @OneToMany(mappedBy = "vidId")
    private Set<Komentar> komentarSet;
    @JoinColumn(name = "izd_id", referencedColumnName = "izd_id")
    @ManyToOne
    private Izdavac izdId;

    public Video() {
    }

    public Video(Integer vidId) {
        this.vidId = vidId;
    }

    public Integer getVidId() {
        return vidId;
    }

    public void setVidId(Integer vidId) {
        this.vidId = vidId;
    }

    public String getVidIme() {
        return vidIme;
    }

    public void setVidIme(String vidIme) {
        this.vidIme = vidIme;
    }

    public Date getVidDatum() {
        return vidDatum;
    }

    public void setVidDatum(Date vidDatum) {
        this.vidDatum = vidDatum;
    }

    @XmlTransient
    public Set<Glumac> getGlumacSet() {
        return glumacSet;
    }

    public void setGlumacSet(Set<Glumac> glumacSet) {
        this.glumacSet = glumacSet;
    }

    @XmlTransient
    public Set<Zanr> getZanrSet() {
        return zanrSet;
    }

    public void setZanrSet(Set<Zanr> zanrSet) {
        this.zanrSet = zanrSet;
    }

    @XmlTransient
    public Set<Trailer> getTrailerSet() {
        return trailerSet;
    }

    public void setTrailerSet(Set<Trailer> trailerSet) {
        this.trailerSet = trailerSet;
    }

    @XmlTransient
    public Set<Slika> getSlikaSet() {
        return slikaSet;
    }

    public void setSlikaSet(Set<Slika> slikaSet) {
        this.slikaSet = slikaSet;
    }

    @XmlTransient
    public Set<Komentar> getKomentarSet() {
        return komentarSet;
    }

    public void setKomentarSet(Set<Komentar> komentarSet) {
        this.komentarSet = komentarSet;
    }

    public Izdavac getIzdId() {
        return izdId;
    }

    public void setIzdId(Izdavac izdId) {
        this.izdId = izdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vidId != null ? vidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Video)) {
            return false;
        }
        Video other = (Video) object;
        if ((this.vidId == null && other.vidId != null) || (this.vidId != null && !this.vidId.equals(other.vidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Video[ vidId=" + vidId + " ]";
    }
    
    public String getVidOpis() {
        return vidOpis;
    }

    public void setVidOpis(String vidOpis) {
        this.vidOpis = vidOpis;
    }
    
}
