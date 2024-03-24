import edu.java.bot.BotClient;

public class TicketUpdatedHandler {

    private BotClient botClient;

    public TicketUpdatedHandler(BotClient botClient) {
        this.botClient = botClient;
    }

    public void handleTicketUpdated(String ticketId) {

        botClient.sendNotification("Ticket updated: " + ticketId);
    }
}
