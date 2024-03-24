package com.example.domain.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Collection;

@Service
public class DefaultLinkService implements LinkService {

    private final LinkDao linkDao;

    public DefaultLinkService(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public Link add(URI url) {
        return null;
    }

    @Override
    public Link remove(long id) {
        return null;
    }

    @Override
    public Collection<Link> listAll() {
        return null;
    }
}
