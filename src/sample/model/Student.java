package sample.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    String id;
    List<Object> phone_number;
    String first_name;
    String last_name;
    String att;

    public Student(String id, List<Object> phone_number, String first_name, String last_name, String att) {
        this.id = id;
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.att = att;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(List<Object> phone_number) {
        this.phone_number = phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }
}
