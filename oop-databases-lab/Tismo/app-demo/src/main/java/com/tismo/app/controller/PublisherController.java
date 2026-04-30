package com.tismo.app.controller;

import com.tismo.app.entity.Publisher;
import com.tismo.app.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherRepository.findById(id);
    }

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @PutMapping("/{id}")
    public Publisher updatePublisher(@PathVariable Long id, @RequestBody Publisher updatedPublisher) {
        return publisherRepository.findById(id).map(publisher -> {
            publisher.setPublisherName(updatedPublisher.getPublisherName());
            publisher.setAddress(updatedPublisher.getAddress());
            publisher.setContactNumber(updatedPublisher.getContactNumber());
            publisher.setEmail(updatedPublisher.getEmail());
            publisher.setCountry(updatedPublisher.getCountry());
            publisher.setFoundedYear(updatedPublisher.getFoundedYear());
            return publisherRepository.save(publisher);
        }).orElseThrow(() -> new RuntimeException("Publisher not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherRepository.deleteById(id);
        return "Publisher deleted successfully!";
    }
}