# Post Office Management System

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

# Database Schema


CREATE DATABASE parcelmanag;
USE parcelmanag;

CREATE TABLE parcel (
    id INT PRIMARY KEY,
    sender_name VARCHAR(100),
    receiver_name VARCHAR(100),
    weight_kg DECIMAL(5,2),
    status VARCHAR(50),
    source_addr VARCHAR(200),
    dest_addr VARCHAR(200)
);
