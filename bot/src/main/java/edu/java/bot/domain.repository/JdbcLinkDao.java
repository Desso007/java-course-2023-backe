package com.example.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.Collection;

@Repository
public class JdbcLinkDao implements LinkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLinkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Link add(Link link) {-
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
