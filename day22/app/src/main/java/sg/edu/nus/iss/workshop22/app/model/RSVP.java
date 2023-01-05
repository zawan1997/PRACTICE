package sg.edu.nus.iss.workshop22.app.model;

import java.io.ByteArrayInputStream;
import java.time.Instant;

import org.joda.time.DateTime;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class RSVP {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private DateTime confirmationDate;
    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DateTime getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(DateTime confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    //serialisation to the format we want
    public static RSVP create(JsonObject readObject) throws Exception {
        final RSVP r = new RSVP();
        r.setName(readObject.getString("name"));
        r.setEmail(readObject.getString("email"));
        r.setPhone(readObject.getString("phone"));
        r.setConfirmationDate(new DateTime(Instant.parse(readObject.getString("confirmation_date"))));
        r.setComments(readObject.getString("comments"));
        return r;
    }

    //Reading it as a String
    public static RSVP create(String jsonStr) throws Exception {
        JsonReader reader = Json.createReader(new ByteArrayInputStream(jsonStr.getBytes(jsonStr)));
        return create(reader.readObject());
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("id", getId())
                .add("name", getName())
                .add("email", getEmail())
                .add("phone", getPhone())
                .add("confirmation_date", getConfirmationDate() != null ? getConfirmationDate().toString() : "")
                .add("commments", getComments())
                .build();
    }

}
