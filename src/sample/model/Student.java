package sample.model;

public class Student {
    String ID;
    String firstName;
    String fatherName;
    String grandFatherName;
    String lastName;
    String city;
    String district;
    String street;
    String gender;

    public Student(String ID, String firstName, String secondName, String grandFatherName,
                   String lastName, String city, String district, String street, String gender) {
        this.ID = ID;
        this.firstName = firstName;
        this.fatherName = secondName;
        this.grandFatherName = grandFatherName;
        this.lastName = lastName;
        this.city = city;
        this.district = district;
        this.street = street;
        this.gender = gender;
      //  this.phone = phone;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
