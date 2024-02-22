package com.dssconsulting.test3.service;

import com.dssconsulting.test3.model.Karyawan;
import com.dssconsulting.test3.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaryawanService {

    private final KaryawanRepository karyawanRepository;

    @Autowired
    public KaryawanService(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    public List<Karyawan> findAll() {
        return karyawanRepository.findAll();
    }

    public Karyawan findById(Long id) {
        return karyawanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Karyawan dengan ID " + id + " tidak ditemukan."));
    }

    public Karyawan save(Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    public Karyawan update(Long id, Karyawan karyawanDetails) {
        Karyawan karyawan = findById(id);
        karyawan.setNama(karyawanDetails.getNama());
        karyawan.setTglLahir(karyawanDetails.getTglLahir());
        karyawan.setStatus(karyawanDetails.getStatus());
        karyawan.setGrupId(karyawanDetails.getGrupId());
        karyawan.setSaldoId(karyawanDetails.getSaldoId());
        return karyawanRepository.save(karyawan);
    }

    public void delete(Long id) {
        Karyawan karyawan = findById(id);
        karyawanRepository.delete(karyawan);
    }
}
