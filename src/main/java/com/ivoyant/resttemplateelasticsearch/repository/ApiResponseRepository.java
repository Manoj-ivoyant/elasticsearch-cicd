package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.ApiResponse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ApiResponseRepository extends ElasticsearchRepository<ApiResponse,Integer> {
}
