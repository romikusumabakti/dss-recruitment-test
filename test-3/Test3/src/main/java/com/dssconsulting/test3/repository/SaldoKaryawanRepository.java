package com.dssconsulting.test3.repository;

import com.dssconsulting.test3.model.SaldoKaryawan;
import com.dssconsulting.test3.model.SaldoKaryawanId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoKaryawanRepository extends JpaRepository<SaldoKaryawan, SaldoKaryawanId> {
}
