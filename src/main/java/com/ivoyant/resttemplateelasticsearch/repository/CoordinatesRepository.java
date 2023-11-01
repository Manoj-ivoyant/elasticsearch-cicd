package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Coordinates;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CoordinatesRepository extends ElasticsearchRepository<Coordinates, Integer> {
}
