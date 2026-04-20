abstract class Kue{
    private String nama;
    private double harga;

    public Kue(String nama, double harga){
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();

    public String getNama(){
        return nama;
    }

    public double getHarga(){
        return harga;
    }

    public String toString(){
        return String.format("Nama Kue: %-15s | Harga Dasar: %-8.0f", nama, harga);
    }
}

class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat){
        super(nama, harga);
        this.berat = berat;
    }

    public double hitungHarga(){
        return getHarga() * berat;
    }

    public double getBerat(){
        return berat;
    }

    public String toString(){
        return super.toString() + String.format(" | Berat: %-5.1f | Jenis: Kue Pesanan", berat);
    }
}

class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah){
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double hitungHarga(){
        return getHarga() * jumlah * 2;
    }

    public double getJumlah(){
        return jumlah;
    }

    public String toString(){
        return super.toString() + String.format(" | Jumlah: %-4.0f | Jenis: Kue Jadi", jumlah);
    }
}



public class MainKue {
    public static void main(String[] args){
        // array yg terdiri dari 20 kue
        Kue[] daftarKue = new Kue[20];

        // isi dengan 20 objek kue
        daftarKue[0] = new KuePesanan("Black Forest Cake", 30000, 1.5);
        daftarKue[1] = new KuePesanan("Mille-feuille", 35000, 2.0);
        daftarKue[2] = new KuePesanan("Cheesecake", 45000, 3.0);
        daftarKue[3] = new KuePesanan("Red Velvet Cake", 35000, 2.4);
        daftarKue[4] = new KuePesanan("Chocolate Cake", 40000, 2.5);
        daftarKue[5] = new KuePesanan("Brownies", 20000, 2.0);
        daftarKue[6] = new KuePesanan("Fruitcake", 30000, 3.0);
        daftarKue[7] = new KuePesanan("Carrot Cake", 35000, 2.1);
        daftarKue[8] = new KuePesanan("Croissant", 19000, 1.5);
        daftarKue[9] = new KuePesanan("Cupcake", 35000, 2.0);
        daftarKue[10] = new KuePesanan("Cinnamon Roll", 30000, 2.8);
        daftarKue[11] = new KuePesanan("Strudel", 25000, 2.0);
        daftarKue[12] = new KuePesanan("Churros", 20000, 2.5);
        daftarKue[13] = new KuePesanan("Macaron", 40000, 3.0);
        daftarKue[14] = new KuePesanan("Blackforest", 45000, 3.0);
        daftarKue[15] = new KuePesanan("Banana Bread", 40000, 2.0);
        daftarKue[16] = new KuePesanan("Panna Cotta", 35000, 2.7);
        daftarKue[17] = new KuePesanan("Souffle", 20000, 1.0);
        daftarKue[18] = new KuePesanan("Pavlova", 35000, 2.5);
        daftarKue[19] = new KuePesanan("Strawberry Shortcake", 45000, 3.0);

        double totalHargaSemua = 0;
        System.out.println("===== DAFTAR SEMUA KUE =====");
        for (Kue k : daftarKue) {
            totalHargaSemua += k.hitungHarga();
        }
        System.out.printf("\nTotal Harga Semua Kue: " + totalHargaSemua);

        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        for (Kue k : daftarKue){
            if (k instanceof KuePesanan){
                totalHargaPesanan += k.hitungHarga();
                totalBeratPesanan += ((KuePesanan) k).getBerat();
            }
        }
        System.out.printf("\nTotal Harga Kue Pesanan: " + totalHargaPesanan);
        System.out.println("\nTotal Berat Kue Pesanan: " + totalBeratPesanan);

        Kue kueTermahal = daftarKue[0];
        for (int i = 1; i < daftarKue.length; i++){
            if (daftarKue[i].hitungHarga() > kueTermahal.hitungHarga()){
                kueTermahal = daftarKue[i];
            }
        }

        System.out.println("\n==== KUE DENGAN HARGA AKHIR TERBESAR ====");
        System.out.println(" ");
        System.out.println(kueTermahal + " | Harga Akhir: " + kueTermahal.hitungHarga());

    }
}
