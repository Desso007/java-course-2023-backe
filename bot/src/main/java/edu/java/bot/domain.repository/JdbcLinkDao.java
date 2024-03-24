package edu.java.bot.domain.repository;

import edu.java.bot.configuration.Link;
import java.util.Collection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcLinkDao implements LinkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLinkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Link add(Link link) {
        return null;
    }

    @Override
    @Transactional
    public Link remove(long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Link> findAll() {
        return null;
    }
}
