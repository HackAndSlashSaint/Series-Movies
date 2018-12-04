/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kojot
 */
@Entity
@Table(name = "slika")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slika.findAll", query = "SELECT s FROM Slika s")})
public class Slika implements Serializable {

    @Size(max = 45)
    @Column(name = "sli_ime")
    private String sliIme;
    @Lob
    @Column(name = "sli_slika")
    private byte[] sliSlika;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sli_id")
    private Integer sliId;
    @JoinColumn(name = "glu_id", referencedColumnName = "glu_id")
    @ManyToOne
    private Glumac gluId;
    @JoinColumn(name = "vid_id", referencedColumnName = "vid_id")
    @ManyToOne
    private Video vidId;

    public Slika() {
    }

    public Slika(Integer sliId) {
        this.sliId = sliId;
    }

    public Integer getSliId() {
        return sliId;
    }

    public void setSliId(Integer sliId) {
        this.sliId = sliId;
    }

    public byte[] getSliSlika() {
        return sliSlika;
    }

    public void setSliSlika(byte[] sliSlika) {
        this.sliSlika = sliSlika;
    }

    public Glumac getGluId() {
        return gluId;
    }

    public void setGluId(Glumac gluId) {
        this.gluId = gluId;
    }

    public Video getVidId() {
        return vidId;
    }

    public void setVidId(Video vidId) {
        this.vidId = vidId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sliId != null ? sliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Slika)) {
            return false;
        }
        Slika other = (Slika) object;
        if ((this.sliId == null && other.sliId != null) || (this.sliId != null && !this.sliId.equals(other.sliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Slika[ sliId=" + sliId + " ]";
    } 

    public String getSliIme() {
        return sliIme;
    }

    public void setSliIme(String sliIme) {
        this.sliIme = sliIme;
    }
}

   