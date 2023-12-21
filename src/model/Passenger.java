/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author la paix
 */

public class Passenger implements Serializable{

    private Long passengerId;


    private String email;

    private String fNames;
    private String lnames;

   
    private String phone;

    private String address;
    private String password;
    private String gender;
    private LocalDate dob;
    

    
    private String nId;

    // Other fields specific to the Passenger entity

    
    private List<Booking> bookings;

    public Passenger() {
    }

    public Passenger(Long passengerId, String email, String fNames, String lnames, String phone, String address, String password, String nId, String gender, LocalDate dob, List<Booking> bookings) {
        this.passengerId = passengerId;
        this.email = email;
        this.fNames = fNames;
        this.lnames = lnames;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.nId = nId;
        this.gender = gender;
        this.dob = dob;
        this.bookings = bookings;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

  

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfNames() {
        return fNames;
    }

    public void setfNames(String fNames) {
        this.fNames = fNames;
    }

    public String getLnames() {
        return lnames;
    }

    public void setLnames(String lnames) {
        this.lnames = lnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
}
