package services;

import entities.Mahasiswi;
import java.util.ArrayList;

public class MahasiswiServiceImpl implements MahasiswiService {
    private ArrayList<Mahasiswi> daftarMahasiswi;

    public MahasiswiServiceImpl(ArrayList<Mahasiswi> daftarMahasiswi) {
        this.daftarMahasiswi = daftarMahasiswi;
    }

    @Override
    public void addMahasiswi(Mahasiswi mahasiswi) {
        if (mahasiswi == null || mahasiswi.getNama().isBlank() || mahasiswi.getNomorKamar().isBlank()) {
            System.out.println("Data Mahasiswi tidak valid.");
            return;
        }
        daftarMahasiswi.add(mahasiswi);
        System.out.println("Akun Mahasiswi berhasil ditambahkan.");
    }

    @Override
    public void registerMahasiswi(String nama, String asrama, String nomorKamar) {

    }

    @Override
    public Mahasiswi[] getAllMahasiswi() {
        return daftarMahasiswi.toArray(new Mahasiswi[0]);
    }

    @Override
    public Boolean editMahasiswi(Integer id, String nama, String asrama, String nomorKamar) {
        return null;
    }
}
