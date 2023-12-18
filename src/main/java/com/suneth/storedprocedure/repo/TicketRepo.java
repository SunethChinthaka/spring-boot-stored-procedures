package com.suneth.storedprocedure.repo;

import com.suneth.storedprocedure.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepo {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Ticket> getTicketsInfo() {
        return entityManager.createStoredProcedureQuery("getTickets").getResultList();
    }

//    @SuppressWarnings("unchecked")
//    public List<Ticket> getTicketsInfoByCategory(String category) {
//        return entityManager.createStoredProcedureQuery("getTicketsByCategory").setParameter("t_category", category).getResultList();
//    }

    @SuppressWarnings("unchecked")
    public List<Ticket> getTicketsInfoByCategory(String category) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("getTicketsByCategory");

        // Set the input parameter for the stored procedure
        storedProcedureQuery.registerStoredProcedureParameter("t_category", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("t_category", category);

        // Execute the stored procedure and return the result list
        return storedProcedureQuery.getResultList();
    }

}
