package com.acc;

import java.util.List;
import java.util.Scanner;

import com.acc.model.Parcel;
import com.dao.ParcelDao;

public class ParcelManager {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    ParcelDao dao = new ParcelDao();
	    
	    int ch;
	    do {
	        System.out.println("1.Add new parcel \n2.Find a parcel \n3.Show all records \n4.Update Status \n5.Delete a record \n6.Exit");
	        System.out.print("Choice: ");
	        ch = sc.nextInt();
	        sc.nextLine();  
	        
	        switch(ch) {
	            case 1:
	                System.out.print("Enter Parcel ID: ");
	                int id = sc.nextInt();
	                sc.nextLine();  
	                System.out.print("Enter Sender Name: ");
	                String sender = sc.nextLine();
	                System.out.print("Enter Receiver Name: ");
	                String receiver = sc.nextLine();
	                System.out.print("Enter Weight (kg): ");
	                double weight = sc.nextDouble();
	                sc.nextLine();  
	                System.out.print("Enter Source Address: ");
	                String source = sc.nextLine();
	                System.out.print("Enter Destination Address: ");
	                String dest = sc.nextLine();

	                Parcel p = new Parcel(id, sender, receiver, weight, "Pending", source, dest);
	                dao.addParcel(p);
	                System.out.println("Parcel added successfully.");
	                break;
	                
	            case 2:
	                System.out.print("Enter ID to find record: ");
	                System.out.println(dao.find(sc.nextInt()));
	                sc.nextLine(); 
	                break;
	                
	            case 3:
	                List<Parcel> all = dao.findAll();
	                System.out.println("Total records: " + all.size());
	                all.forEach(System.out::println);
	                break;
	                
	            case 4:
	                System.out.print("Enter Parcel ID: ");
	                int id1 = sc.nextInt();
	                sc.nextLine();  
	                System.out.print("Enter new status: ");
	                String status = sc.nextLine();
	                dao.updateStatus(id1, status);
	                System.out.println("Status updated.");
	                break;
	                
	            case 5:
	                System.out.print("Enter ID to delete: ");
	                dao.delete(sc.nextInt());
	                sc.nextLine(); 
	                System.out.println("Record deleted.");
	                break;
	                
	            case 6:
	                System.out.println("Exiting...");
	                break;
	                
	            default:
	                System.out.println("Invalid choice! Try again.");
	        }
	    } while (ch != 6);
	    
	    sc.close();
	}

}