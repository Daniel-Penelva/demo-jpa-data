package com.api.demo_jpa_data.services;

import com.api.demo_jpa_data.dtos.PublisherRecordDto;
import com.api.demo_jpa_data.models.PublisherModel;
import com.api.demo_jpa_data.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public PublisherModel savePublisher(PublisherRecordDto publisherRecordDto) {

        PublisherModel publisherModel = new PublisherModel();
        publisherModel.setName(publisherRecordDto.name());

        return publisherRepository.save(publisherModel);
    }

    public List<PublisherModel> getAllPublisher() {
        return publisherRepository.findAll();
    }
}
