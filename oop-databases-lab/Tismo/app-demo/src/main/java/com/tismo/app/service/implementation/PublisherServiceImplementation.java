package com.tismo.app.service.implementation;

import com.tismo.app.entity.Publisher;
import com.tismo.app.exception.PublisherNotFoundException;
import com.tismo.app.repository.PublisherRepository;
import com.tismo.app.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImplementation implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImplementation(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException("Publisher not found"));
    }

    @Override
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}