package com.dssconsulting.test3.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SaldoKaryawanId implements Serializable {
    private Long saldoId;
    private Long karyawanId;
}
