package com.techelevator.controller;

import com.techelevator.dao.AgendaDao;
import com.techelevator.model.Agenda;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class AgendaController {

    private AgendaDao agendaDao;

    public AgendaController(AgendaDao agendaDao) {
        this.agendaDao = agendaDao;
    }

    @GetMapping("doctors/agenda/{id}")
    public Agenda getAgendaByDoctor(@PathVariable long id) {
        return agendaDao.getAgendaByDoctorId(id);
    }

    @GetMapping("/agenda/{day}")
    public List<Agenda> getAgendasByAvailability(@PathVariable String day) {
        return agendaDao.getAgendasByAvailabilityDay(day);
    }

    @GetMapping("doctors/offDays/{id}")
    public List<Integer> getOffDays(@PathVariable long id) {
        return agendaDao.getUnavailableDays(id);
    }

    @PostMapping("/doctors/{id}/agenda")
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda postAgenda(@PathVariable long id, @RequestBody Agenda newAgenda){
        return agendaDao.createAgenda(newAgenda);
    }

    @PutMapping("/doctors/{id}/agenda/{agendaId}")
    public Agenda putAgenda(@PathVariable("id") long id, @PathVariable("agendaId") Long agendaId, @RequestBody Agenda updatedAgenda) {
        updatedAgenda.setAgendaId(agendaId);
        if (agendaDao.updateAgenda(updatedAgenda)) {
            return updatedAgenda;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Something went wrong! Please try again.");
        }
    }

    @DeleteMapping("/doctors/{id}/agenda/{agendaId}")
    public void deleteAgenda(@PathVariable("id") long id, @PathVariable("agendaId") Long agendaId) {
        if (!agendaDao.deleteAgenda(agendaId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This agenda does not exist.");
        }
    }

}
