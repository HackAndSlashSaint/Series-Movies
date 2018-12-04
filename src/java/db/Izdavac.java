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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kojot
 */
@Entity
@Table(name = "izdavac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Izdavac.findAll", query = "SELECT i FROM Izdavac i")})
public class Izdavac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "izd_id")
    private Integer izdId;
    @Size(max = 45)
    @Column(name = "izd_ime")
    private String izdIme;
    @Size(max = 45)
    @Column(name = "izd_drzava")
    private String izdDrzava;
    @OneToMany(mappedBy = "izdId")
    private Set<Video> videoSet;

    public Izdavac() {
    }

    public Izdavac(Integer izdId) {
        this.izdId = izdId;
    }

    public Integer getIzdId() {
        return izdId;
    }

    public void setIzdId(Integer izdId) {
        this.izdId = izdId;
    }

    public String getIzdIme() {
        return izdIme;
    }

    public void setIzdIme(String izdIme) {
        this.izdIme = izdIme;
    }

    public String getIzdDrzava() {
        return izdDrzava;
    }

    public void setIzdDrzava(String izdDrzava) {
        this.izdDrzava = izdDrzava;
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
        hash += (izdId != null ? izdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Izdavac)) {
            return false;
        }
        Izdavac other = (Izdavac) object;
        if ((this.izdId == null && other.izdId != null) || (this.izdId != null && !this.izdId.equals(other.izdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Izdavac[ izdId=" + izdId + " ]";
    }
    
}
