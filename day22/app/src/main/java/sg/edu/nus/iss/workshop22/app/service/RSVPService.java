package sg.edu.nus.iss.workshop22.app.service;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop22.app.repository.RSVPRepo;

public class RSVPService {
    @Service

    @Autowired
    private RSVPRepo rsvpRepo;

    public List<RSVP> getAllRSVP(String q) {
        return rsvpRepo.getAllRSVP(q);
    }

    public RSVP searchRSVPByName(String name) {
        return rsvpRepo.searchRSVPByName(name);
    }

    public RSVP insertPurchaseOrder(final RSVP rsvp) {
        return rsvpRepo.insertRSVP(rsvp);
    }

    public boolean updateRSVP(final RSVP rsvp) {
        return rsvpRepo.updateRSVP(rsvp);
    }

    public Integer getTotalRSVP() {
        return rsvpRepo.getTotalRSVP();
    }
}

