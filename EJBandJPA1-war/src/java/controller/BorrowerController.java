/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Book;
import entities.Borrower;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.BorrowerFacade;

/**
 *
 * @author FatinNabilla
 */
@Named(value = "borrowerController")
@ManagedBean
@SessionScoped
public class BorrowerController implements Serializable {
    
    @EJB
    private BorrowerFacade borrowerFacade;
    
    private Borrower borrower = new Borrower();

    
    /**
     * Creates a new instance of BorrowerController
     */
    public BorrowerController() {
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
    
    
    //read
    public List<Borrower> findAll(){
        return this.borrowerFacade.findAll();
    }
    
    //create
    public String insert(){
        this.borrowerFacade.create(borrower);
        this.borrower = new Borrower();
        return "borrowerViewBook";
    }
    
    //Delete
    public String delete(Borrower borrower){
        this.borrowerFacade.remove(borrower);
        return "ManageBorrower";
    }
    
    
    
}
