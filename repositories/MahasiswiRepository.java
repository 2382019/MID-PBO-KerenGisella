package repositories;

import entities.Mahasiswi;

public interface MahasiswiRepository {
    Mahasiswi[] getAll();

    public void addMahasiswi(Mahasiswi mahasiswi);

    void add (Mahasiswi mahasiswi);

    Boolean remove (Integer id);

    Boolean edit (Mahasiswi mahasiswi);
}
