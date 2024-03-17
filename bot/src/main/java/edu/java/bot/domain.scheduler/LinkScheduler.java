package edu.java.bot;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinkUpdaterImpl implements LinkUpdater {

    private final LinkRepository linkRepository;

    public LinkUpdaterImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public int update() {
        List<Link> outdatedLinks = linkRepository.findOutdatedLinks();
        int updatedCount = 0;
        for (Link link : outdatedLinks) {
            boolean hasUpdate = checkForUpdate(link);
            if (hasUpdate) {
                updatedCount++;
                notifyBot(link);
            }
        }
        return updatedCount;
    }

    private boolean checkForUpdate(Link link) {

        return false;
    }

    private void notifyBot(Link link) {

    }
}
