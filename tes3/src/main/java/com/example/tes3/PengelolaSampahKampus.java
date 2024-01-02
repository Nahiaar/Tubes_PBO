package com.example.tes3;

import java.util.ArrayList;
import java.util.List;

public class PengelolaSampahKampus {

    private List<Sampah> daftarSampah = new ArrayList<>();  // Inisialisasi list pada saat deklarasi
    private List<Petugas> daftarPetugas = new ArrayList<>();  // Inisialisasi list pada saat deklarasi

    // Konstruktor dan metode-metode lainnya

    public void tambahSampah(Sampah sampah) {
        daftarSampah.add(sampah);
        // Logika lainnya jika diperlukan
    }

    public void tambahPetugas(Petugas petugas) {
        daftarPetugas.add(petugas);
        // Logika lainnya jika diperlukan
    }

    public void tugaskanPetugas(Sampah sampah, Petugas petugas) {
        // Logika penugasan petugas untuk menangani sampah

        // Misalnya, Anda dapat menambahkannya ke daftar tugas petugas atau melibatkan logika bisnis lainnya
        // Berikut adalah contoh sederhana:
        // Jika jenis sampah tertentu, tugaskan petugas dengan jabatan khusus
        if (sampah.getJenis().equalsIgnoreCase("JenisTertentu")) {
            petugas.setJabatan("JabatanKhusus");
        }

        // Simpan informasi penugasan atau lakukan logika bisnis lainnya sesuai kebutuhan aplikasi Anda
    }

    // Metode-metode lainnya
}
