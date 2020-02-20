package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named("register")
@RequestScoped
public class RegisterBean implements Serializable {

    @Inject
    private ClientsJpaController clientController;
    
    private String firstName;
    private String lastName;
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }
}
