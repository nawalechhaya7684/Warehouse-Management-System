package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.acc.model.Parcel;
import com.acc.service.ParcelService;
import com.acc.util.DBConnection;

public class ParcelDao implements ParcelService {

	@Override
	public void addParcel(Parcel p) {
		if (p.getWeightKg() < 0.1 || p.getWeightKg() > 20) 
		{ 
			System.out.println("Weight should be between 0.1-20kg to add parcel");
		    return; 
		}
        try (Connection c = DBConnection.getDBConnection();
        		
        	PreparedStatement ps = c.prepareStatement(
            "INSERT INTO parcel(id,sender_name,receiver_name,weight_kg,status,source_addr,dest_addr) VALUES(?,?,?,?,?,?,?)")) {
            ps.setInt(1, p.getId());
        	ps.setString(2, p.getSenderName()); 
            ps.setString(3, p.getReceiverName()); 
            ps.setDouble(4, p.getWeightKg());
            ps.setString(5, p.getStatus());
            ps.setString(6, p.getSourceAddr()); 
            ps.setString(7, p.getDestAddr());
            ps.executeUpdate(); 
            System.out.println("Added: " + p);
        } 
        catch (SQLException e)
        { 
        	e.printStackTrace();
        }

	}

	@Override
	public List<Parcel> findAll() {
		List<Parcel> list = new ArrayList<>();
		
        try (Connection c = DBConnection.getDBConnection(); Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM parcel"))
        {
            while (rs.next()) list.add(new Parcel(rs.getInt("id"),
            	rs.getString("sender_name"), 
            	rs.getString("receiver_name"),
                rs.getDouble("weight_kg"), 
                rs.getString("status"), 
                rs.getString("source_addr"), 
                rs.getString("dest_addr")));
        } 
        catch (SQLException e) { 
        	e.printStackTrace();
        	}
        return list;
	}

	@Override
	public Parcel find(int id) {
		try (Connection c = DBConnection.getDBConnection(); 
				PreparedStatement ps = c.prepareStatement("SELECT * FROM parcel WHERE id=?"))
		{
            ps.setInt(1, id); 
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                	{return new Parcel(rs.getInt("id"),
                	rs.getString("sender_name"), 
                	rs.getString("receiver_name"),
                    rs.getDouble("weight_kg"), 
                    rs.getString("status"), 
                    rs.getString("source_addr"),
                    rs.getString("dest_addr"));
                }
            }
        } catch (SQLException e)
		{
        	e.printStackTrace(); 
        }
        
		 return null;
	}

	@Override
	public void updateStatus(int id, String status) {

	    String[] valid = {"Pending","Out for Delivery","Delivered"};
	    boolean ok = false;

	    for (String s : valid) {
	        if (s.equalsIgnoreCase(status)) {
	            ok = true;
	            break;
	        }
	    }

	    if (!ok) {
	        System.out.println("Invalid status");
	        return;
	    }

	    Connection c = DBConnection.getDBConnection();
	    if (c == null) {
	        System.out.println("Database connection failed");
	        return;
	    }

	    try (PreparedStatement ps =
	             c.prepareStatement("UPDATE parcel SET status=? WHERE id=?")) {

	        ps.setString(1, status);
	        ps.setInt(2, id);

	        int rows = ps.executeUpdate();
	        System.out.println(rows > 0 ? "Updated ID " + id : "ID " + id + " not found");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	

	@Override
	public void delete(int id) {
		try (Connection c = DBConnection.getDBConnection();
				PreparedStatement ps = c.prepareStatement("DELETE FROM parcel WHERE id=?")) 
		{
            ps.setInt(1, id);
            System.out.println(ps.executeUpdate() > 0 ? "Deleted ID " + id : "ID " + id + " not found");
        } 
		catch (SQLException e) { e.printStackTrace(); }
    }

}