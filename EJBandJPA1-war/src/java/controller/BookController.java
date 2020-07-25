/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Book;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.BookFacade;

/**
 *
 * @author FatinNabilla
 */
@Named (value = "bookController")
@ManagedBean
@SessionScoped
public class BookController implements Serializable {
    
    @EJB
    private BookFacade bookFacade;
    
    private Book book = new Book();
    /**
     * Creates a new instance of BookController
     */
    public BookController() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    //read
    public List<Book> findAll(){
        return this.bookFacade.findAll();
    }
    
    //create
    public String insert(){
        this.bookFacade.create(book);
        this.book = new Book();
        return "index4";
    }
    
    //Delete
    public String delete(Book book){
        this.bookFacade.remove(book);
        return "index4";
    }
    
    //Update 
    public String update(Book book){
        this.book=book;
        return "update";
    }
    
    public String update(){
        this.bookFacade.edit(book);
        return "index4";
    }
    
    
    
}
