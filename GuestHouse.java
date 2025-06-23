import java.util.HashMap;

public class GuestHouse {
    private HashMap<Integer, Reservation> reservations;
    private String name;

    public GuestHouse(String name) {
        this.name = name;
        this.reservations = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            reservations.put(reservation.getNumber(), reservation);
        }
    }

    public String cancelReservation(int reservationNumber) {
        if (reservationNumber <= 0) {
            return "Error: Invalid reservation number. Please provide a positive number.";
        }

        Reservation reservationToCancel = reservations.get(reservationNumber);

        if (reservationToCancel == null) {
            return "Error: Reservation with number " + reservationNumber + " not found in " + this.name + ".";
        }

        ReserverPayer reserverPayer = reservationToCancel.getReserverPayer();
        Room allocatedRoom = reservationToCancel.getAllocatedRoom();

        if (reserverPayer == null) {
            return "Error: ReserverPayer for reservation " + reservationNumber + " is missing.";
        }
        if (allocatedRoom == null) {
            return "Warning: No room was allocated for reservation " + reservationNumber + ". Proceeding with cancellation.";
        }

        try {
            reservations.remove(reservationNumber);
            reserverPayer.removeReservation(reservationNumber);
            if (allocatedRoom != null) {
                allocatedRoom.deallocateRoom(reservationToCancel);
            }
            return "Confirmed: Reservation " + reservationNumber + " for " + reserverPayer.getName() + " cancelled successfully.";
        } catch (Exception e) {
            System.err.println("An error occurred during cancellation of reservation " + reservationNumber + ": " + e.getMessage());
            return "Error: An unexpected error occurred while cancelling reservation " + reservationNumber + ".";
        }
    }
}
