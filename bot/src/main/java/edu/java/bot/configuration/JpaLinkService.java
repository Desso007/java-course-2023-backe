package edu.java.bot.configuration;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JpaLinkService implements LinkService {

    private final JpaLinkRepository linkRepository;

    public JpaLinkService(JpaLinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Link add(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public void remove(Long id) {
        linkRepository.deleteById(id);
    }

    @Override
    public List<Link> listAll() {
        return linkRepository.findAll();
    }
}
