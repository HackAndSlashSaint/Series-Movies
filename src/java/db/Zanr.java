/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kojot
 */
@Entity
@Table(name = "zanr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zanr.findAll", query = "SELECT z FROM Zanr z")})
public class Zanr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zan_id")
    private Integer zanId;
    @Size(max = 45)
    @Column(name = "zan_ime")
    private String zanIme;
    @ManyToMany(mappedBy = "zanrSet")
    private Set<Video> videoSet;

    public Zanr() {
    }

    public Zanr(Integer zanId) {
        this.zanId = zanId;
    }

    public Integer getZanId() {
        return zanId;
    }

    public void setZanId(Integer zanId) {
        this.zanId = zanId;
    }

    public String getZanIme() {
        return zanIme;
    }

    public void setZanIme(String zanIme) {
        this.zanIme = zanIme;
    }

    @XmlTransient
    public Set<Video> getVideoSet() {
        return videoSet;
    }

    public void setVideoSet(Set<Video> videoSet) {
        this.videoSet = videoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zanId != null ? zanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zanr)) {
            return false;
        }
        Zanr other = (Zanr) object;
        if ((this.zanId == null && other.zanId != null) || (this.zanId != null && !this.zanId.equals(other.zanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Zanr[ zanId=" + zanId + " ]";
    }
    
}
