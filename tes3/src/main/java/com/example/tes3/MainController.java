package com.example.tes3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField jenisSampahField;

    @FXML
    private TextField jumlahSampahField;

    @FXML
    private TextField lokasiSampahField;

    @FXML
    private TextField namaPetugasField;

    @FXML
    private TextField nomorIdentitasPetugasField;

    @FXML
    private TextField jabatanPetugasField;

    @FXML
    private Button tambahSampahButton;

    @FXML
    private Button tambahPetugasButton;

    @FXML
    private Label laporanLabel;

    private Kampus kampus;

    public void setKampus(Kampus kampus) {
        this.kampus = kampus;
    }

    @FXML
    private void initialize() {
        tambahSampahButton.setOnAction(e -> tambahSampah());
        tambahPetugasButton.setOnAction(e -> tambahPetugas()); // Menyesuaikan aksi button dengan metode tambahPetugas()
    }

    private void tambahSampah() {
        try {
            String jenisSampah = jenisSampahField.getText();
            int jumlahSampah = Integer.parseInt(jumlahSampahField.getText());
            String lokasiSampah = lokasiSampahField.getText();

            Sampah sampah = new Sampah(jenisSampah, jumlahSampah, lokasiSampah);
            kampus.tambahSampah(sampah);

            // Menampilkan informasi dari kelas Kampus dan Sampah
            String infoSampah = String.format("Sampah berhasil ditambahkan:\nJenis: %s\nJumlah: %d\nLokasi: %s",
                    sampah.getJenis(), sampah.getJumlah(), sampah.getLokasi());

            // Menampilkan informasi dari kelas Petugas
            StringBuilder infoPetugas = new StringBuilder("Petugas:\n");
            for (Petugas petugas : kampus.getDaftarPetugas()) {
                infoPetugas.append("Nama: ").append(petugas.getNama()).append(", Nomor Identitas: ")
                        .append(petugas.getNomorIdentitas()).append(", Jabatan: ").append(petugas.getJabatan()).append("\n");
            }

            showAlert("Sampah Ditambahkan", infoSampah + "\n\n" + infoPetugas.toString(), Alert.AlertType.INFORMATION);

            updateLaporan();
        } catch (NumberFormatException ex) {
            showAlert("Error", "Jumlah Sampah harus berupa angka.", Alert.AlertType.ERROR);
        }
    }

    private void tambahPetugas() {
        try {
            String namaPetugas = namaPetugasField.getText();
            String nomorIdentitasPetugas = nomorIdentitasPetugasField.getText();
            String jabatanPetugas = jabatanPetugasField.getText();

            Petugas petugas = new Petugas(namaPetugas, nomorIdentitasPetugas, jabatanPetugas);
            kampus.tambahPetugas(petugas);

            showAlert("Petugas Ditambahkan", "Petugas berhasil ditambahkan:\nNama: " +
                            namaPetugas + "\nNomor Identitas: " + nomorIdentitasPetugas + "\nJabatan: " + jabatanPetugas,
                    Alert.AlertType.INFORMATION);

            updateLaporan();
        } catch (Exception ex) {
            showAlert("Error", "Gagal menambahkan petugas.", Alert.AlertType.ERROR);
        }
    }

    private void updateLaporan() {
        // Implementasi updateLaporan
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
