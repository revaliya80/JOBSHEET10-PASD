package Penugasan;

import java.util.Scanner;

public class MainKRS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);

        int pilih;

        do {
            System.out.println("\n=== ANTRIAN PERSETUJUAN KRS ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Proses KRS (2 Mahasiswa)");
            System.out.println("3. Tampilkan Semua");
            System.out.println("4. Lihat 2 Terdepan");
            System.out.println("5. Lihat Antrian Akhir");
            System.out.println("6. Jumlah Antrian");
            System.out.println("7. Jumlah Sudah Proses");
            System.out.println("8. Jumlah Belum Proses");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();

                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;

                case 2:
                    antrian.prosesKRS();
                    break;

                case 3:
                    antrian.tampilSemua();
                    break;

                case 4:
                    antrian.lihat2Terdepan();
                    break;

                case 5:
                    antrian.lihatAkhir();
                    break;

                case 6:
                    System.out.println("Jumlah antrian: " + antrian.jumlahAntrian());
                    break;

                case 7:
                    System.out.println("Sudah proses: " + antrian.jumlahSudahProses());
                    break;

                case 8:
                    System.out.println("Belum proses: " + antrian.belumProses());
                    break;

                case 9:
                    antrian.clear();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilih != 0);

        sc.close();
    }
}