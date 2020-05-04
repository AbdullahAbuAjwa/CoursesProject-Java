package sample.model;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.*;
import java.util.ArrayList;

public class DBModel {
    //here our queries method
    public DBModel() {
        schemaConnect("public");
    }

    private static DBModel dbmodel = null;
    Connection con = null;

    public static DBModel getModel() {
        if (dbmodel == null) {
            dbmodel = new DBModel();
        }
        return dbmodel;
    }

    public void connect() {

        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setServerName("localhost");
        source.setDatabaseName("project");
        source.setUser("postgres");
        source.setPassword("123456");

        try {
            con = source.getConnection();
            System.out.println("Connected to database");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void schemaConnect(String schema) {
        String sql = "set search_path to '" + schema + "'";
        Statement s1 = null;
        try {
            connect();
            s1 = con.createStatement();
            s1.execute(sql);
            System.out.println("Connected to schema " + schema);
        } catch (SQLException ex) {
        } finally {
            try {
                s1.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    //
    public ArrayList<Student> showStudentInfo() {
        ArrayList<Student> students = new ArrayList<>();

        String sql = "select * from student;";
        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)
                        //resultSet.getInt(10)
                ));
                System.out.println("");

            }
            return students;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public String getInstructorName(String id) {
        String sql = "select name from instructor where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Object> getPhoneInstructor(String id) {
        String sql = "select phone_number from instructor natural join phone_instructor where id = ?;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            ArrayList<Object> list = new ArrayList<>();
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getCoursesInstructorTeaches(String id) {
        String sql = "select course_id from instructor natural join teaches where id = ?;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            ArrayList<String> list = new ArrayList<>();
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getFirstStdName(String id) {
        String sql = "select first_name from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getFatherStdName(String id) {
        String sql = "select father_name from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getGrandFatherStdName(String id) {
        String sql = "select grand_father_name from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getLastStdName(String id) {
        String sql = "select last_name from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getCityStd(String id) {
        String sql = "select city from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getDistrictStd(String id) {
        String sql = "select district from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getStreetStd(String id) {
        String sql = "select street from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getGenderStd(String id) {
        String sql = "select gender from student where id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Object> getPhoneStd(String id) {
        String sql = "select phone_number from student s natural join phone_student where id = ?;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            ArrayList<Object> list = new ArrayList<>();
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(String.valueOf(rs.getInt(1)));
            }
            return list;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<String> getCoursesTakeStd(String id) {
        String sql = "select course_id from student s natural join takes where id = ?;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            ArrayList<String> list = new ArrayList<>();

            while (rs.next()) {
                //  System.out.println(rs.getString(1));
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getNameCourse(String id) {
        String sql = "select name from course where course_id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public String getBookCourse(String id) {
        String sql = "select book from course where course_id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public String getInstNameOfCourse(String id) {
        String sql = "select name from instructor natural join teaches where course_id = ?;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public String getPlaceCourse(String id) {
        String sql = "select place from course where course_id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }


    public String CountOfStudentTakeCourse(String id) {
        String sql = "select count(*) from student natural join takes where course_id = ? ;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getCourseIDs() {
        String sql = "select course_id from course;";
        ArrayList<String> ids = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                ids.add(rs.getString(1));
                //  System.out.println(rs.getString(1));
            }
            return ids;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getStdId() {
        String sql = "select id from student;";
        ArrayList<String> ids = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                ids.add(rs.getString(1));
            }
            return ids;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getInstructorsIDs() {
        String sql = "select id from instructor;";
        ArrayList<String> ids = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                ids.add(rs.getString(1));
            }
            return ids;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public Boolean insertCourse(String course_id, String name, String book, String place) {
        String query = "insert into course(course_id , name , book , place) values (?,?,?,?);";

        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, course_id);
            st.setString(2, name);
            st.setString(3, book);
            st.setString(4, place);

            return st.executeUpdate() > 0;

        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    public Boolean insertStudent(String id, String first_name, String father_name, String gfather_name, String last_name,
                                 String city, String district, String street, String gender) {
        String query = "insert into student(id , first_name , father_name , grand_father_name , last_name , " +
                "city , district , street , gender) values (?,?,?,?,?,?,?,?,?);";

        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, id);
            st.setString(2, first_name);
            st.setString(3, father_name);
            st.setString(4, gfather_name);
            st.setString(5, last_name);
            st.setString(6, city);
            st.setString(7, district);
            st.setString(8, street);
            st.setString(9, gender);

            return st.executeUpdate() > 0;

        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    public Boolean insertPhoneStudent(String id, int phone) {
        String query = "insert into phone_student(id , phone_number) values (?,?);";

        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, id);
            st.setInt(2, phone);
            return st.executeUpdate() > 0;

        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    private void closeEverything() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void exit() {
        closeEverything();
        System.out.println("Exiting");
        //System.exit(0);
    }
}
