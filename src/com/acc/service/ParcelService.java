package com.acc.service;

import java.util.List;

import com.acc.model.Parcel;

public interface ParcelService {

	void addParcel(Parcel p);
    List<Parcel> findAll();
    Parcel find(int id);
    void updateStatus(int id, String status);
    void delete(int id);
}