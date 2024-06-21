# paymentSystem
A command-line payment application similar to paytm 

Below Requirement was shared by Scaler Team in a master Class:

I have implemented it. This Java code can act as reference for Java beginners. 

**How to run the payment System**
First Install java jdk (if not already present ) and mysql on your computer.

MySQL Changes

After installing mysql Open it
Enter the command given below in Mysql
Run script.sql

Download MySQL Connector/J for MySQL

To run Find the path of mysql-connector-j jar path which is inside the above downloaded 
javac -classpath {path}/mysql-connector-j-8.*.*.jar:. Main.java  
java -classpath {path}/mysql-connector-j-8.*.*.jar:. Main


**Requirements**: Create design (class diagram and schema design) and write working code 
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


