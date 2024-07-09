package com.api.demo_jpa_data.repositories;

import com.api.demo_jpa_data.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherModel, Long> {
}
