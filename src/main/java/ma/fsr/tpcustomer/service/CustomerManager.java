/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fsr.tpcustomer.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import ma.fsr.tpcustomer.entity.Customer;

/**
 *
 * Gère la persistance des Customers.
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

//va exécuter une requête JPQL de nom "ustomer.findAll" définie dans l'entité
    //Customer
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    //donne à gérer à l'entity manager le customer passé en paramètre 

    /**
     *
     * @param customer
     * @return
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
    //persist génère un INSERT SQL dans la base de données.

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

}
