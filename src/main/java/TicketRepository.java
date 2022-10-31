public class TicketRepository {
    private TicketData[] tickets = new TicketData[0];

    public TicketData[] findAll() {
        return tickets;
    }

    public void add(TicketData ticket) {
        TicketData[] temp = new TicketData[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            temp[i] = tickets[i];
        }
        temp[temp.length - 1] = ticket;
        tickets = temp;
    }

    public void removeById(int removeId) {
        TicketData[] temp = new TicketData[tickets.length - 1];
        int index = 0;
        for (TicketData ticket : tickets) {
            if (ticket.getId() != removeId) {
                temp[index] = ticket;
            }
        }
        tickets = temp;
    }
}
