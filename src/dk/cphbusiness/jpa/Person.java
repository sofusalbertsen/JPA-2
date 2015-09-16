/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author sofus
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Address> aList = new ArrayList<>();

    public void setAddress(Address a) {
        aList.add(a);
    }

    public List<Address> getaList() {
        return aList;
    }

    public void setaList(List<Address> aList) {
        this.aList = aList;
    }

    public Person() {
    }
    private String fornavn;

    private String efternavn;

    public Person(String fornavn, String efternavn) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

}
