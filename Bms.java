package ProjectInternshipStudio;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Show {
    private String name;
    private int price;
    private int tax;

    public Show(String name, int price, int tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public int getTotalPrice() {
        return price + tax;
    }

    public void displayPriceDetails() {
        System.out.println("The amount to be paid for " + name + " ticket is " + price + " and the tax on it is " + tax + ". Total amount payable is " + getTotalPrice());
    }
}

class Movie extends Show {
    public Movie(String name) {
        super(name, 199, 35);
    }
}

class ComedyShow extends Show {
    public ComedyShow(String name) {
        super(name, 399, 71);
    }
}

class MusicShow extends Show {
    public MusicShow(String name) {
        super(name, 499, 89);
    }
}

class Payment {
    public static void displayPaymentMethods() {
        System.out.println("Select payment method:\n 1. UPI\n 2. Credit card\n 3. Debit card");
    }
}

public class Bms {
    private static List<Movie> movies = new ArrayList<>();
    private static List<ComedyShow> comedyShows = new ArrayList<>();
    private static List<MusicShow> musicShows = new ArrayList<>();

    static {
        movies.add(new Movie("Chandu Champion"));
        movies.add(new Movie("Ishq Vishk Rebound"));
        movies.add(new Movie("Inside out 2"));
        movies.add(new Movie("The Exorcism"));

        comedyShows.add(new ComedyShow("Gaurav Gupta Live - India Tour"));
        comedyShows.add(new ComedyShow("Standup Comedy by LOCO"));
        comedyShows.add(new ComedyShow("Mindfool India Tour"));
        comedyShows.add(new ComedyShow("Good Boy Better Show"));

        musicShows.add(new MusicShow("Yeh Jo Hans Rahi Hai Duniya"));
        musicShows.add(new MusicShow("Sundown"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("BookMyShow\nIt all starts here");
        System.out.print("Enter Location: ");
        String loc = sc.nextLine();
        System.out.println("Searching " + loc + " for movies and shows");
        System.out.print("Type show you want to book (Movies, Comedy Shows, Music Shows): ");
        String fun = sc.nextLine();

        switch (fun) {
            case "Movies":
                displayShows(movies, sc);
                break;
            case "Comedy Shows":
                displayShows(comedyShows, sc);
                break;
            case "Music Shows":
                displayShows(musicShows, sc);
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
        sc.close();
    }

    private static <T extends Show> void displayShows(List<T> shows, Scanner sc) {
        for (int i = 0; i < shows.size(); i++) {
            System.out.println((i + 1) + ". " + shows.get(i).getName());
        }

        int choice = sc.nextInt();
        if (choice > 0 && choice <= shows.size()) {
            Show selectedShow = shows.get(choice - 1);
            System.out.println("Selected Show: " + selectedShow.getName());
            selectedShow.displayPriceDetails();
            Payment.displayPaymentMethods();
        } else {
            System.out.println("Selected Show Currently Unavailable");
        }
    }
}
