package sg.edu.nus.iss.workshop22.app.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop22.app.model.RSVP;
import sg.edu.nus.iss.workshop22.app.repository.RSVPQuerries;

@Repository
public class RSVPRepo {
    
@Autowired 
private JdbcTemplate template;

public List<RSVP> getAllRSVP(String q){
    final List<RSVP> LIST = new LinkedList<>();
    SqlRowSet result = null;
    if(q == null) {
        template.queryForRowSet(SELECT_ALL_RSVP);
    }  else {
        result = template.queryForRowSet(SELECT_ALL_RSVP_BY_NAME,q);
    }
    while (result.next()) {
        
    }
    return;
}
}
