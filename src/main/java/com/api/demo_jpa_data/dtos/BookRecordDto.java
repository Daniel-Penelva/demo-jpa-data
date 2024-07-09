package com.api.demo_jpa_data.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title, Long publisher_id, Set<Long> authorIds, String reviewComment) {
}
