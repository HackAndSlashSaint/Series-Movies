/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kojot
 */
@Entity
@Table(name = "trailer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trailer.findAll", query = "SELECT t FROM Trailer t")})
public class Trailer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tra_id")
    private Integer traId;
    @Size(max = 45)
    @Column(name = "tra_ime")
    private String traIme;
    @Column(name = "tra_datum")
    @Temporal(TemporalType.DATE)
    private Date traDatum;
    @JoinColumn(name = "vid_id", referencedColumnName = "vid_id")
    @ManyToOne
    private Video vidId;

    public Trailer() {
    }

    public Trailer(Integer traId) {
        this.traId = traId;
    }

    public Integer getTraId() {
        return traId;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    public String getTraIme() {
        return traIme;
    }

    public void setTraIme(String traIme) {
        this.traIme = traIme;
    }

    public Date getTraDatum() {
        return traDatum;
    }

    public void setTraDatum(Date traDatum) {
        this.traDatum = traDatum;
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
        hash += (traId != null ? traId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trailer)) {
            return false;
        }
        Trailer other = (Trailer) object;
        if ((this.traId == null && other.traId != null) || (this.traId != null && !this.traId.equals(other.traId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Trailer[ traId=" + traId + " ]";
    }
    
}
