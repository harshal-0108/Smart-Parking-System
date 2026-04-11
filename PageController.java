package com.smartparking.controller;

import com.smartparking.repository.VehicleRepository;
import com.smartparking.repository.ParkingSlotRepository;
import com.smartparking.repository.ParkingRecordRepository;
import com.smartparking.entity.User;
import com.smartparking.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Autowired
    private ParkingRecordRepository parkingRecordRepository;

    // ✅ ADD THIS (UserRepository injection)
    @Autowired
    private UserRepository userRepository;

    // =========================
    // LOGIN PAGE
    // =========================
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // =========================
    // LOGIN LOGIC
    // =========================
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            return "redirect:/"; // success → dashboard
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "login";
        }
    }

    // =========================
    // DASHBOARD
    // =========================
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "index";
    }

    // =========================
    // VEHICLES PAGE
    // =========================
    @GetMapping("/vehiclesPage")
    public String vehiclesPage(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "vehicles";
    }

    // =========================
    // SLOTS PAGE
    // =========================
    @GetMapping("/slotsPage")
    public String slotsPage(Model model) {
        model.addAttribute("slots", parkingSlotRepository.findAll());
        return "slots";
    }

    // =========================
    // RECORDS PAGE
    // =========================
    @GetMapping("/recordsPage")
    public String recordsPage(Model model) {
        model.addAttribute("records", parkingRecordRepository.findAll());
        return "records";
    }

    // =========================
    // DEBUG CHECK
    // =========================
    @GetMapping("/checkPage")
    @ResponseBody
    public String checkPage() {
        return "PAGE CONTROLLER WORKING";
    }
}