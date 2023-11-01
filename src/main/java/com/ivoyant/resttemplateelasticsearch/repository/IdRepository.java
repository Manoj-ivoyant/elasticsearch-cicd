package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Id;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IdRepository extends ElasticsearchRepository<Id,Integer> {
}
