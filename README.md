## 🏦 Banking Account Management System (Oracle 11g)

## 📌 Project Overview

This project is a simple **Banking Database Management System** developed using **Oracle 11g SQL**.
It manages customer accounts and fund transfers between accounts.

The system includes:

* Account creation
* Balance management
* Fund transfers
* Primary & Foreign key constraints

---

## 🗂️ Database Tables

### 1️⃣ ACCOUNT_TBL

Stores customer account details.

| Column Name    | Data Type    | Description         |
| -------------- | ------------ | ------------------- |
| Account_Number | VARCHAR2(10) | Primary Key         |
| Balance        | NUMBER       | Account Balance     |
| Customer_Name  | VARCHAR2(50) | Account Holder Name |

### SQL Code

```sql
CREATE TABLE ACCOUNT_TBL (
    Account_Number VARCHAR2(10) PRIMARY KEY,
    Balance NUMBER,
    Customer_Name VARCHAR2(50)
);
```

---

### 2️⃣ TRANSFER_TBL

Stores transfer transaction details.

| Column Name                | Data Type    | Description      |
| -------------------------- | ------------ | ---------------- |
| Transaction_ID             | NUMBER(4)    | Primary Key      |
| Account_Number             | VARCHAR2(10) | Sender Account   |
| Beneficiary_account_number | VARCHAR2(10) | Receiver Account |

### SQL Code

```sql
CREATE TABLE TRANSFER_TBL (
    Transaction_ID NUMBER(4) PRIMARY KEY,
    Account_Number VARCHAR2(10),
    Beneficiary_account_number VARCHAR2(10),
    CONSTRAINT fk_acc
        FOREIGN KEY (Account_Number)
        REFERENCES ACCOUNT_TBL(Account_Number),
    CONSTRAINT fk_beneficiary
        FOREIGN KEY (Beneficiary_account_number)
        REFERENCES ACCOUNT_TBL(Account_Number)
);
```

---

## 📝 Sample Data Insert

### Insert into ACCOUNT_TBL

```sql
INSERT ALL
  INTO ACCOUNT_TBL VALUES ('1234567890', 80000, 'Reddy')
  INTO ACCOUNT_TBL VALUES ('1234567891', 0, 'Mahesh')
  INTO ACCOUNT_TBL VALUES ('1234567892', 100, 'Dhanu')
  INTO ACCOUNT_TBL VALUES ('1234567893', 500, 'Sam')
SELECT * FROM dual;

COMMIT;
```

---

## 🚀 How to Run

1. Open **Oracle SQL Developer / SQL*Plus**
2. Run the CREATE TABLE scripts
3. Insert sample data
4. Commit the changes

---

## 🔒 Constraints Used

* Primary Key
* Foreign Key
* Referential Integrity

---

## 📚 Technologies Used

* Oracle 11g
* SQL

---

## 👨‍💻 Author

Thiruppathi

---

## output
<img width="1526" height="653" alt="image" src="https://github.com/user-attachments/assets/3ffce8b0-009a-418c-850c-97821be716f8" />

