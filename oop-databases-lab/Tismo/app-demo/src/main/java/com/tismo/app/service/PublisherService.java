package com.tismo.app.service;

import com.tismo.app.entity.Publisher;
import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(Long id);
    void deletePublisher(Long id);
}