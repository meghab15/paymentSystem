package dao;

import models.Transaction;
import models.TransactionFailureReason;
import models.TransactionStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDao {

    public void createTransaction(Transaction transaction) {
        try(Connection con = DbConnection.getDbConnection()) {

            String sql = "INSERT INTO transaction (transaction_id, from_user, to_user, type, account_id, status, amount) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, transaction.getTransactionId());
            statement.setString(2, transaction.getFromUser()!=null?  transaction.getFromUser().getUserId(): null);
            statement.setString(3, transaction.getFromUser()!=null?  transaction.getFromUser().getUserId(): null);
            statement.setString(4, transaction.getType().name());
            statement.setString(5, transaction.getBankAccount()!=null? transaction.getBankAccount().getId(): null);
            statement.setString(6, transaction.getStatus().name());
            statement.setDouble(7, transaction.getAmount());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Transaction successfully created!");
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Failed to create Transaction!");
    }

    public boolean updateTransactionStatus(String transactionId, TransactionStatus status,
                                           TransactionFailureReason failureReason) {
        try(Connection con = DbConnection.getDbConnection()) {
            if(con==null) System.out.println("NOT Connected to Db");

            String sql = "UPDATE transaction SET status=?, failure_reason=? WHERE transaction_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, status.name());
            statement.setString(2, failureReason!=null? failureReason.name(): null);
            statement.setString(3,  transactionId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Successfully Updated Transaction Status");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Failed to update the  transaction status!");
        return false;
    }
}
