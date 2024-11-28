package views;

import entities.Slip;

public interface MahasiswiView {
    void run();
    void showMainMenu();
    void pendaftaranAkunMahasiswi();
    void pengajuanSlip();
    void persetujuanPengurusAsrama();
    void notifikasiStatusPengajuan();
    void pencatatanWaktuKembali();
    void dashboardStatistik();
    void pencarianDanFilterSlip();
    void filterSlipBerdasarkanJenis();
    void filterSlipBerdasarkanStatus();
    void tampilkanInfoSlip(Slip slip);
    String input(String info);
}
