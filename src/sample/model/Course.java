package sample.model;

import java.sql.Date;

public class Course {
    String lec_id;
    String title;
    String date;

    public Course(String lec_id, String title, String date) {
        this.lec_id = lec_id;
        this.title = title;
        this.date = date;
    }

    public String getLec_id() {
        return lec_id;
    }

    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
