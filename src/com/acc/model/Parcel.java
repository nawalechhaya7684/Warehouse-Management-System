package com.acc.model;

public class Parcel {
	int id;
	String senderName, receiverName, status, sourceAddr, destAddr;
    double weightKg;

    public Parcel() {}

    public Parcel(int id, String senderName, String receiverName, double weightKg, String status,
                  String sourceAddr, String destAddr) {
        this.id = id; 
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.weightKg = weightKg; 
        this.status = status; 
        this.sourceAddr = sourceAddr; 
        this.destAddr = destAddr;
    }

    
    public int getId() 
    { 
    	return id; 
    } 
    public void setId(int id) {
    	this.id = id; 
    	}
    public String getSenderName() { 
    	return senderName; 
    	}
    public void setSenderName(String senderName) { 
    	this.senderName = senderName;
    	}
    public String getReceiverName() { 
    	return receiverName; 
    	} 
    public void setReceiverName(String receiverName) { 
    	this.receiverName = receiverName; 
    	}
    public double getWeightKg() { 
    	return weightKg;
    	}
    public void setWeightKg(double weightKg) { 
    	this.weightKg = weightKg; 
    	}
    public String getStatus() {
    	return status; 
    	}
    public void setStatus(String status) { 
    	this.status = status; 
    	}
    public String getSourceAddr() {
    	return sourceAddr; 
    	} 
    public void setSourceAddr(String sourceAddr) { 
    	this.sourceAddr = sourceAddr; 
    	}
    public String getDestAddr() {
    	return destAddr; 
    	} 
    public void setDestAddr(String destAddr) { 
    	this.destAddr = destAddr;
    	}

    @Override public String toString() {
        return String.format("Parcel[id=%d, sender=%s, reciever=%s, weight=%.1fkg, status=%s, source address=%s, destination addr=%s]", 
            id, senderName, receiverName, weightKg, status, sourceAddr, destAddr);
    }
}