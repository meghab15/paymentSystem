package dao;

import models.Paytm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDao {
    public void storePaytmInfo(Paytm payment) {
        try(Connection con = DbConnection.getDbConnection()) {

            String sql = "INSERT INTO payment (payment_id, from_user, to_user, mode, amount, transaction_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, payment.getId());
            statement.setString(2, payment.getFromUserId()!=null?
                    payment.getFromUserId(): null);
            statement.setString(3, payment.getToUserId()!=null?
                    payment.getToUserId(): null);
            statement.setString(4, payment.getMode().name());
            statement.setDouble(5, payment.getAmount());
            statement.setString(6, payment.getTransaction().getTransactionId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Paytm PaymentInfo successfully created!");
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Failed to create Paytm PaymentInfo!");
    }
}
