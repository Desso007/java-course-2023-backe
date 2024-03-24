package edu.java.bot.domain.repository;

import edu.java.bot.configuration.Link;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

public interface LinkDao {
    @Transactional Link add(Link link);

    @Transactional Link remove(long id);

    @Transactional(readOnly = true) Collection<Link> findAll();
}
