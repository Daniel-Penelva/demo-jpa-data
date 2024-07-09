package com.api.demo_jpa_data.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title, UUID publisher_id, Set<UUID> authorIds, String reviewComment) {
}
