package com.bookonline.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String password;
    private boolean isAdmin;

    public User(){
        
    }
    
    public User(String name, String email, String address, String password, boolean isAdmin){
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean getIsAdmin(){
        return isAdmin;
    }
    
    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", password=" + password + ", isAdmin=" + isAdmin + "]";
    }
    
}
