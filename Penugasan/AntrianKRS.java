package Penugasan;

public class AntrianKRS {
    Mahasiswa[] data;
    int front, rear, size, max;
    int sudahProses = 0;
    final int MAX_DPA = 30;

    public AntrianKRS(int max) {
        this.max = max;
        data = new Mahasiswa[max];
        front = rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }

        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " masuk antrian.");
    }

    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Mahasiswa diproses:");

        for (int i = 0; i < 2 && !isEmpty(); i++) {
            Mahasiswa mhs = data[front];
            mhs.tampilkanData();

            size--;
            sudahProses++;

            if (size == 0) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
        }
    }

    public void tampilSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Daftar Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void lihat2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("2 Antrian Terdepan:");
        for (int i = 0; i < 2 && i < size; i++) {
            int index = (front + i) % max;
            data[index].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian paling akhir:");
            data[rear].tampilkanData();
        }
    }

    public int jumlahAntrian() {
        return size;
    }

    public int jumlahSudahProses() {
        return sudahProses;
    }

    public int belumProses() {
        return MAX_DPA - sudahProses;
    }

    public void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Antrian dikosongkan.");
    }
}