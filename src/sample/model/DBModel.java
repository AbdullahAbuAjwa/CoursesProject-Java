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

    public String getPhoneInstructor(String id) {
        String sql = "select phone_number from instructor natural join phone_instructor where id = ?;";
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

    public String getCoursesInstructorTeaches(String id) {
        String sql = "select course_id from instructor natural join teaches where id = ?;";
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

    public String getPhoneStd(String id) {
        String sql = "select phone_number from student s natural join phone_student where id = ?;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //  System.out.println(rs.getInt(1));
                return String.valueOf(rs.getInt(1));

            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

    }

    public String getCoursesTakeStd(String id) {
        String sql = "select course_id from student s natural join takes where id = ?;";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //  System.out.println(rs.getString(1));
                return rs.getString(1);
            }
            return null;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
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
