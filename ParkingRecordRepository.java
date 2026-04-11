package com.smartparking.repository;

import com.smartparking.entity.ParkingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRecordRepository extends JpaRepository<ParkingRecord, Integer> {
}