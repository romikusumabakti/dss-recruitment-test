package com.dssconsulting.test3.controller;

import com.dssconsulting.test3.model.Karyawan;
import com.dssconsulting.test3.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/karyawan")
public class KaryawanController {
    @Autowired
    private final KaryawanService karyawanService;

    @Autowired
    public KaryawanController(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    // Get all karyawan
    @GetMapping
    public List<Karyawan> getAllKaryawan() {
        return karyawanService.findAll();
    }

    // Get karyawan by id
    @GetMapping("/{id}")
    public Karyawan getKaryawanById(@PathVariable Long id) {
        return karyawanService.findById(id);
    }

    // Create new karyawan
    @PostMapping
    public Karyawan createKaryawan(@RequestBody Karyawan karyawan) {
        return karyawanService.save(karyawan);
    }

    // Update karyawan
    @PutMapping("/{id}")
    public Karyawan updateKaryawan(@PathVariable Long id, @RequestBody Karyawan karyawanDetails) {
        return karyawanService.update(id, karyawanDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKaryawan(@PathVariable Long id) {
        karyawanService.delete(id);
        return ResponseEntity.ok().build();
    }
}