package repositories;

import entities.Slip;
import java.util.ArrayList;

public class SlipRepositoryImpl implements SlipRepository{
    private ArrayList<Slip> slipList = new ArrayList<>();

    @Override
    public Slip[] getAll() {
        return slipList.toArray(new Slip[0]);
    }

    @Override
    public void add (Slip slip) {
        slipList.add(slip);
    }

    @Override
    public Boolean remove (Integer id) {
        if (id < 0 || id >= slipList.size()) {
            return false;
        }
        slipList.remove((int)id);
        return true;
    }

    @Override
    public Boolean edit (Slip slip) {
        for (int i = 0; i < slipList.size(); i++) {
            if (slipList.get(i).equals(slip)) {
                slipList.set(i, slip);
                return true;
            }
        }
        return false;
    }

    @Override
    public Slip[] filterByStatus (Boolean status) {
        ArrayList<Slip> filteredSlips = new ArrayList<>();
        for (Slip slip : slipList) {
            if (slip.isStatusPersetujuan() == status) {
                filteredSlips.add(slip);
            }
        }
        return filteredSlips.toArray(new Slip [0]);
    }

    @Override
    public Slip[] filterBySType(String jenisSlip) {
        return new Slip[0];
    }

    @Override
    public Slip[] filterByType(String jenisSlip) {
        ArrayList<Slip> filteredSlips = new ArrayList<>();
        for (Slip slip : slipList) {
            if (slip.getJenisSlip().equalsIgnoreCase(jenisSlip)) {
                filteredSlips.add(slip);
            }
        }
        return filteredSlips.toArray(new Slip[0]);
    }
}
