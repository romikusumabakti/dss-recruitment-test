package com.dssconsulting.test3.repository;

import com.dssconsulting.test3.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {
}
