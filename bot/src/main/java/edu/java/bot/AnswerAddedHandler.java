import edu.java.bot.BotClient;

public class AnswerAddedHandler {

    private BotClient botClient;

    public AnswerAddedHandler(BotClient botClient) {
        this.botClient = botClient;
    }

    public void handleAnswerAdded(String questionId) {

        botClient.sendNotification("New answer added to question: " + questionId);
    }
}
