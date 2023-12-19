package com.suneth.storedprocedure.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@NamedStoredProcedureQuery(name = "firstSP", procedureName = "getTickets")
@NamedStoredProcedureQuery(name = "secondSP", procedureName = "getTicketsByCategory", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "t_category", type = String.class)
})
public class Ticket {
    @Id
    private int id;
    private int amount;
    private String category;
}
