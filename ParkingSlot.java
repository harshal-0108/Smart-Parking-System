package com.smartparking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;

    private String slotNumber;
    private String status;

    private Integer vehicleId;

    // ✅ ADD THIS (IMPORTANT)
    private LocalDateTime entryTime;

    // ===== GETTERS & SETTERS =====

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    // ✅ ENTRY TIME METHODS (VERY IMPORTANT)

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
}