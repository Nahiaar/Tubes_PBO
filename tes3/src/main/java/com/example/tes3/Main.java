package com.example.tes3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private PengelolaSampahKampus ps;
    private Sampah sampah;
    private Petugas petugas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplikasi Pengelola Sampah Kampus");


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField namaKampusField = new TextField();
        TextField alamatKampusField = new TextField();
        TextField kapasitasKampusField = new TextField();

        // Add style classes to labels and text fields
        Label nameLabel = new Label("Nama Kampus:");
        nameLabel.getStyleClass().add("label-style");
        namaKampusField.getStyleClass().add("text-field-style");

        Label alamatLabel = new Label("Alamat Kampus:");
        alamatLabel.getStyleClass().add("label-style");
        alamatKampusField.getStyleClass().add("text-field-style");

        Label kapasitasLabel = new Label("Kapasitas Kampus:");
        kapasitasLabel.getStyleClass().add("label-style");
        kapasitasKampusField.getStyleClass().add("text-field-style");

        grid.add(nameLabel, 0, 0);
        grid.add(namaKampusField, 1, 0);
        grid.add(alamatLabel, 0, 1);
        grid.add(alamatKampusField, 1, 1);
        grid.add(kapasitasLabel, 0, 2);
        grid.add(kapasitasKampusField, 1, 2);

        javafx.scene.control.Button submitButton = new javafx.scene.control.Button("Submit");
        submitButton.getStyleClass().add("button-style");
        submitButton.setOnAction(e -> inputSampah(namaKampusField.getText(), alamatKampusField.getText(), kapasitasKampusField.getText()));

        grid.add(submitButton, 1, 3);

        Scene scene = new Scene(grid, 300, 200);

        // Link the CSS file
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void inputSampah(String namaKampus, String alamatKampus, String kapasitasKampus) {
        try {
            int kapasitas = Integer.parseInt(kapasitasKampus);

            ps = new PengelolaSampahKampus();
            Kampus kampus = new Kampus(namaKampus, alamatKampus, kapasitas);

            TextField jenisSampahField = new TextField();
            TextField jumlahSampahField = new TextField();
            TextField lokasiSampahField = new TextField();

            // Add style classes to labels and text fields
            Label jenisLabel = new Label("Jenis Sampah:");
            jenisLabel.getStyleClass().add("label-style");
            jenisSampahField.getStyleClass().add("text-field-style");

            Label jumlahLabel = new Label("Jumlah Sampah:");
            jumlahLabel.getStyleClass().add("label-style");
            jumlahSampahField.getStyleClass().add("text-field-style");

            Label lokasiLabel = new Label("Lokasi Sampah:");
            lokasiLabel.getStyleClass().add("label-style");
            lokasiSampahField.getStyleClass().add("text-field-style");

            javafx.scene.control.Button submitSampahButton = new javafx.scene.control.Button("Submit Sampah");
            submitSampahButton.getStyleClass().add("button-style");
            submitSampahButton.setOnAction(e -> inputPetugas(
                    kampus.getNama(), kampus.getAlamat(), String.valueOf(kampus.getKapasitas()),
                    jenisSampahField.getText(), jumlahSampahField.getText(), lokasiSampahField.getText()));

            ps.tambahSampah(sampah);

            GridPane sampahGrid = new GridPane();
            sampahGrid.setHgap(10);
            sampahGrid.setVgap(10);

            sampahGrid.add(jenisLabel, 0, 0);
            sampahGrid.add(jenisSampahField, 1, 0);
            sampahGrid.add(jumlahLabel, 0, 1);
            sampahGrid.add(jumlahSampahField, 1, 1);
            sampahGrid.add(lokasiLabel, 0, 2);
            sampahGrid.add(lokasiSampahField, 1, 2);

            sampahGrid.add(submitSampahButton, 1, 3);

            Scene sampahScene = new Scene(sampahGrid, 300, 200);

            // Link the CSS file
            sampahScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            // Apply CSS globally for the new scene
            sampahScene.getRoot().setStyle("-fx-background-color: #f0f0f0;");

            Stage sampahStage = new Stage();
            sampahStage.setScene(sampahScene);
            sampahStage.show();
        } catch (NumberFormatException ex) {
            showAlert("Error", "Kapasitas Kampus harus berupa angka.", Alert.AlertType.ERROR);
        }
    }


    private void inputPetugas(String namaKampus, String alamatKampus, String kapasitasKampus, String jenisSampah, String jumlahSampah, String lokasiSampah) {
        try {
            ps = new PengelolaSampahKampus();
            Kampus kampus = new Kampus(namaKampus, alamatKampus, Integer.parseInt(kapasitasKampus));
            Sampah sampah = new Sampah(jenisSampah, Integer.parseInt(jumlahSampah), lokasiSampah);

            TextField namaPetugasField = new TextField();
            TextField nomorIdentitasPetugasField = new TextField();
            TextField jabatanPetugasField = new TextField();

            // Add style classes to labels and text fields
            Label namaPetugasLabel = new Label("Nama Petugas:");
            namaPetugasLabel.getStyleClass().add("label-style");
            namaPetugasField.getStyleClass().add("text-field-style");

            Label nomorIdentitasLabel = new Label("Nomor Identitas :");
            nomorIdentitasLabel.getStyleClass().add("label-style");
            nomorIdentitasPetugasField.getStyleClass().add("text-field-style");

            Label jabatanPetugasLabel = new Label("Jabatan Petugas:");
            jabatanPetugasLabel.getStyleClass().add("label-style");
            jabatanPetugasField.getStyleClass().add("text-field-style");

            javafx.scene.control.Button submitPetugasButton = new javafx.scene.control.Button("Submit Petugas");
            submitPetugasButton.getStyleClass().add("button-style");
            submitPetugasButton.setOnAction(e -> showResults(
                    kampus.getNama(), kampus.getAlamat(), String.valueOf(kampus.getKapasitas()),
                    sampah.getJenis(), String.valueOf(sampah.getJumlah()), sampah.getLokasi(),
                    namaPetugasField.getText(), nomorIdentitasPetugasField.getText(), jabatanPetugasField.getText()));

            GridPane petugasGrid = new GridPane();
            petugasGrid.setHgap(10);
            petugasGrid.setVgap(10);

            petugasGrid.add(namaPetugasLabel, 0, 0);
            petugasGrid.add(namaPetugasField, 1, 0);
            petugasGrid.add(nomorIdentitasLabel, 0, 1);
            petugasGrid.add(nomorIdentitasPetugasField, 1, 1);
            petugasGrid.add(jabatanPetugasLabel, 0, 2);
            petugasGrid.add(jabatanPetugasField, 1, 2);

            petugasGrid.add(submitPetugasButton, 1, 3);

            Scene petugasScene = new Scene(petugasGrid, 300, 200);

            // Link the CSS file
            petugasScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            Stage petugasStage = new Stage();
            petugasStage.setScene(petugasScene);
            petugasStage.show();
        } catch (NumberFormatException ex) {
            showAlert("Error", "Kapasitas Kampus harus berupa angka.", Alert.AlertType.ERROR);
        }
    }


    private void showResults(String namaKampus, String alamatKampus, String kapasitasKampus,
                             String jenisSampah, String jumlahSampah, String lokasiSampah,
                             String namaPetugas, String nomorIdentitasPetugas, String jabatanPetugas) {
        try {
            ps = new PengelolaSampahKampus();
            Kampus kampus = new Kampus(namaKampus, alamatKampus, Integer.parseInt(kapasitasKampus));
            Sampah sampah = new Sampah(jenisSampah, Integer.parseInt(jumlahSampah), lokasiSampah);
            Petugas petugas = new Petugas(namaPetugas, nomorIdentitasPetugas, jabatanPetugas);

            // Display results in TextArea
            TextArea resultsTextArea = new TextArea();
            resultsTextArea.setEditable(false);

            resultsTextArea.getStyleClass().add("text-area-style");

            resultsTextArea.appendText("Sampah berhasil ditambahkan:\n");
            resultsTextArea.appendText("Nama Kampus: " + kampus.getNama() + "\n");
            resultsTextArea.appendText("Alamat Kampus: " + kampus.getAlamat() + "\n");
            resultsTextArea.appendText("Kapasitas Kampus: " + kampus.getKapasitas() + "\n");
            resultsTextArea.appendText("Jenis: " + sampah.getJenis() + "\n");
            resultsTextArea.appendText("Jumlah: " + sampah.getJumlah() + "\n");
            resultsTextArea.appendText("Lokasi: " + sampah.getLokasi() + "\n");
            resultsTextArea.appendText("Nama Petugas: " + petugas.getNama() + "\n");
            resultsTextArea.appendText("Nomor Identitas Petugas: " + petugas.getNomorIdentitas() + "\n");
            resultsTextArea.appendText("Jabatan Petugas: " + petugas.getJabatan() + "\n");

            // Create a new scene for displaying results
            GridPane resultsGrid = new GridPane();
            resultsGrid.setHgap(10);
            resultsGrid.setVgap(10);

            Label hasilLabel = new Label("Hasil: ");
            hasilLabel.getStyleClass().add("label-style");

            resultsGrid.add(hasilLabel, 0, 0);
            resultsGrid.add(resultsTextArea, 0, 1);

            Scene resultsScene = new Scene(resultsGrid, 400, 300);

            // Link the CSS file
            resultsScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            // Apply CSS globally for the new scene
            resultsScene.getRoot().setStyle("-fx-background-color: #f0f0f0;");

            Stage resultsStage = new Stage();
            resultsStage.setTitle("Hasil Penambahan Sampah");
            resultsStage.setScene(resultsScene);
            resultsStage.show();
        } catch (NumberFormatException ex) {
            showAlert("Error", "Kapasitas Kampus atau Jumlah Sampah harus berupa angka.", Alert.AlertType.ERROR);
        }
    }


    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
