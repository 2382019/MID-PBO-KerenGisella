package repositories;

import entities.Mahasiswi;
import java.util.ArrayList;

public class MahasiswiRepositoryImpl implements MahasiswiRepository{
    private ArrayList<Mahasiswi> mahasiswiList = new ArrayList<>();

    @Override
    public Mahasiswi[] getAll() {
        return mahasiswiList.toArray(new Mahasiswi[0]);
    }

    @Override
    public void add (Mahasiswi mahasiswi) {
        mahasiswiList.add(mahasiswi);
    }

    @Override
    public Boolean remove (Integer id) {
        if (id < 0 || id >= mahasiswiList.size()) {
            return false;
        }
        mahasiswiList.remove((int) id);
        return true;
    }

    @Override
    public Boolean edit (Mahasiswi mahasiswi) {
        for (int i = 0; i < mahasiswiList.size(); i++) {
            if (mahasiswiList.get(i).equals(mahasiswi)) {
                mahasiswiList.set(i, mahasiswi);
                return true;
            }
        }
        return false;
    }
}
