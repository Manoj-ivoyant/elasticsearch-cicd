package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.DateOfBirth;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DateOfBirthRepository extends ElasticsearchRepository<DateOfBirth,Integer> {
}
