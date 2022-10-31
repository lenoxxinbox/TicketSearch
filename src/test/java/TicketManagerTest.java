import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketData ticket1 = new TicketData(1, 15, "Airport1", "Airport2");
    TicketData ticket2 = new TicketData(2, 20, "Airport2", "Airport1");
    TicketData ticket3 = new TicketData(3, 25, "Airport3", "Airport4");
    TicketData ticket4 = new TicketData(4, 30, "Airport4", "Airport3");
    TicketData ticket5 = new TicketData(5, 35, "Airport3", "Airport4");
    TicketData ticket6 = new TicketData(6, 40, "Airport3", "Airport1");
    TicketData ticket7 = new TicketData(7, 45, "Airport3", "Airport4");
    TicketData ticket8 = new TicketData(8, 25, "Airport3", "Airport4");
    TicketData ticket9 = new TicketData(9, 5, "Airport3", "Airport4");

    @Test
    public void testWhenFewTicketsMatchesSortedSorting() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        TicketData[] act = manager.findAll("Airport3", "Airport4");
        TicketData[] exp = {ticket3, ticket5, ticket7};

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testWhenManyTicketsMatchesMixedSorted() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        TicketData[] act = manager.findAll("Airport3", "Airport4");
        TicketData[] exp = {ticket9, ticket3, ticket8, ticket5, ticket7};

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testSearchZeroMatches() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        TicketData[] act = manager.findAll("Airport7", "Airport4");
        TicketData[] exp = {};

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testSearchAfterRemove() {
        manager.add(ticket1);
        manager.add(ticket2);
        repository.removeById(1);

        TicketData[] act = manager.findAll("Airport1", "Airport2");
        TicketData[] exp = {};

        Assertions.assertArrayEquals(exp, act);
    }
}
