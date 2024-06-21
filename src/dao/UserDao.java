package dao;

import models.User;
import java.sql.*;

public class UserDao {

    public User getUserByPhoneNoOrId(String phoneNo, String userId){
        if(phoneNo==null && userId==null ) return null;

        User user = null;
        try(Connection con = DbConnection.getDbConnection()) {
            if(con==null) System.out.println(" NOT Connected to Db");

            String sql = "SELECT user_id, phone_no, name, email, balance, password FROM user where phone_no=?";

            if(phoneNo==null) {
                sql = "SELECT user_id, phone_no, name, email, balance, password FROM user where user_id=?";
            }

            PreparedStatement statement = con.prepareStatement(sql);

            if(phoneNo!=null) {
                statement.setString(1, phoneNo);
            }
            else {
                statement.setString(1, userId);
            }
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                user = new User(result.getString(1),
                        result.getString(2),
                        result.getString(6),
                        result.getString(3),
                        result.getString(4),
                        result.getDouble(5));
            }

            return user;
        } catch (SQLException ex) {
            System.out.println("SQL Exception in Fetching user Details");
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(String name, String email, String phoneNo) {
        try(Connection con = DbConnection.getDbConnection()) {
            if(con==null) System.out.println("NOT Connected to Db");

            String sql = "UPDATE user SET email=?, name=? WHERE phone_no=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, name);
            statement.setString(3, phoneNo);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Users details updated successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean updateUserBalance(String userId, Double balance) {
        try(Connection con = DbConnection.getDbConnection()) {
            if(con==null) System.out.println("NOT Connected to Db");

            String sql = "UPDATE user SET balance=? WHERE user_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, balance);
            statement.setString(2, userId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Successfully Updated User "  + userId + ", balance: " + balance);
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Failed to update the User " + userId + ", balance: " + balance);
        return false;
    }
}
