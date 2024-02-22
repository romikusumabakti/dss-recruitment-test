package com.dssconsulting.test3.controller;

import com.dssconsulting.test3.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {
    @Autowired
    private KaryawanService karyawanService;

    // Endpoint untuk CRUD karyawan
}