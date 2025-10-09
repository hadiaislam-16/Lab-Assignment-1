public class CityCinema {
    private String cityName;
    private Cinema[] cinemas;
    private int size;

    public CityCinema(String cityName, int preSize) {
        this.cityName = cityName;
        this.cinemas = new Cinema[preSize];
        this.size = 0;
    }

    public void addCinema(String branchName, int preCount) {
        if (size == cinemas.length) growCapacity();
        cinemas[size++] = new Cinema(branchName, preCount);
    }

    private void growCapacity() {
        int newCapacity = (cinemas.length == 0) ? 1 : cinemas.length * 2;
        Cinema[] newArray = new Cinema[newCapacity];
        for (int i = 0; i < cinemas.length; i++) {
            newArray[i] = cinemas[i];
        }
        cinemas = newArray;
    }

    public boolean removeCinema(String branchName) {
        for (int i = 0; i < size; i++) {
            if (cinemas[i].getBranchName().equals(branchName)) {
                for (int j = i; j < size - 1; j++) {
                    cinemas[j] = cinemas[j + 1];
                }
                cinemas[--size] = null;
                return true;
            }
        }
        return false;
    }

    public Cinema getCinema(String branchName) {
        for (int i = 0; i < size; i++) {
            if (cinemas[i].getBranchName().equals(branchName)) {
                return cinemas[i];
            }
        }
        return null;
    }

    public boolean bookSeat(String branchName, int screenIdx, String seatId) {
        Cinema c = getCinema(branchName);
        return (c != null) && c.bookSeat(screenIdx, seatId);
    }

    public boolean cancelSeat(String branchName, int screenIdx, String seatId) {
        Cinema c = getCinema(branchName);
        return (c != null) && c.cancelSeat(screenIdx, seatId);
    }

    public int getTotalSeats() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            Cinema c = cinemas[i];
            for (int s = 0; s < c.getSize(); s++) {
                total += c.getScreen(s + 1).getTotalSeats();
            }
        }
        return total;
    }

    public int getAvailableSeats() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += cinemas[i].getAvailableSeats();
        }
        return total;
    }

    public String findFirstAvailableVIPSeat() {
        for (int i = 0; i < size; i++) {
            Cinema c = cinemas[i];
            for (int s = 1; s <= c.getSize(); s++) {
                Screen screen = c.getScreen(s);
                Seat[] vipSeats = screen.getAvailableSeatsByType(SeatType.VIP);
                if (vipSeats.length > 0) {
                    Seat seat = vipSeats[0];
                    return "Cinema-" + (i + 1) + " > Screen-" + s + 
                           " > " + seat.getId() +
                           " (" + seat.getType() + ", " + seat.getPrice() + " PKR)";
                }
            }
        }
        return "No VIP seats available in the city.";
    }

    public static CityCinema preloadCity() {
        CityCinema city = new CityCinema("Lahore", 2);
        city.addCinema("Cinema-1", 3);
        city.addCinema("Cinema-2", 3);
        city.addCinema("Cinema-3", 2);
        return city;
    }

    public void display() {
        System.out.println("City: " + cityName);
        for (int i = 0; i < size; i++) {
            cinemas[i].display();
        }
    }

    @Override
    public String toString() {
        return "CityCinema[" + cityName + "] | Cinemas: " + size +
               " | Total Seats: " + getTotalSeats() +
               " | Available: " + getAvailableSeats();
    }
}
