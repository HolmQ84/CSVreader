import java.util.Scanner;

public class GUI {
    CSVreader reader = new CSVreader();
    Scanner scanner = new Scanner(System.in);

    public void mainOptions() {
        System.out.println("-= Velkommen til filmdatabasen! =-");
        System.out.println("Tryk (1) for at søge på en skuespiller");
        System.out.println("Tryk (2) for at søge på en instruktør");
        System.out.print("Vælg -> ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.print("Skriv navn på skuespiller: ");
                reader.searchActor(scanner.next());
                break;
            case 2:
                System.out.print("Skriv navn på Instruktør: ");
                reader.searchIntructor(scanner.next());
                break;
        }
    }
}
