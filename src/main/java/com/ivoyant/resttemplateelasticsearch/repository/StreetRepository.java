package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Street;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StreetRepository extends ElasticsearchRepository<Street,Integer> {
}
