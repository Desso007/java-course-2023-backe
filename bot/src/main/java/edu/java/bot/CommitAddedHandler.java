import edu.java.bot.BotClient;

public class CommitAddedHandler {

    private BotClient botClient;

    public CommitAddedHandler(BotClient botClient) {
        this.botClient = botClient;
    }

    public void handleCommitAdded(String commitId) {

        botClient.sendNotification("New commit added: " + commitId);
    }
}
