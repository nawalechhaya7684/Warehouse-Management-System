# Name:Chhaya krushna Nawale
# College name: AVCOE


# Project Title name:Post Office Management System

A Java-based console application for managing parcel deliveries with MySQL database integration.

# Features

- **Add New Parcels** - Register parcels with sender/receiver details
- **View All Records** - Display all parcels in the system
- **Search by ID** - Find specific parcels quickly
- **Update Status** - Change parcel status (Pending, Out for Delivery, Delivered)
- **Delete Records** - Remove parcels from the system
- **Input Validation** - Weight validation (0.1-20kg) and status validation

# Technologies Used

- **Java** - Core Java (JDK 21)
- **MySQL** - Database for storing parcel records
- **JDBC** - Java Database Connectivity
- **Eclipse** - IDE for development

- # Validation & Security
- **1.Weight Validation: Ensures parcel weight is within 0.1kg to 20kg range**
- **2.Status Validation: Restricts status to three predefined values only.**
- **3.ID Uniqueness: Prevents duplicate parcel IDs in the system.**
- **4.Null Checks: Validates all required fields to prevent empty entries.**
- **5.Database Integrity: Maintains referential integrity through proper SQL operations.**

# Database Schema



# Step 1: Create Database
```sql
CREATE DATABASE parcelmanag;
```
```sql
USE parcelmanag;
```

# Step 2: Create table
```sql
CREATE TABLE parcel (
id INT PRIMARY KEY,
sender_name VARCHAR(100),
receiver_name VARCHAR(100),
weight_kg DECIMAL(5,2),
status VARCHAR(50),
source_addr VARCHAR(200),
dest_addr VARCHAR(200)
);
```

# Step 3: Insert data
```sql
INSERT INTO parcel VALUES
(101, 'Rushika Pawar', 'Chhaya Nawale', 4.5, 'Pending', 'Sambhajinagar', 'Shrirampur'),
(102, 'Arpita Ragir', 'Shivani Pawar', 5.6, 'Delivered', 'Sangamner', 'Kokangaon');
```

```sql
SELECT * FROM parcel;
```

```markdown
│   POST OFFICE MANAGEMENT SYSTEM             │
-------------------------------------------------┤
│  1. Add new parcel                             │
│  2. Find a parcel                              │
│  3. Show all records                           │
│  4. Update Status                              │
│  5. Delete a record                            │
│  6. Exit                                       │
┤
│  Choice:                                       │
```

# Future Enhancement
- 1.Search by sender/receiver name.
- 2.Add phone numbers to parcels.
- 3.Export data to CSV.
- 4.Add delivery date field.
- 5.Activity logging.



