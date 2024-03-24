package edu.java.bot.configuration;

import java.util.List;

public interface LinkService {
    Link add(Link link);

    void remove(Long id);

    List<Link> listAll();
}
