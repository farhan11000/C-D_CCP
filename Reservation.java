public class Reservation {
    private int number;
    private String reservationDate;
    private String startDate;
    private String endDate;
    private ReserverPayer reserverPayer;
    private Room allocatedRoom;

    public Reservation(int number, String reservationDate, String startDate, String endDate, ReserverPayer reserverPayer, Room allocatedRoom) {
        this.number = number;
        this.reservationDate = reservationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reserverPayer = reserverPayer;
        this.allocatedRoom = allocatedRoom;
    }

    public int getNumber() {
        return number;
    }

    public ReserverPayer getReserverPayer() {
        return reserverPayer;
    }

    public Room getAllocatedRoom() {
        return allocatedRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}
