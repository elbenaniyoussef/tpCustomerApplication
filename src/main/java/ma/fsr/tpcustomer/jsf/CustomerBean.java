/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.fsr.tpcustomer.jsf;

import ma.fsr.tpcustomer.entity.Customer;
import jakarta.inject.Inject;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import ma.fsr.tpcustomer.service.CustomerManager;

/**
 *
 * @author elben Backing bean pour la page JSF customerList
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customerList;

    @Inject
    private CustomerManager customerManager;

    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
     */
    public List <Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

}
