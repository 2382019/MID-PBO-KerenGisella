package services;

import entities.Mahasiswi;

public interface MahasiswiService {
    void addMahasiswi(Mahasiswi mahasiswi);

    void registerMahasiswi (String nama, String asrama, String nomorKamar);
    Mahasiswi[] getAllMahasiswi();
    Boolean remove Mahasiswi(Integer id);
    Boolean editMahasiswi (Integer id, String nama, String asrama, String nomorKamar);
}
