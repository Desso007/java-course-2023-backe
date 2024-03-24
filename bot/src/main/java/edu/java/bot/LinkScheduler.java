package edu.java.bot;

import org.springframework.stereotype.Component;

import java.util.List;

@Component class LinkUpdaterImpl implements LinkUpdater {

    @Override
    public int update(List<Object> outdatedLinks) {
        int updatedCount = 0;
        for (Object link : outdatedLinks) {
            boolean hasUpdate = checkForUpdate(link);
            if (hasUpdate) {
                updatedCount++;
                notifyBot(link);
            }
        }
        return updatedCount;
    }

    private boolean checkForUpdate(Object link) {
        // Реализуйте логику проверки наличия обновления для ссылки
        return false;
    }

    private void notifyBot(Object link) {
        // Реализуйте логику уведомления бота о обновлении ссылки
    }
}
