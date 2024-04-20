import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class AirfareCaluc {
    public static void main(String[] args) {

        NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
        Scanner scan = new Scanner(System.in);

        int ticketsSold = getUserInput("tickets sold", scan);
        int planeCapacity = getUserInput("plane capacity", scan);
        double showedUpPassengers = getUserInputDouble("passengers showing up", scan);
        double costPerPassenger = getUserInputDouble("Enter varying cost per passenger", scan);
        double overBookingFee = getUserInputDouble("overbook fee per passenger", scan);
        double pricePerTicket = getUserInputDouble("price of each ticket", scan);
        double fixedPlaneCost = getUserInputDouble("fixed cost of flying the plane", scan);

        //cost and tickets' calculations
        double extraPassengers =  Math.max(0,showedUpPassengers - planeCapacity);
        double totalTicketRevenue = pricePerTicket * ticketsSold;
        double totalVariableCost = (showedUpPassengers - extraPassengers) * costPerPassenger;
        double totalOverBooked = 0;
        if(showedUpPassengers > planeCapacity) {
            totalOverBooked  = extraPassengers * overBookingFee;
        }

        //final calculation
        double totalProfit =  totalTicketRevenue - (fixedPlaneCost + totalVariableCost + totalOverBooked);

        System.out.println("Total ticket revenue  :" + "\t\t" + cf.format(totalTicketRevenue));
        System.out.println("Total variable cost   :" + "\t\t" + cf.format(totalVariableCost));
        System.out.println("Total overbook cost   :" + "\t\t" + cf.format(totalOverBooked));
        System.out.println("Total profit          :" + "\t\t" + cf.format(totalProfit));
    }
    public static int getUserInput(String message, Scanner scan) {
        System.out.print("Enter the number of " + message + ":");
        return scan.nextInt();
    }
    public static double getUserInputDouble(String message, Scanner scan) {
        System.out.print("Enter the " + message + ":");
        return scan.nextDouble();
    }

}
