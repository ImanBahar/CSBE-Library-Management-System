/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FatinNabilla
 */
@Entity
@Table(name = "BORROWER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrower.findAll", query = "SELECT b FROM Borrower b"),
    @NamedQuery(name = "Borrower.findByMatricnumber", query = "SELECT b FROM Borrower b WHERE b.matricnumber = :matricnumber"),
    @NamedQuery(name = "Borrower.findByBorrowername", query = "SELECT b FROM Borrower b WHERE b.borrowername = :borrowername"),
    @NamedQuery(name = "Borrower.findByBooktitle", query = "SELECT b FROM Borrower b WHERE b.booktitle = :booktitle")})
public class Borrower implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MATRICNUMBER")
    private Integer matricnumber;
    @Size(max = 50)
    @Column(name = "BORROWERNAME")
    private String borrowername;
    @Size(max = 50)
    @Column(name = "BOOKTITLE")
    private String booktitle;

    public Borrower() {
    }

    public Borrower(Integer matricnumber) {
        this.matricnumber = matricnumber;
    }

    public Integer getMatricnumber() {
        return matricnumber;
    }

    public void setMatricnumber(Integer matricnumber) {
        this.matricnumber = matricnumber;
    }

    public String getBorrowername() {
        return borrowername;
    }

    public void setBorrowername(String borrowername) {
        this.borrowername = borrowername;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricnumber != null ? matricnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrower)) {
            return false;
        }
        Borrower other = (Borrower) object;
        if ((this.matricnumber == null && other.matricnumber != null) || (this.matricnumber != null && !this.matricnumber.equals(other.matricnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Borrower[ matricnumber=" + matricnumber + " ]";
    }
    
}
