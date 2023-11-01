package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Login;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LoginRepository extends ElasticsearchRepository<Login,String> {
}
