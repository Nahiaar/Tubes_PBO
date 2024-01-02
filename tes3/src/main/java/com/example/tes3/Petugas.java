package com.example.tes3;

public class Petugas {
    private String nama;
    private String nomorIdentitas;
    private String jabatan;

    public Petugas(String nama, String nomorIdentitas, String jabatan) {
        this.nama = nama;
        this.nomorIdentitas = nomorIdentitas;
        this.jabatan = jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorIdentitas() {
        return nomorIdentitas;
    }

    public void setNomorIdentitas(String nomorIdentitas) {
        this.nomorIdentitas = nomorIdentitas;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
