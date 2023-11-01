package com.ivoyant.resttemplateelasticsearch.repository;

import com.ivoyant.resttemplateelasticsearch.model.Picture;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PictureRepository extends ElasticsearchRepository<Picture,Integer> {
}
