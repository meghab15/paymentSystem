CREATE TABLE `payment` (
  `payment_id` varchar(255) NOT NULL,
  `from_user` varchar(255) DEFAULT NULL,
  `to_user` varchar(255) DEFAULT NULL,
  `mode` varchar(127) NOT NULL,
  `from_account_id` varchar(255) DEFAULT NULL,
  `to_account_id` varchar(255) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
);


CREATE TABLE `transaction` (
  `transaction_id` varchar(255) NOT NULL,
  `from_user` varchar(255) DEFAULT NULL,
  `to_user` varchar(255) DEFAULT NULL,
  `type` varchar(127) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `status` varchar(127) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `failure_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ;


CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `phone_no` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone_no` (`phone_no`)
);