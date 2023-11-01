package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Info;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InfoRepository extends ElasticsearchRepository<Info,Integer> {
}
