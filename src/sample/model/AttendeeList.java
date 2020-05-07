package sample.model;

public class AttendeeList {
    String lec_id;
    String course_id;
    String instructor_id;
    String title;
    String date_lec;
    Boolean attendee;

    public AttendeeList(String lec_id, String course_id, String instructor_id, String title, String date_lec, Boolean attendee) {
        this.lec_id = lec_id;
        this.course_id = course_id;
        this.instructor_id = instructor_id;
        this.title = title;
        this.date_lec = date_lec;
        this.attendee = attendee;
    }

    public String getLec_id() {
        return lec_id;
    }

    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_lec() {
        return date_lec;
    }

    public void setDate_lec(String date_lec) {
        this.date_lec = date_lec;
    }

    public Boolean getAttendee() {
        return attendee;
    }

    public void setAttendee(Boolean attendee) {
        this.attendee = attendee;
    }
}
