package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Registered;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RegisteredRepository extends ElasticsearchRepository<Registered,Integer> {
}
