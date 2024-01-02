package com.example.tes3;

public class Sampah {
    private String jenis;
    private int jumlah;
    private String lokasi;
    private Petugas petugas;

    public Sampah(String jenis, int jumlah, String lokasi) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.lokasi = lokasi;
        this.petugas = null; // Petugas diatur menjadi null jika tidak disertakan
    }

    // Konstruktor untuk menyertakan objek Petugas
    public Sampah(String jenis, int jumlah, String lokasi, Petugas petugas) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.lokasi = lokasi;
        this.petugas = petugas;
    }

    public String getJenis() {
        return jenis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getLokasi() {
        return lokasi;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    @Override
    public String toString() {
        return "Sampah [Jenis=" + jenis + ", Jumlah=" + jumlah + ", Lokasi=" + lokasi +
                ", Petugas=" + (petugas != null ? petugas.getNama() : "Belum Ditugaskan") + "]";
    }
}
