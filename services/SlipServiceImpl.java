package services;

import entities.Slip;
import entities.Mahasiswi;
import java.util.List;
import java.util.ArrayList;

public class SlipServiceImpl implements SlipService {
    private List<Slip> daftarSlip = new ArrayList<>();

    @Override
    public void submitSlip(Mahasiswi mahasiswi, String jenisSlip, String alasan, String tanggalKeluar) {
        Slip slip = new Slip(mahasiswi, jenisSlip, alasan, tanggalKeluar);
        daftarSlip.add(slip);
        System.out.println("Slip berhasil diajukan.");
    }

    @Override
    public void approveSlip(int slipIndex) {
        if (slipIndex >= 0 && slipIndex < daftarSlip.size()) {
            Slip slip = daftarSlip.get(slipIndex);
            slip.setStatusPersetujuan(true);
            System.out.println("Slip disetujui.");
        } else {
            System.out.println("Nomor slip tidak valid.");
        }
    }

    @Override
    public List<Slip> getPendingSlips() {
        List<Slip> pendingSlips = new ArrayList<>();
        for (Slip slip : daftarSlip) {
            if (!slip.isStatusPersetujuan()) {
                pendingSlips.add(slip);
            }
        }
        return pendingSlips;
    }

    @Override
    public void viewSlipNotifications() {
        for (Slip slip : daftarSlip) {
            System.out.println(slip.getMahasiswi().getNama() + " - " + slip.getJenisSlip() + ": " +
                    (slip.isStatusPersetujuan() ? "Disetujui" : "Menunggu Persetujuan"));
        }
    }

    @Override
    public void recordReturnTime(int slipIndex, String tanggalKembali, String waktuKembali) {
        if (slipIndex >= 0 && slipIndex < daftarSlip.size()) {
            Slip slip = daftarSlip.get(slipIndex);
            String tanggalWaktuKembali = tanggalKembali + " " + waktuKembali;
            slip.setWaktuKembali(tanggalWaktuKembali);
            System.out.println("Waktu kembali berhasil dicatat.");
        } else {
            System.out.println("Nomor slip tidak valid.");
        }
    }

    @Override
    public List<Slip> filterSlipsByType(String jenisSlip) {
        List<Slip> filteredSlips = new ArrayList<>();
        for (Slip slip : daftarSlip) {
            if (slip.getJenisSlip().equalsIgnoreCase(jenisSlip)) {
                filteredSlips.add(slip);
            }
        }
        return filteredSlips;
    }

    @Override
    public List<Slip> filterSlipsByStatus(boolean status) {
        List<Slip> filteredSlips = new ArrayList<>();
        for (Slip slip : daftarSlip) {
            if (slip.isStatusPersetujuan() == status) {
                filteredSlips.add(slip);
            }
        }
        return filteredSlips;
    }
}
