package repositories;

import entities.Slip;

public interface SlipRepository {
    Slip[] getAll();

    void add (Slip slip);

    Boolean remove (Integer id);

    Boolean edit (Slip slip);

    Slip[] filterByStatus (Boolean status);
    Slip[] filterBySType (String jenisSlip);

    Slip[] filterByType(String jenisSlip);
}
