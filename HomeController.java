package com.smartparking.controller;

import com.smartparking.entity.Vehicle;
import com.smartparking.entity.ParkingSlot;
import com.smartparking.entity.ParkingRecord;

import com.smartparking.repository.VehicleRepository;
import com.smartparking.repository.ParkingSlotRepository;
import com.smartparking.repository.ParkingRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Autowired
    private ParkingRecordRepository parkingRecordRepository;

    // =========================
    // ADD VEHICLE
    // =========================
    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "redirect:/";
    }

    // =========================
    // GET VEHICLES (API)
    // =========================
    @GetMapping("/getVehicles")
    @ResponseBody
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    // =========================
    // VIEW SLOTS (API)
    // =========================
    @GetMapping("/availableSlots")
    @ResponseBody
    public List<ParkingSlot> availableSlots() {
        return parkingSlotRepository.findAll();
    }

    // =========================
    // ASSIGN SLOT
    // =========================
    @PostMapping("/assignSlot")
    public String assignSlot(@RequestParam int vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);

        if (vehicle != null) {
            for (ParkingSlot slot : parkingSlotRepository.findAll()) {

                if ("Available".equalsIgnoreCase(slot.getStatus())) {

                    slot.setStatus("Occupied");
                    slot.setVehicleId(vehicleId);
                    slot.setEntryTime(java.time.LocalDateTime.now());

                    parkingSlotRepository.save(slot);
                    break;
                }
            }
        }

        return "redirect:/";
    }

    // =========================
    // EXIT SLOT
    // =========================
    @PostMapping("/exitSlot")
    public String exitSlot(@RequestParam int vehicleId) {

        for (ParkingSlot slot : parkingSlotRepository.findAll()) {

            if (slot.getVehicleId() != null && slot.getVehicleId() == vehicleId) {

                // Create Parking Record
                ParkingRecord record = new ParkingRecord();
                record.setVehicleId(vehicleId);
                record.setSlotId(slot.getSlotId());
                record.setEntryTime(slot.getEntryTime());
                record.setExitTime(java.time.LocalDateTime.now());

                parkingRecordRepository.save(record);

                // Free slot
                slot.setStatus("Available");
                slot.setVehicleId(null);
                slot.setEntryTime(null);

                parkingSlotRepository.save(slot);

                break;
            }
        }

        return "redirect:/slotsPage";
    }

    // =========================
    // TEST API
    // =========================
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "TEST WORKING";
    }
}