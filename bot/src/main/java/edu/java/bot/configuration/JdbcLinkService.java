package edu.java.bot.configuration;

import java.util.List;

public class JdbcLinkService implements LinkService {
    public JdbcLinkService(JdbcLinkRepository linkRepository) {
    }

    @Override
    public Link add(Link link) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Link> listAll() {
        return null;
    }
}
