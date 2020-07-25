/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Blob;

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
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByIdbook", query = "SELECT b FROM Book b WHERE b.idbook = :idbook"),
    @NamedQuery(name = "Book.findByName", query = "SELECT b FROM Book b WHERE b.name = :name"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
    @NamedQuery(name = "Book.findByYears", query = "SELECT b FROM Book b WHERE b.years = :years")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBOOK")
    private Integer idbook;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "YEARS")
    private Integer years;
    
    

    public Book() {
    }

    public Book(Integer idbook) {
        this.idbook = idbook;
    }

    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
    
    /*ADDED
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }*/
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbook != null ? idbook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.idbook == null && other.idbook != null) || (this.idbook != null && !this.idbook.equals(other.idbook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Book[ idbook=" + idbook + " ]";
    }
    
}
