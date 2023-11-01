package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Timezone;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TimeZoneRepository extends ElasticsearchRepository<Timezone, Integer> {
}
