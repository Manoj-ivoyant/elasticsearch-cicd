package com.ivoyant.resttemplateelasticsearch.service;

import java.util.List;

public interface RestTemplateService {
    String getFromApi();

    List<String> wildCardQuerying(String index, String searchKey);

    List<String> getByMatchQuery(String field, String value);

    List<String> getByTermQuery(String field, String value);
}
