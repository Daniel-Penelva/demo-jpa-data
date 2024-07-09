package com.api.demo_jpa_data.services;

import com.api.demo_jpa_data.dtos.AuthorRecordDto;
import com.api.demo_jpa_data.models.AuthorModel;
import com.api.demo_jpa_data.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public AuthorModel saveAuthor(AuthorRecordDto authorRecordDto) {
        AuthorModel authorModel = new AuthorModel();
        authorModel.setName(authorRecordDto.name());

        return authorRepository.save(authorModel);
    }

    public List<AuthorModel> getAllAuthor() {
        return authorRepository.findAll();
    }
}
