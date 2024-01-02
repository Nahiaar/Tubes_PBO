package com.example.tes3;
import java.util.ArrayList;
import java.util.List;

public class Kampus {
    private String nama;
    private String alamat;
    private int kapasitas;
    private final List<Sampah> daftarSampah = new ArrayList<>();
    private final List<Petugas> daftarPetugas = new ArrayList<>(); // Tambahkan daftar petugas

    public Kampus(String nama, String alamat, int kapasitas) {
        this.nama = nama;
        this.alamat = alamat;
        this.kapasitas = kapasitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void tambahSampah(Sampah sampah) {
        if (daftarSampah.size() < kapasitas) {
            daftarSampah.add(sampah);
        } else {
            System.out.println("Kampus sudah mencapai kapasitas penuh.");
        }
    }

    public void tambahPetugas(Petugas petugas) {
        daftarPetugas.add(petugas);
    }

    public List<Sampah> getDaftarSampah() {
        return daftarSampah;
    }

    public List<Petugas> getDaftarPetugas() {
        return daftarPetugas;
    }

    public void cetakLaporanSampah() {
        System.out.println("=================== LAPORAN SAMPAH ====================");
        System.out.println("Kampus: " + nama);
        System.out.println("----------------------------------------");
        System.out.println("| Jenis | Jumlah | Lokasi |");
        System.out.println("----------------------------------------");
        for (Sampah sampah : daftarSampah) {
            System.out.printf("| %-7s | %6d | %-9s |\n", sampah.getJenis(), sampah.getJumlah(), sampah.getLokasi());
        }
        System.out.println("----------------------------------------");
    }

    public void cetakLaporanPetugas() {
        System.out.println("=================== LAPORAN PETUGAS ====================");
        System.out.println("Kampus: " + nama);
        System.out.println("----------------------------------------");
        System.out.println("| Nama | Nomor Identitas | Jabatan |");
        System.out.println("----------------------------------------");
        for (Petugas petugas : daftarPetugas) {
            System.out.printf("| %-4s | %-15s | %-7s |\n", petugas.getNama(), petugas.getNomorIdentitas(), petugas.getJabatan());
        }
        System.out.println("----------------------------------------");
    }
}
