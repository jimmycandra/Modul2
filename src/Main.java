import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemPerpustakaan sistemPerpustakaan = new SistemPerpustakaan();
        sistemPerpustakaan.jalankan();
    }
}

class SistemPerpustakaan {
    private Buku[] daftarBuku = new Buku[100];
    private Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private int jumlahMahasiswa = 0;
    private int jumlahBuku = 0;

    public void jalankan() {
        isiBukuAwal();

        int pilihan;
        Scanner scanner = new Scanner(System.in);

        do {
            tampilkanMenu();
            System.out.print("Pilih (1-3): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    Admin admin = new Admin(this, scanner);
                    admin.login();
                    break;
                case 2:
                    SistemMahasiswa sistemMahasiswa = new SistemMahasiswa(this, scanner);
                    sistemMahasiswa.login();
                    break;
                case 3:
                    System.out.println("Selamat tinggal!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);

        scanner.close();
    }

    private void isiBukuAwal() {
        tambahBuku(new Buku("001", "PECEL", "WARTEG", 5));
        tambahBuku(new Buku("002", "SATE", "WARTEG", 5));
        tambahBuku(new Buku("003", "TAHU", "WARTEG", 5));
        tambahBuku(new Buku("004", "KEBAB", "WARTEG", 5));
        tambahBuku(new Buku("005", "AYAM GEPREK", "WARTEG", 5));
        tambahBuku(new Buku("006", "JASUKE", "WARTEG", 5));
        tambahBuku(new Buku("007", "MARTABAK", "WARTEG", 5));
        tambahBuku(new Buku("008", "TERANG BULAN", "WARTEG", 5));
        tambahBuku(new Buku("009", "BATAGOR", "WARTEG", 5));
        tambahBuku(new Buku("010", "PISCOK", "WARTEG", 5));
        tambahBuku(new Buku("011", "ROTI", "WARTEG", 5));
        tambahBuku(new Buku("012", "BAKSO", "WARTEG", 5));
        tambahBuku(new Buku("013", "ES TEH", "WARTEG", 5));
    }

    public void tambahBuku(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku++] = buku;
        } else {
            System.out.println("Daftar buku sudah penuh. Tidak dapat menambahkan buku lagi.");
        }
    }

    public Buku[] getDaftarBuku() {
        return daftarBuku;
    }

    public void setDaftarBuku(Buku[] daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public Mahasiswa[] getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public void setDaftarMahasiswa(Mahasiswa[] daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    public int getJumlahMahasiswa() {
        return jumlahMahasiswa;
    }

    public void setJumlahMahasiswa(int jumlahMahasiswa) {
        this.jumlahMahasiswa = jumlahMahasiswa;
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }

    public void setJumlahBuku(int jumlahBuku) {
        this.jumlahBuku = jumlahBuku;
    }

    private void tampilkanMenu() {
        System.out.println("===== Sistem Perpustakaan =====");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.println("3. Keluar");
    }
}

class Buku {
    private String id;
    private String judul;
    private String penulis;
    private int jumlah;

    public Buku(String id, String judul, String penulis, int jumlah) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.jumlah = jumlah;
    }

    public String getId() {
        return null;
    }

    public String getJudul() {
        return null;
    }

    public String getPenulis() {
        return null;
    }

    public String getJumlah() {
        return null;
    }

    public void setJumlah(int i) {
    }

    public void setJumlah(String s) {
    }

    // Getter dan setter
}

class Mahasiswa {
    private String nama;
    private String nim;
    private String fakultas;
    private String programStudi;

    public Mahasiswa(String nama, String nim, String fakultas, String programStudi) {
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.programStudi = programStudi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return null;
    }

    public String getFakultas() {
        return null;
    }

    public String getProgramStudi() {
        return null;
    }

    // Getter dan setter
}

class Admin {
    private SistemPerpustakaan sistemPerpustakaan;
    private Scanner scanner;

    public Admin(SistemPerpustakaan sistemPerpustakaan, Scanner scanner) {
        this.sistemPerpustakaan = sistemPerpustakaan;
        this.scanner = scanner;
    }

    public void login() {
        menuAdmin();
    }

    private void menuAdmin() {
        int pilihan;
        do {
            tampilkanMenuAdmin();
            System.out.print("Pilih (1-3): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    System.out.println("Keluar dari akun Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);
    }

    private void tampilkanMenuAdmin() {
        System.out.println("\n===== Menu Admin =====");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Mahasiswa");
        System.out.println("3. Logout");
    }

    private void tambahMahasiswa() {
        scanner.nextLine(); // Mengonsumsi newline
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Fakultas Mahasiswa: ");
        String fakultas = scanner.nextLine();
        System.out.print("Masukkan Program Studi Mahasiswa: ");
        String programStudi = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, fakultas, programStudi);
        sistemPerpustakaan.getDaftarMahasiswa()[sistemPerpustakaan.getJumlahMahasiswa()] = mahasiswa;
        sistemPerpustakaan.setJumlahMahasiswa(sistemPerpustakaan.getJumlahMahasiswa() + 1);

        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    private void tampilkanMahasiswa() {
        Mahasiswa[] mahasiswa = sistemPerpustakaan.getDaftarMahasiswa();
        System.out.println("\n===== Daftar Mahasiswa =====");
        for (int i = 0; i < sistemPerpustakaan.getJumlahMahasiswa(); i++) {
            System.out.println("Nama: " + mahasiswa[i].getNama());
            System.out.println("NIM: " + mahasiswa[i].getNim());
            System.out.println("Fakultas: " + mahasiswa[i].getFakultas());
            System.out.println("Program Studi: " + mahasiswa[i].getProgramStudi());
            System.out.println();
        }
    }
}

class SistemMahasiswa {
    private SistemPerpustakaan sistemPerpustakaan;
    private Scanner scanner;

    public SistemMahasiswa(SistemPerpustakaan sistemPerpustakaan, Scanner scanner) {
        this.sistemPerpustakaan = sistemPerpustakaan;
        this.scanner = scanner;
    }

    public void login() {
        // Logika login mahasiswa di sini
        // Untuk keperluan kesederhanaan, kita akan langsung menampilkan menu mahasiswa
        menuMahasiswa();
    }

    private void menuMahasiswa() {
        int pilihan;
        do {
            tampilkanMenuMahasiswa();
            System.out.print("Pilih (1-4): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanDaftarBuku();
                    break;
                case 2:
                    pinjamBuku();
                    break;
                case 3:
                    kembalikanBuku();
                    break;
                case 4:
                    System.out.println("Keluar dari akun Mahasiswa.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }

    private void tampilkanMenuMahasiswa() {
        System.out.println("\n===== Menu Mahasiswa =====");
        System.out.println("1. Tampilkan Daftar Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Logout");
    }

    private void tampilkanDaftarBuku() {
        Buku[] buku = sistemPerpustakaan.getDaftarBuku();
        System.out.println("\n===== Daftar Buku =====");
        for (int i = 0; i < sistemPerpustakaan.getJumlahBuku(); i++) {
            System.out.println("ID: " + buku[i].getId());
            System.out.println("Judul: " + buku[i].getJudul());
            System.out.println("Penulis: " + buku[i].getPenulis());
            System.out.println("Jumlah: " + buku[i].getJumlah());
            System.out.println();
        }
    }

    private void pinjamBuku() {
        System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
        String idBuku = scanner.next();
        Buku buku = cariBukuById(idBuku);
        if (buku != null) {
            buku.getJumlah();
        }
        System.out.println("Stok buku habis atau buku tidak ditemukan.");
    }

    private void kembalikanBuku() {
        System.out.print("Masukkan ID Buku yang ingin dikembalikan: ");
        String idBuku = scanner.next();
        Buku buku = cariBukuById(idBuku);
        if (buku != null) {
            buku.setJumlah(buku.getJumlah() + 1);
            System.out.println("Buku berhasil dikembalikan!");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private Buku cariBukuById(String id) {
        for (int i = 0; i < sistemPerpustakaan.getJumlahBuku(); i++) {
            if (sistemPerpustakaan.getDaftarBuku()[i].getId().equals(id)) {
                return sistemPerpustakaan.getDaftarBuku()[i];
            }
        }
        return null;
    }
}