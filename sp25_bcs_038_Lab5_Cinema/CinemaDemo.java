public class CinemaDemo {
    public static void main(String[] args) {
        CityCinema karachi = new CityCinema("Karachi", 2);
        karachi.addCinema("Atrium Saddar", 3);
        karachi.addCinema("Nueplex DHA", 3);

        CityCinema lahore = new CityCinema("Lahore", 2);
        lahore.addCinema("CineStar Township", 2);
        lahore.addCinema("CineStar Gulberg", 2);

        CityCinema islamabad = new CityCinema("Islamabad", 1);
        islamabad.addCinema("Centaurus Megaplex", 3);

        preloadScreens(karachi);
        preloadScreens(lahore);
        preloadScreens(islamabad);

        System.out.println("=== Initial City Data ===\n");
        karachi.display();
        lahore.display();
        islamabad.display();

        System.out.println("\n=== Booking Workflow (Karachi: Cinema-1, Screen-1, Seat 3-007) ===");
        String seatId = "3-007";

        boolean booked = karachi.bookSeat("Atrium Saddar", 1, seatId);
        System.out.println("Booking seat " + seatId + ": " + (booked ? "Success" : "Failed"));

        boolean bookedAgain = karachi.bookSeat("Atrium Saddar", 1, seatId);
        System.out.println("Booking same seat again: " + (bookedAgain ? "Success" : "Rejected (Already booked)"));

        boolean canceled = karachi.cancelSeat("Atrium Saddar", 1, seatId);
        System.out.println("Canceling seat " + seatId + ": " + (canceled ? "Success" : "Failed"));

        System.out.println("\nUpdated layout after booking/canceling:");
        karachi.getCinema("Atrium Saddar").display();

        System.out.println("\n=== Searching VIP seat in Lahore ===");
        System.out.println(lahore.findFirstAvailableVIPSeat());
    }

    private static void preloadScreens(CityCinema city) {
        for (int i = 0; i < city.getSize(); i++) {
            Cinema c = city.getCinemaAt(i);
            int[][] rowPatterns = {
                {10, 11, 12, 13, 14},
                {8, 9, 10, 11},
                {12, 12, 12}
            };
            for (int s = 0; s < c.getSize(); s++) {
                int[] rows = rowPatterns[s % rowPatterns.length];
                c.getScreen(s + 1).generateSeats(rows);
            }
        }
    }
}
