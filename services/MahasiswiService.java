package services;

import entities.Mahasiswi;
import java.util.List;

public interface MahasiswiService {
    // Method to register a new Mahasiswi account
    void registerMahasiswi(String nama, String asrama, String nomorKamar);

    // Method to get all Mahasiswi
    List<Mahasiswi> getAllMahasiswi();
}