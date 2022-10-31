import java.util.Arrays;

public class TicketManager {

    private TicketRepository repository;
    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketData ticket) {
        repository.add(ticket);
    }

    public TicketData[] findAll(String airportDeparture, String airportArrival) {
        TicketData[] result = new TicketData[0];
        for (TicketData ticket: repository.findAll()) {
            if (matches(ticket, airportDeparture, airportArrival)) {
                TicketData[] temp = new TicketData[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    temp[i] = result[i];
                }
                temp[temp.length - 1] = ticket;
                result = temp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(TicketData ticket, String airportDeparture, String airportArrival) {
        if (ticket.getAirportDeparture().equals(airportDeparture)) {
            if (ticket.getAirportArrival().equals(airportArrival)) {
                return true;
            }
        }
        return false;
    }
}
