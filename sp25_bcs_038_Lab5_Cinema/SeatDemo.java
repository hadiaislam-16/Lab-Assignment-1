public class SeatDemo {
    public static void main(String[] args) {
        Seat s1 = new Seat(1, 1, SeatType.REGULAR, 500);
        Seat s2 = new Seat(2, 5, SeatType.PREMIUM, 750);
        Seat s3 = new Seat(3, 7, SeatType.VIP, 1000);
        Seat s4 = new Seat(4, 2, SeatType.RECLINER, 1200);

        System.out.println("=== Initial Seat States ===");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println("\n=== Booking Seats ===");
        s2.book();
        s3.book();
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("\n=== Canceling VIP Seat ===");
        s3.cancel();
        System.out.println(s3);

        System.out.println("\n=== Adjusting Prices ===");
        s1.setPrice(550);
        System.out.println(s1);
    }
}
