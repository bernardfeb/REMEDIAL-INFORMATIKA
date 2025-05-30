package REMEDI;

import java.util.Scanner;

public class Encyclopedia {
    private Scanner scanner;
    private Topic mechanics;
    private Topic thermodynamics;
    private Topic waves;
    private Topic optics;
    private Topic electricity;

    public Encyclopedia() {
        scanner = new Scanner(System.in);
        initializeTopics();
    }

    private void initializeTopics() {
        mechanics = new Topic("Mekanika",
            "Mekanika adalah cabang fisika yang mempelajari gerak dan gaya yang menyebabkan gerak tersebut.",
            new String[]{
                "F = m × a (Hukum Newton II)",
                "p = m × v (Momentum)",
                "Ek = ½ × m × v² (Energi Kinetik)"
            },
            new Problem("Sebuah benda bermassa 2 kg diberi gaya 10 N. Berapakah percepatannya?",
                "a = F/m = 10/2 = 5 m/s²")
        );

        thermodynamics = new Topic("Termodinamika",
            "Termodinamika adalah cabang fisika yang mempelajari hubungan antara panas, suhu, energi, dan kerja.",
            new String[]{
                "Q = m × c × ΔT (Kalor)",
                "PV = nRT (Persamaan Gas Ideal)",
                "ΔU = Q - W (Hukum I Termodinamika)"
            },
            new Problem("Air bermassa 100 gram dipanaskan dari 25°C ke 75°C. Jika kalor jenis air 4200 J/kg°C, berapa kalor yang dibutuhkan?",
                "Q = m × c × ΔT = 0.1 × 4200 × 50 = 21000 Joule")
        );

        waves = new Topic("Gelombang",
            "Gelombang adalah getaran yang merambat melalui medium atau tanpa medium.",
            new String[]{
                "v = λ × f (Cepat Rambat Gelombang)",
                "T = 1/f (Periode)",
                "E = h × f (Energi Foton)"
            },
            new Problem("Gelombang memiliki panjang gelombang 2 meter dan frekuensi 5 Hz. Berapakah cepat rambatnya?",
                "v = λ × f = 2 × 5 = 10 m/s")
        );

        optics = new Topic("Optik",
            "Optik adalah cabang fisika yang mempelajari tentang cahaya dan interaksinya dengan materi.",
            new String[]{
                "1/f = 1/s + 1/s' (Rumus Lensa)",
                "n = c/v (Indeks Bias)",
                "M = -s'/s (Perbesaran Bayangan)"
            },
            new Problem("Sebuah benda diletakkan 30 cm di depan lensa dengan fokus 20 cm. Dimanakah letak bayangannya?",
                "1/f = 1/s + 1/s', 1/20 = 1/30 + 1/s', s' = 60 cm")
        );

        electricity = new Topic("Listrik",
            "Listrik adalah bentuk energi yang berasal dari muatan listrik, menghasilkan efek seperti arus, medan, dan potensial listrik.",
            new String[]{
                "V = I × R (Hukum Ohm)",
                "P = V × I (Daya Listrik)",
                "W = V × I × t (Energi Listrik)"
            },
            new Problem("Sebuah resistor 100 Ω dialiri arus 0.5 A. Berapakah tegangannya?",
                "V = I × R = 0.5 × 100 = 50 Volt")
        );
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            
            if (choice == 6) {
                System.out.println("Terima kasih telah menggunakan Kamus Fisika!");
                break;
            }
            
            handleChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\n=== KAMUS FISIKA ===");
        System.out.println("1. Mekanika");
        System.out.println("2. Termodinamika");
        System.out.println("3. Gelombang");
        System.out.println("4. Optik");
        System.out.println("5. Listrik");
        System.out.println("6. Keluar");
        System.out.print("Pilih topik (1-6): ");
    }

    private int getUserChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
                System.out.print("Masukkan angka 1-6: ");
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang valid (1-6): ");
            }
        }
    }

    private void handleChoice(int choice) {
        Topic selectedTopic = switch (choice) {
            case 1 -> mechanics;
            case 2 -> thermodynamics;
            case 3 -> waves;
            case 4 -> optics;
            case 5 -> electricity;
            default -> null;
        };

        if (selectedTopic != null) {
            selectedTopic.display();
            System.out.println("\nTekan Enter untuk kembali ke menu utama...");
            scanner.nextLine();
        }
    }
} 