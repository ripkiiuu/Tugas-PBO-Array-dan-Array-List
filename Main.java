import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        myBank.addCustomer("Budi", "Santoso");
        myBank.addCustomer("Siti", "Aminah");

        Customer customer1 = myBank.getCustomer(0);
        customer1.setAccount(new Account(500000));

        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        
        System.out.println("===================================");
        System.out.println("Selamat Datang di ATM Bank UNRAM");
        System.out.println("Nasabah Aktif: " + customer1.getFirstName() + " " + customer1.getLastName());
        System.out.println("===================================");

        Account activeAccount = customer1.getAccount(0);

        while (menu != 4) {
            System.out.println("\nMenu ATM:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Saldo Anda saat ini: Rp " + activeAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Masukkan nominal penarikan: Rp ");
                    double tarikan = scanner.nextDouble();
                    if (activeAccount.withdraw(tarikan)) {
                        System.out.println("Penarikan berhasil!");
                        System.out.println("Sisa saldo Anda: Rp " + activeAccount.getBalance());
                    } else {
                        System.out.println("Maaf, saldo tidak mencukupi.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nominal setoran: Rp ");
                    double setoran = scanner.nextDouble();
                    if (activeAccount.deposit(setoran)) {
                        System.out.println("Setoran berhasil ditambahkan!");
                        System.out.println("Saldo Anda saat ini: Rp " + activeAccount.getBalance());
                    } else {
                        System.out.println("Nominal setoran tidak valid.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan ATM kami.");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih 1-4.");
            }
        }
        
        scanner.close();
    }
}