package services;

import com.sun.net.httpserver.Authenticator;
import dao.TransactionDao;
import dao.UserDao;
import exception.InsufficientBalanceException;
import exception.UserNotFoundException;
import models.User;
import java.sql.*;

import static utility.ConfigConstants.CREDIT_THRESHOLD;
import static utility.DbConstants.*;

public class UserManagementService {

    UserDao userDao;

    public UserManagementService(UserDao userDao) {
        this.userDao = userDao;
    }


    public boolean registerUser(String phoneNo, String password) {

        User user = new User(phoneNo, password);

        user.displayDetails();

        try(Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            if(con==null) System.out.println("NOT Connected to Db");

            String sql = "INSERT INTO user (user_id, phone_no, password, balance) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getUserId());
            statement.setString(2, user.getPhoneNo());
            statement.setString(3, user.getPassword());
            statement.setDouble(4, user.getBalance());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("The user registered successfully!");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("User  Registration Failed!");
        return false;
    }

    public void updateUser(String name, String email, String phoneNo) {
       userDao.updateUser(name, email, phoneNo);
    }

    public User getUserByPhoneNoOrId(String phoneNo, String userId){
        User user = userDao.getUserByPhoneNoOrId(phoneNo, userId);
        if(user!=null) {
            user.displayDetails();
        }
        return user;
    }

    public boolean withDrawMoney(String userId, double amount) throws UserNotFoundException,
            InsufficientBalanceException {
        User user = userDao.getUserByPhoneNoOrId(null, userId);
        if(user==null) throw new UserNotFoundException();

        if(user.getBalance() + CREDIT_THRESHOLD-amount <0 ) throw new InsufficientBalanceException();

        return  userDao.updateUserBalance(userId,user.getBalance()-amount);
    }

    public boolean depositMoney(String userId, double amount) throws UserNotFoundException {
        User user = userDao.getUserByPhoneNoOrId(null, userId);
        if(user==null) throw new UserNotFoundException();

        return  userDao.updateUserBalance(userId,user.getBalance()+amount);
    }




}
