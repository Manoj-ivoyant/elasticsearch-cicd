package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Name;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NameRepository extends ElasticsearchRepository<Name,Integer> {
}
