package services;

import entities.Slip;

public interface SlipService {
    void submitSlip(Slip slip);

    void submitSlip(Slip slip);

    Boolean approveSlip (Integer id);
    Boolean rejectSLip (Integer id);

    Boolean rejectSlip(Integer slipId);

    Boolean recordReturnTime(Integer slipId, String tanggalKembali, String waktuKembali);

    Slip[] filterSlipsByType (String jenisSlip);
    Slip[] filterSlipsByApprovalStatus(Boolean isApproved);
}
