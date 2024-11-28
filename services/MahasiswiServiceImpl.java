package services;

import entities.Mahasiswi;
import java.util.List;
import java.util.ArrayList;

public class MahasiswiServiceImpl implements MahasiswiService {
    private List<Mahasiswi> daftarMahasiswi = new ArrayList<>();

    @Override
    public void registerMahasiswi(String nama, String asrama, String nomorKamar) {
        Mahasiswi mahasiswi = new Mahasiswi(nama, asrama, nomorKamar);
        daftarMahasiswi.add(mahasiswi);
        System.out.println("Akun mahasiswi berhasil didaftarkan!");
    }

    @Override
    public List<Mahasiswi> getAllMahasiswi() {
        return daftarMahasiswi;
    }
}
