package com.dssconsulting.test3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SaldoKaryawanId.class)
public class SaldoKaryawan {
    @Id
    private Long saldoId;
    @Id
    private Long karyawanId;
}

