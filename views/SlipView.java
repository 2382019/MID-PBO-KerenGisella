package views;

import entities.Slip;

public interface SlipView {
    void run();
    void pengajuanSlip();
    void persetujuanPengurusAsrama();
    void notifikasiStatusPengajuan();
    void pencatatanWaktuKembali();
    void filterSlipBerdasarkanJenis();
    void filterSlipBerdasarkanStatus();
    void tampilkanInfoSlip(Slip slip);
    String input(String info);
}
