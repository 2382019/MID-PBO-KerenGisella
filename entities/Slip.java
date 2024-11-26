package entities;

public class Slip {
    private Mahasiswi mahasiswi;
    private String jenisSlip;
    private String alasan;
    private String tanggalKeluar;
    private String waktuKembali;
    private boolean statusPersetujuan;

    public Slip(Mahasiswi mahasiswi, String jenisSlip, String alasan, String tanggalKeluar, String waktuKembali, boolean statusPersetujuan) {
        this.mahasiswi = mahasiswi;
        this.jenisSlip = jenisSlip;
        this.alasan = alasan;
        this.tanggalKeluar = tanggalKeluar;
        this.waktuKembali = waktuKembali;
        this.statusPersetujuan = statusPersetujuan;
    }

    public Mahasiswi getMahasiswi() {
        return mahasiswi;
    }

    public void setMahasiswi(Mahasiswi mahasiswi) {
        this.mahasiswi = mahasiswi;
    }

    public String getJenisSlip() {
        return jenisSlip;
    }

    public void setJenisSlip(String jenisSlip) {
        this.jenisSlip = jenisSlip;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public String getWaktuKembali() {
        return waktuKembali;
    }

    public void setWaktuKembali(String waktuKembali) {
        this.waktuKembali = waktuKembali;
    }

    public boolean isStatusPersetujuan() {
        return statusPersetujuan;
    }

    public void setStatusPersetujuan(boolean statusPersetujuan) {
        this.statusPersetujuan = statusPersetujuan;
    }
}
