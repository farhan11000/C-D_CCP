import java.util.HashMap;

public class ReserverPayer {
    private int id;
    private String name;
    private HashMap<Integer, Reservation> myReservations;

    public ReserverPayer(int id, String name) {
        this.id = id;
        this.name = name;
        this.myReservations = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            myReservations.put(reservation.getNumber(), reservation);
        }
    }

    public void removeReservation(int reservationNumber) {
        if (myReservations.containsKey(reservationNumber)) {
            myReservations.remove(reservationNumber);
            System.out.println("Reservation " + reservationNumber + " removed from ReserverPayer " + this.name + "'s list.");
        } else {
            System.out.println("Warning: Reservation " + reservationNumber + " not found in ReserverPayer " + this.name + "'s list. No action taken.");
        }
    }
}
