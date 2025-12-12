package HotelBookingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        BookingDAO bookingDAO = new BookingDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== HOTEL BOOKING SYSTEM ===");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Room No: ");
                    String r = sc.next();
                    System.out.print("Type: ");
                    String t = sc.next();
                    System.out.print("Price: ");
                    double p = sc.nextDouble();
                    roomDAO.addRoom(r, t, p);
                    break;

                case 2:
                    roomDAO.viewRooms().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Room ID: ");
                    int roomId = sc.nextInt();
                    System.out.print("Customer Name: ");
                    sc.nextLine();  
                    String name = sc.nextLine();
                    System.out.print("Check-in (YYYY-MM-DD): ");
                    String ci = sc.next();
                    System.out.print("Check-out (YYYY-MM-DD): ");
                    String co = sc.next();
                    bookingDAO.bookRoom(roomId, name, ci, co);
                    break;

                case 4:
                    System.out.print("Booking ID: ");
                    int bId = sc.nextInt();
                    bookingDAO.cancelBooking(bId);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}