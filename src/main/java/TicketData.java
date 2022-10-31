import java.util.Comparator;

public class TicketData implements Comparable<TicketData> {

    protected int id;
    protected int cost;
    protected String airportDeparture;
    protected String airportArrival;

    public TicketData(int id, int cost, String airportDeparture, String airportArrival) {
        this.id = id;
        this.cost = cost;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    @Override
    public int compareTo(TicketData o) {
        return this.cost - o.getCost();
    }
}
