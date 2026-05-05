package tugas1;
import java.util.Scanner;

public class Main {

    static Menu[] menu = new Menu[8];

    static void isiMenu() {
        menu[0] = new Menu("Nasi Goreng", 10000, "Makanan");
        menu[1] = new Menu("Mie Goreng", 10000, "Makanan");
        menu[2] = new Menu("Nasi Goreng Mawut", 15000, "Makanan");
        menu[3] = new Menu("Mie Rebus", 10000, "Makanan");

        menu[4] = new Menu("Es Teh", 3000, "Minuman");
        menu[5] = new Menu("Es Jeruk", 5000, "Minuman");
        menu[6] = new Menu("Teh Hangat", 3000, "Minuman");
        menu[7] = new Menu("Jeruk Hangat", 5000, "Minuman");
    }

    static void tampilMenu() {
    	System.out.println("Selamat datang di Warung Nasi Goreng Pak Aldi!");
    	
        System.out.println("\n=== MENU MAKANAN ===");
        System.out.println(menu[0].nama + " - Rp. " + menu[0].harga);
        System.out.println(menu[1].nama + " - Rp. " + menu[1].harga);
        System.out.println(menu[2].nama + " - Rp. " + menu[2].harga);
        System.out.println(menu[3].nama + " - Rp. " + menu[3].harga);

        System.out.println("\n=== MENU MINUMAN ===");
        System.out.println(menu[4].nama + " - Rp." + menu[4].harga);
        System.out.println(menu[5].nama + " - Rp." + menu[5].harga);
        System.out.println(menu[6].nama + " - Rp." + menu[6].harga);
        System.out.println(menu[7].nama + " - Rp." + menu[7].harga);
    }

    static Menu cari(String nama) {
        if (menu[0].nama.equalsIgnoreCase(nama)) {
            return menu[0];
        } else if (menu[1].nama.equalsIgnoreCase(nama)) {
            return menu[1];
        } else if (menu[2].nama.equalsIgnoreCase(nama)) {
            return menu[2];
        } else if (menu[3].nama.equalsIgnoreCase(nama)) {
            return menu[3];
        } else if (menu[4].nama.equalsIgnoreCase(nama)) {
            return menu[4];
        } else if (menu[5].nama.equalsIgnoreCase(nama)) {
            return menu[5];
        } else if (menu[6].nama.equalsIgnoreCase(nama)) {
            return menu[6];
        } else if (menu[7].nama.equalsIgnoreCase(nama)) {
            return menu[7];
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        isiMenu();
        tampilMenu();

        String[] namaPesanan = new String[4];
        int[] qty = new int[4];
        Menu[] pesanan = new Menu[4];

        // PESANAN 1
        System.out.print("\nPesanan 1 (atau '-' untuk batal pesan): ");
        namaPesanan[0] = in.nextLine();

        if (!namaPesanan[0].equals("-")) {
            pesanan[0] = cari(namaPesanan[0]);
            
            if (pesanan[0] == null) {
                System.out.println("Menu tidak ditemukan! ");
            } else {
                System.out.print("Jumlah: ");
                qty[0] = in.nextInt();
                in.nextLine();

                // PESANAN 2
                System.out.print("Pesanan 2 (atau '-' untuk selesai): ");
                namaPesanan[1] = in.nextLine();

                if (!namaPesanan[1].equals("-")) {
                    pesanan[1] = cari(namaPesanan[1]);
                    
                    if (pesanan[1] == null) {
                        System.out.println("Menu tidak ditemukan!");
                    } else {
                        System.out.print("Jumlah: ");
                        qty[1] = in.nextInt();
                        in.nextLine();

                        // PESANAN 3
                        System.out.print("Pesanan 3 (atau '-' untuk selesai): ");
                        namaPesanan[2] = in.nextLine();

                        if (!namaPesanan[2].equals("-")) {
                            pesanan[2] = cari(namaPesanan[2]);
                            
                            if (pesanan[2] == null) {
                                System.out.println("Menu tidak ditemukan!");
                            } else {
                                System.out.print("Jumlah: ");
                                qty[2] = in.nextInt();
                                in.nextLine();

                                // PESANAN 4
                                System.out.print("Pesanan 4 (atau '-' untuk selesai): ");
                                namaPesanan[3] = in.nextLine();

                                if (!namaPesanan[3].equals("-")) {
                                    pesanan[3] = cari(namaPesanan[3]);
                                    if (pesanan[3] == null) {
                                        System.out.println("Menu tidak ditemukan!");
                                    } else {
                                        System.out.print("Jumlah: ");
                                        qty[3] = in.nextInt();
                                        in.nextLine();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        
        pesanan[0] = cari(namaPesanan[0]);
        pesanan[1] = cari(namaPesanan[1]);
        pesanan[2] = cari(namaPesanan[2]);
        pesanan[3] = cari(namaPesanan[3]);
        
        
        int sub0 = (pesanan[0] != null) ? pesanan[0].harga * qty[0] : 0;
        int sub1 = (pesanan[1] != null) ? pesanan[1].harga * qty[1] : 0;
        int sub2 = (pesanan[2] != null) ? pesanan[2].harga * qty[2] : 0;
        int sub3 = (pesanan[3] != null) ? pesanan[3].harga * qty[3] : 0;

        int totalAwal = sub0 + sub1 + sub2 + sub3;
        
        int b1g1 = 0;

        if (totalAwal > 50000) {
            System.out.println("\n=== PROMO AKTIF: BELI 1 GRATIS 1 MINUMAN ===");
            
            // Cek Pesanan 1
            if (pesanan[0] != null && pesanan[0].kategori.equals("Minuman")) {
                b1g1 += sub0;
                qty[0] = qty[0] * 2;
            }
            // Cek Pesanan 2
            if (pesanan[1] != null && pesanan[1].kategori.equals("Minuman")) {
                b1g1 += sub1;
                qty[1] = qty[1] * 2;
            }
            if (pesanan[2] != null && pesanan[2].kategori.equals("Minuman")) {
                b1g1 += sub2;
                qty[2] = qty[2] * 2;
            }
            if (pesanan[3] != null && pesanan[3].kategori.equals("Minuman")) {
                b1g1 += sub3;
                qty[3] = qty[3] * 2;
            }
        }

        int diskon = 0;
        if (totalAwal > 100000) {
            diskon = (totalAwal * 10) / 100 ;
        }

        int setelahDiskon = totalAwal - diskon;

        int pajak = (setelahDiskon * 10) / 100 ;
        
        int service;
        if (totalAwal == 0) {
        	service = 0;
        } else {
        	service = 20000;
        }

        int totalAkhir = setelahDiskon + pajak + service;

        // OUTPUT STRUK
        if (totalAwal == 0) {
            System.out.println("Terima kasih sudah berkunjung!");
        } else {
            System.out.println("\n===== STRUK =====");
            
            boolean dptPromo = false;
            if (totalAwal > 50000) {
                if (pesanan[0] != null && pesanan[0].kategori.equals("Minuman")) dptPromo = true;
                if (pesanan[1] != null && pesanan[1].kategori.equals("Minuman")) dptPromo = true;
                if (pesanan[2] != null && pesanan[2].kategori.equals("Minuman")) dptPromo = true;
                if (pesanan[3] != null && pesanan[3].kategori.equals("Minuman")) dptPromo = true;
            }

            if (dptPromo) {
                System.out.println("Anda mendapatkan promo khusus minuman Beli 1 Gratis 1!");
            }

            if (pesanan[0] != null) System.out.println(pesanan[0].nama + " x" + qty[0] + " = Rp. " + sub0);
            if (pesanan[1] != null) System.out.println(pesanan[1].nama + " x" + qty[1] + " = Rp. " + sub1);
            if (pesanan[2] != null) System.out.println(pesanan[2].nama + " x" + qty[2] + " = Rp. " + sub2);
            if (pesanan[3] != null) System.out.println(pesanan[3].nama + " x" + qty[3] + " = Rp. " + sub3);

            System.out.println("------------------");
            System.out.println("Total Awal     : Rp. " + totalAwal);
            System.out.println("Promo B1G1     : Rp. " + b1g1);
            System.out.println("Diskon         : Rp. " + diskon);
            System.out.println("Setelah Diskon : Rp. " + setelahDiskon);
            System.out.println("Pajak          : Rp. " + pajak);
            System.out.println("Service        : Rp. " + service);
            System.out.println("------------------");
            System.out.println("TOTAL          : Rp. " + totalAkhir);
        }
    }
}
