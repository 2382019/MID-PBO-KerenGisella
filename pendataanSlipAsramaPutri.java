import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class pendataanSlipAsramaPutri {
    public static ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();
    public static ArrayList<Slip> daftarSlip = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nSISTEM PENDATAAN SLIP ASRAMA PUTRI");
            System.out.println("1. Pendaftaran Akun");
            System.out.println("2. Pengajuan Slip");
            System.out.println("3. Edit Slip");
            System.out.println("4. Lihat Mahasiswi dan Slip");
            System.out.println("5. Pencatatan Waktu Keluar-Masuk");
            System.out.println("6. Hapus Slip");
            System.out.println("7. Pencarian dan Filter Slip");
            System.out.println("8. Keluar");

            String pilihan = input("Pilih menu");
            switch (pilihan) {
                case "1":
                    pendaftaranAkunMahasiswi();
                    break;
                case "2":
                    pengajuanSlip();
                    break;
                case "3":
                    editSlip();
                    break;
                case "4":
                    lihatMahasiswiDanSlip();
                    break;
                case "5":
                    pencatatanWaktuKembali();
                    break;
                case "6":
                    hapusSlip();
                    break;
                case "7":
                    pencarianDanFilterSlip();
                    break;
                case "8":
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan sistem. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    public static void pendaftaranAkunMahasiswi() {
        System.out.println("\nPENDAFTARAN AKUN");
        String nama = input("Nama lengkap");
        String asrama = input("Asrama");
        String nomorKamar = input("Nomor kamar");

        Mahasiswi mahasiswi = new Mahasiswi(nama, asrama, nomorKamar);
        daftarMahasiswi.add(mahasiswi);
        System.out.println("Akun mahasiswi berhasil didaftarkan!");
    }

    public static void pengajuanSlip() {
        if (daftarMahasiswi.isEmpty()) {
            System.out.println("Belum terdaftar. Silakan daftar terlebih dahulu.");
            return;
        }

        System.out.println("Daftar Mahasiswi:");
        for (int i = 0; i < daftarMahasiswi.size            (); i++) {
            System.out.println((i+1) + ". " + daftarMahasiswi.get(i).nama);
        }

        int pilihan = Integer.parseInt(input("Pilih nomor mahasiswi")) - 1;
        if (pilihan < 0 || pilihan >= daftarMahasiswi.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Mahasiswi mahasiswi = daftarMahasiswi.get(pilihan);
        String jenisSlip = input("Jenis slip (Keluar/Weekend)");
        String alasan = input("Alasan");
        String tanggalKeluar = input("Tanggal keluar (dd-MM-yyyy)");
        String waktuKeluar = input("Waktu keluar (HH:mm)");

        String tanggalWaktuKeluar = tanggalKeluar + " " + waktuKeluar;
        Slip slip = new Slip(mahasiswi, jenisSlip, alasan, tanggalWaktuKeluar);
        daftarSlip.add(slip);
        System.out.println("Slip berhasil diajukan dan menunggu persetujuan.");
    }

    public static void editSlip() {
        System.out.println("\nEDIT SLIP");
        if (daftarSlip.isEmpty()) {
            System.out.println("Tidak ada slip yang dapat diedit.");
            return;
        }

        // Menampilkan daftar slip
        System.out.println("Daftar Slip yang Ada:");
        for (int i = 0; i < daftarSlip.size(); i++) {
            Slip slip = daftarSlip.get(i);
            System.out.println((i + 1) + ". " + slip.mahasiswi.nama + " - " + slip.jenisSlip + " - " + slip.alasan);
        }

        int pilihan = Integer.parseInt(input("Pilih nomor slip yang ingin diedit")) - 1;
        if (pilihan < 0 || pilihan >= daftarSlip.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Slip slip = daftarSlip.get(pilihan);
        System.out.println("\nEDIT DATA SLIP");
        slip.jenisSlip = input("Jenis slip baru (Keluar/Weekend) (" + slip.jenisSlip + ")");
        slip.alasan = input("Alasan baru (" + slip.alasan + ")");
        slip.tanggalKeluar = input("Tanggal keluar baru (" + slip.tanggalKeluar + ")");
        System.out.println("Slip berhasil diperbarui.");
    }

    public static void lihatMahasiswiDanSlip() {
        System.out.println("\nLIHAT MAHASISWI DAN SLIP YANG TELAH ADA");
        if (daftarMahasiswi.isEmpty()) {
            System.out.println("Tidak ada mahasiswi yang terdaftar.");
            return;
        }

        System.out.println("Daftar Mahasiswi dan Slip yang Ada:");
        for (Mahasiswi mahasiswi : daftarMahasiswi) {
            System.out.println("Nama: " + mahasiswi.nama);
            for (Slip slip : daftarSlip) {
                if (slip.mahasiswi == mahasiswi) {
                    System.out.println(" - Slip: " + slip.jenisSlip + " - " + slip.alasan + " - " + slip.tanggalKeluar);
                }
            }
        }
    }

    public static void pencatatanWaktuKembali() {
        System.out.println("\nPENCATATAN WAKTU KELUAR-MASUK");

        // Menampilkan semua slip yang ada (tanpa filter status)
        System.out.println("Daftar Slip yang Ada:");
        for (int i = 0; i < daftarSlip.size(); i++) {
            Slip slip = daftarSlip.get(i);
            System.out.println((i + 1) + ". " + slip.mahasiswi.nama + " - " + slip.jenisSlip + " - " + slip.alasan);
        }

        int pilihan = Integer.parseInt(input("Pilih nomor slip untuk mencatat waktu kembali")) - 1;
        if (pilihan < 0 || pilihan >= daftarSlip.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        // Memasukkan waktu kembali
        Slip slip = daftarSlip.get(pilihan);
        String tanggalKembali = input("Tanggal kembali (dd-MM-yyyy)");
        String waktuKembali = input("Waktu kembali (HH:mm)");
        String tanggalWaktuKembali = tanggalKembali + " " + waktuKembali;
        slip.waktuKembali = tanggalWaktuKembali;
        System.out.println("Waktu kembali berhasil dicatat.");
    }

    public static void hapusSlip() {
        System.out.println("\nHAPUS SLIP");
        if (daftarSlip.isEmpty()) {
            System.out.println("Tidak ada slip yang dapat dihapus.");
            return;
        }

        // Menampilkan daftar slip
        System.out.println("Daftar Slip yang Ada:");
        for (int i = 0; i < daftarSlip.size(); i++) {
            Slip slip = daftarSlip.get(i);
            System.out.println((i + 1) + ". " + slip.mahasiswi.nama + " - " + slip.jenisSlip + " - " + slip.alasan);
        }

        int pilihan = Integer.parseInt(input("Pilih nomor slip yang ingin dihapus")) - 1;
        if (pilihan < 0 || pilihan >= daftarSlip.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        daftarSlip.remove(pilihan);
        System.out.println("Slip berhasil dihapus.");
    }

    public static void pencarianDanFilterSlip() {
        System.out.println("\nPENCARIAN DAN FILTER SLIP");
        System.out.println("Filter berdasarkan jenis slip");

        filterSlipBerdasarkanJenis();
    }

    private static void filterSlipBerdasarkanJenis() {
        String jenisSlip = input("Masukkan jenis slip (Keluar/Weekend)");
        boolean ditemukan = false;

        for (Slip slip : daftarSlip) {
            if (slip.jenisSlip.equalsIgnoreCase(jenisSlip)) {
                tampilkanInfoSlip(slip);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada slip dengan jenis tersebut.");
        }
    }

    private static void tampilkanInfoSlip(Slip slip) {
        System.out.println("Nama: " + slip.mahasiswi.nama);
        System.out.println("Jenis Slip: " + slip.jenisSlip);
        System.out.println("Alasan: " + slip.alasan);
        System.out.println("Tanggal dan Waktu Keluar: " + slip.tanggalKeluar);
        if (slip.waktuKembali != null) {
            System.out.println("Tanggal dan Waktu Kembali: " + slip.waktuKembali);
        }
        System.out.println("--------------------");
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }
}

class Mahasiswi {
    String nama;
    String asrama;
    String nomorKamar;

    public Mahasiswi(String nama, String asrama, String nomorKamar) {
        this.nama = nama;
        this.asrama = asrama;
        this.nomorKamar = nomorKamar;
    }
}

class Slip {
    Mahasiswi mahasiswi;
    String jenisSlip;
    String alasan;
    String tanggalKeluar;
    String waktuKembali;
    boolean statusPersetujuan;

    public Slip(Mahasiswi mahasiswi, String jenisSlip, String alasan, String tanggalKeluar) {
        this.mahasiswi = mahasiswi;
        this.jenisSlip = jenisSlip;
        this.alasan = alasan;
        this.tanggalKeluar = tanggalKeluar;
        this.statusPersetujuan = false;
    }
}