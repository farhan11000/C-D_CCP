public class Room {
    private int number;
    private RoomType roomType;
    private boolean occupied;
    private Reservation currentReservation;

    public Room(int number, RoomType roomType) {
        this.number = number;
        this.roomType = roomType;
        this.occupied = false;
        this.currentReservation = null;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Reservation getCurrentReservation() {
        return currentReservation;
    }

    public void setCurrentReservation(Reservation currentReservation) {
        this.currentReservation = currentReservation;
        this.occupied = (currentReservation != null);
    }

    public void deallocateRoom(Reservation reservation) {
        if (this.currentReservation != null && this.currentReservation.equals(reservation)) {
            this.currentReservation = null;
            this.occupied = false;
            System.out.println("Room " + this.number + " deallocated from reservation " + reservation.getNumber() + ".");
        } else {
            System.out.println("Warning: Room " + this.number + " was not allocated to reservation " + (reservation != null ? reservation.getNumber() : "null") + ". No action taken.");
        }
    }
}
