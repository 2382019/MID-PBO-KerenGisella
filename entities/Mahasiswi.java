package entities;

public class Mahasiswi {
    private String nama;
    private String asrama;
    private String nomorKamar;

    public Mahasiswi(String nama, String asrama, String nomorKamar) {
        this.nama = nama;
        this.asrama = asrama;
        this.nomorKamar = nomorKamar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsrama() {
        return asrama;
    }

    public void setAsrama(String asrama) {
        this.asrama = asrama;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }
}
