package services;

import entities.Slip;
import entities.Mahasiswi;
import java.util.List;

public interface SlipService {
    // Method to submit a new Slip
    void submitSlip(Mahasiswi mahasiswi, String jenisSlip, String alasan, String tanggalKeluar);

    // Method to approve a pending Slip
    void approveSlip(int slipIndex);

    // Method to get all pending slips
    List<Slip> getPendingSlips();

    // Method to view all the slip notifications (approved or pending)
    void viewSlipNotifications();

    // Method to record return time for an approved slip
    void recordReturnTime(int slipIndex, String tanggalKembali, String waktuKembali);

    // Method to filter slips by type
    List<Slip> filterSlipsByType(String jenisSlip);

    // Method to filter slips by approval status
    List<Slip> filterSlipsByStatus(boolean status);
}
