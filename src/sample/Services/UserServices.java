package sample.Services;

import sample.Model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserServices {
    public void addUser(User user) throws Exception {
        try{
            //Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Create a Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hackathon?user=root&password=&serverTimezone=UTC");
            //Create Statement
            String sqlQuery = "INSERT INTO user (name, username, password, businessName) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4,user.getBusinessName());
            //Execute Statement
            ps.execute();
            //Close the Connection
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    // Read Method
    // - list method
    public ArrayList<User> listUser() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Create a Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hackathon?user=root&password=&serverTimezone=UTC");
        //Create Statement
        String sqlQuery = "SELECT id, name, username, businessName FROM user ORDER BY id ASC";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        //Execute Statement
        ps.execute();
        ArrayList<User> userList = new ArrayList<>();
        ResultSet rs = ps.getResultSet();
        while(rs.next()) {
            User user = new User(rs);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String username = rs.getString("username");
            String businessName = rs.getString("businessName");
            user.setId(id);
            user.setName(name);
            user.setUsername(username);
            user.setBusinessName(businessName);
            userList.add(user);
        }
        System.out.println(userList.get(1).getName());
        //Close the Connection
        con.close();
        return userList;
    }
    // get by id
    public User getUserbyId(int id) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        //Create a Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hackathon?user=root&password=&serverTimezone=UTC");
        //Create Statement
        String sqlQuery = "SELECT * FROM user WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        //Execute Statement
        ps.execute();
        ResultSet rs = ps.getResultSet();
        rs.next();
        User user = new User(rs);
        con.close();
        return user;
    }
    // Update Method
    public void updateUser(User user) throws Exception {
        try{
            UserServices us = new UserServices();
            User originalUser = us.getUserbyId(user.getId());

            Class.forName("com.mysql.cj.jdbc.Driver");
            //Create a Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hackathon?user=root&password=&serverTimezone=UTC");
            //Create Statement
            String sqlQuery = "UPDATE user SET name = ?, username = ?, password = ?, businessName = ? WHERE id = ?";
            String name = user.getName();
            String password = user.getPassword();
            String username = user.getUsername();
            String businessName = user.getBusinessName();
            if(name != null ){
                originalUser.setName(user.getName());
            }
            if(password != null ){
                originalUser.setPassword(user.getPassword());
            }
            if(username != null ){
                originalUser.setUsername(user.getUsername());
            }
            if(businessName != null){
                originalUser.setBusinessName(user.getBusinessName());
            }

            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, originalUser.getName());
            ps.setString(2, originalUser.getUsername());
            ps.setString(3,originalUser.getPassword());
            ps.setInt(4, originalUser.getId());
            ps.setString(5, originalUser.getBusinessName());
            ps.execute();
            con.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
    // Delete Method
//    public void deleteUserbyId(User user) throws SQLException, ClassNotFoundException {
//        deleteUserbyId(user.getId());
//    }
    public void deleteUserbyId(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Create a Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hackathon?user=root&password=&serverTimezone=UTC");
        //Create Statement
        String sqlQuery = "DELETE FROM user WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        ps.execute();
        con.close();

    }

}
