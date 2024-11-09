CREATE TABLE CASHIER (
  Cashier_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Fname VARCHAR(100),
  Lname VARCHAR(100),
  Cphone_Num VARCHAR(15),
  Cashier_Salary INT
);

CREATE TABLE FOOD_PREPARER (
  Preparer_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Fname VARCHAR(100),
  Lname VARCHAR(100),
  Fphone_Num VARCHAR(10), 
  Preparer_Salary INT
);

CREATE TABLE INVOICE (
  Invoice_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Inv_Time TIME,
  Inv_Date DATE,
  Total_Price INT,
  Completion BOOLEAN,
  Order_Type VARCHAR(100),
  Payment_Type VARCHAR(100),
  C_ID INT NOT NULL, 
  FP_ID INT NOT NULL,
  FOREIGN KEY (C_ID) REFERENCES CASHIER(Cashier_ID), 
  FOREIGN KEY (FP_ID) REFERENCES FOOD_PREPARER(Preparer_ID)
);

CREATE TABLE ITEM(
  Item_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Item_Name VARCHAR(100),
  Item_Price INT,
  Category VARCHAR(15)
);

CREATE TABLE CONSIST_OF(
  Inv_ID INT NOT NULL ,
  I_ID INT NOT NULL,
  Quantity INT,
  FOREIGN KEY (Inv_ID) REFERENCES INVOICE(Invoice_ID),
  FOREIGN KEY (I_ID) REFERENCES ITEM(Item_ID)
);

INSERT INTO CASHIER (Fname, Lname, Cphone_Num, Cashier_Salary)
VALUES ('Sara', 'Alhamad', '555-1234', 3000),
       ('Nora', 'Alsaleh', '555-5678', 3500);
INSERT INTO FOOD_PREPARER ( Fname, Lname, Fphone_Num, Preparer_Salary)
VALUES ('Lama', 'Mohammed', '5551111', 2500),
       ('Sara', 'Altamimi', '5552222', 2600),
       ( 'Hessa', 'Alahmed', '5553333', 2700);
INSERT INTO INVOICE (Inv_Time,Inv_Date ,Total_Price ,Completion ,Order_Type ,Payment_Type ,C_ID , FP_ID )
VALUES ( '12:30:00', '2024-10-10', 100, TRUE, 'Dine-In', 'Card', 1, 1),
       ('13:45:00', '2024-10-10', 200, FALSE, 'Takeout', 'Cash', 2, 2),
       ( '14:15:00', '2024-10-11', 150, TRUE, 'Takeout', 'Card', 1, 3);
       
INSERT INTO ITEM ( Item_Name, Item_Price,Category)
VALUES ( 'Iced coffee', 12,'Cold Drinks'),
       ( 'Spanish latte', 14,'Hot Drinks'),
       ( 'water', 1,'Cold Drinks'),
       ( 'Drip coffee', 12,'Hot Drinks'),
       ( 'Americano', 12,'Hot Drinks'),
       ( 'Espresso', 11,'Hot Drinks'),
       ( 'Cartado', 14,'Hot Drinks'),
       ( 'Ice Americano', 14,'Cold Drinks'),
       ( 'Cold brew', 20,'Cold Drinks'),
       ( 'Ice Latte', 17,'Cold Drinks'),
       ( 'Cookie', 8,'Sweets'),
       ( 'lemon Cake', 8,'Sweets'),
       ( 'Marble Cake', 8,'Sweets');
       
INSERT INTO Consist_Of (Inv_ID, I_ID, Quantity)
VALUES (1, 1, 2),  
       (1, 4, 1),  
       (2, 2, 1), 
       (3, 3, 3),  
       (3, 4, 2);  