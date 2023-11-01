package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LocationRepository extends ElasticsearchRepository<Location,Integer> {
}
