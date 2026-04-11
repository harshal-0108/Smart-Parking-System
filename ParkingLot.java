package com.smartparking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Parking_Lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lot_id;

    private String lot_name;
    private String location;
    private int total_slots;

    // Getters & Setters
    public int getLot_id() {
        return lot_id;
    }

    public void setLot_id(int lot_id) {
        this.lot_id = lot_id;
    }

    public String getLot_name() {
        return lot_name;
    }

    public void setLot_name(String lot_name) {
        this.lot_name = lot_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotal_slots() {
        return total_slots;
    }

    public void setTotal_slots(int total_slots) {
        this.total_slots = total_slots;
    }
}