package com.suneth.storedprocedure.controller;

import com.suneth.storedprocedure.model.Ticket;
import com.suneth.storedprocedure.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TicketController {
    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping("/tickets")
    public List<Ticket> findTickets() {
        return ticketRepo.getTicketsInfo();
    }

    @GetMapping("/tickets/{category}")
    public List<Ticket> findTicketsByCategory(@PathVariable String category) {
        return ticketRepo.getTicketsInfoByCategory(category);
    }
}
