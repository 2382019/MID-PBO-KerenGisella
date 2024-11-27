package services;

import entities.Slip;
import java.util.ArrayList;

public class SlipServiceImpl implements SlipService{
    private ArrayList<Slip> daftarSlip;

    public SlipServiceImpl(ArrayList<Slip> daftarSlip) {
        this.daftarSlip = daftarSlip;
    }

    @Override
    public void submitSlip(Slip slip) {
        if (slip == null || slip.getJenisSlip().isBlank() || slip.getAlasan().isBlank()) {
            System.out.println("Data Slip tidak lengkap.");
            return;
        }
        daftarSlip.add(slip);
        System.out.println("Slip berhasil diajukan.");
    }

    @Override
    public Boolean approveSlip(Integer slipId) {
        for (Slip slip : daftarSlip) {
            if (slip.getMahasiswi().getNomorKamar().hashCode() == slipId) { // Assuming slipId is based on Mahasiswi's nomorKamar
                slip.setStatusPersetujuan(true);
                System.out.println("Slip telah disetujui.");
                return true;
            }
        }
        System.out.println("Slip dengan ID tersebut tidak ditemukan.");
        return false;
    }

    @Override
    public Boolean rejectSLip(Integer id) {
        return null;
    }

    @Override
    public Boolean rejectSlip(Integer slipId) {
        for (Slip slip : daftarSlip) {
            if (slip.getMahasiswi().getNomorKamar().hashCode() == slipId) { // Assuming slipId is based on Mahasiswi's nomorKamar
                slip.setStatusPersetujuan(false);
                System.out.println("Slip telah ditolak.");
                return true;
            }
        }
        System.out.println("Slip dengan ID tersebut tidak ditemukan.");
        return false;
    }

    @Override
    public Boolean recordReturnTime(Integer slipId, String tanggalKembali, String waktuKembali) {
        for (Slip slip : daftarSlip) {
            if (slip.getMahasiswi().getNomorKamar().hashCode() == slipId) { // Assuming slipId is based on Mahasiswi's nomorKamar
                slip.setWaktuKembali(tanggalKembali + " " + waktuKembali);
                System.out.println("Waktu kembali berhasil dicatat.");
                return true;
            }
        }
        System.out.println("Slip dengan ID tersebut tidak ditemukan.");
        return false;
    }

    @Override
    public Slip[] filterSlipsByType(String jenisSlip) {
        ArrayList<Slip> filteredSlips = new ArrayList<>();
        for (Slip slip : daftarSlip) {
            if (slip.getJenisSlip().equalsIgnoreCase(jenisSlip)) {
                filteredSlips.add(slip);
            }
        }
        return filteredSlips.toArray(new Slip[0]);
    }

    @Override
    public Slip[] filterSlipsByApprovalStatus(Boolean isApproved) {
        ArrayList<Slip> filteredSlips = new ArrayList<>();
        for (Slip slip : daftarSlip) {
            if (slip.isStatusPersetujuan() == isApproved) {
                filteredSlips.add(slip);
            }
        }
        return filteredSlips.toArray(new Slip[0]);
    }
}
