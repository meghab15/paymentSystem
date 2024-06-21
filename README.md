# paymentSystem
A command-line payment application similar to paytm 

**How to run the payment System**

First Install java jdk (if not already present) and mysql on your computer.

After installing mysql Open it
Enter the command given below in Mysql
Run script.sql

Download MySQL Connector/J for MySQL

To run, find the path of mysql-connector-j jar path which is downloaded above.  
javac -classpath {jar path}:. Main.java  
java -classpath {jar path}:. Main

e.g:  javac -classpath ~/Downloads/mysql-connector-j-8.4.0/mysql-connector-j-8.4.0.jar:. Main.java 
java -classpath ~/Downloads/mysql-connector-j-8.4.0/mysql-connector-j-8.4.0.jar:. Main

**Requirements**:

Below Requirement was shared by Scaler Team in a master Class:
This Java code can act as reference for Java beginners.  

Create design (class diagram and schema design) and write working code 
for a command-line payment application that supports the following use cases.

Allow users to create accounts via their phone number and password.

RegisterUser [phone_number] [password]


Allow users to update their profile details.

UpdateUser [user_id] [name] [email] [phone_number]


Send money to another user of the application. (Send money to another phone number)

CreateTransaction PAYTM [from_user_id] [to_user_id] [amount]


Send money to a bank account.

CreateTransaction BANK [from_user_id] [account_number] [ifsc_code] [amount] 


Allow users to make payment for the transaction via Card/ UPI/ Netbanking

MakePayment [transaction_id] [payment_method] [... details related to payment method ...]


Allow users to refund a transaction. The refund amount will go to the original source.

RefundTransaction [transaction_id]


Allow users to view transaction history.

ViewTransactionsHistory [user_id]


