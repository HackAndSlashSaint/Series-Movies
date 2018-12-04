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
import javax.persistence.Lob;
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
@Table(name = "komentar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komentar.findAll", query = "SELECT k FROM Komentar k")})
public class Komentar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kom_id")
    private Integer komId;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "kom_tekst")
    private String komTekst;
    @Column(name = "kom_datum")
    @Temporal(TemporalType.DATE)
    private Date komDatum;
    @JoinColumn(name = "kor_id", referencedColumnName = "kor_id")
    @ManyToOne
    private Korisnik korId;
    @JoinColumn(name = "vid_id", referencedColumnName = "vid_id")
    @ManyToOne
    private Video vidId;

    public Komentar() {
    }

    public Komentar(Integer komId) {
        this.komId = komId;
    }

    public Integer getKomId() {
        return komId;
    }

    public void setKomId(Integer komId) {
        this.komId = komId;
    }

    public String getKomTekst() {
        return komTekst;
    }

    public void setKomTekst(String komTekst) {
        this.komTekst = komTekst;
    }

    public Date getKomDatum() {
        return komDatum;
    }

    public void setKomDatum(Date komDatum) {
        this.komDatum = komDatum;
    }

    public Korisnik getKorId() {
        return korId;
    }

    public void setKorId(Korisnik korId) {
        this.korId = korId;
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
        hash += (komId != null ? komId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komentar)) {
            return false;
        }
        Komentar other = (Komentar) object;
        if ((this.komId == null && other.komId != null) || (this.komId != null && !this.komId.equals(other.komId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Komentar[ komId=" + komId + " ]";
    }
    
}
