package com.ivoyant.resttemplateelasticsearch.service.impl;

import com.ivoyant.resttemplateelasticsearch.model.ApiResponse;
import com.ivoyant.resttemplateelasticsearch.model.Id;
import com.ivoyant.resttemplateelasticsearch.model.Person;
import com.ivoyant.resttemplateelasticsearch.repository.*;
import com.ivoyant.resttemplateelasticsearch.service.RestTemplateService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("dev")
public class RestTemplateServiceImpl implements RestTemplateService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ApiResponseRepository apiResponseRepository;

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Autowired
    private DateOfBirthRepository dateOfBirthRepository;

    @Autowired
    private IdRepository idRepository;

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private NameRepository nameRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private RegisteredRepository registeredRepository;

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private TimeZoneRepository timeZoneRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getFromApi() {
        String url = "https://randomuser.me/api";
        ApiResponse apiResponse = restTemplate.getForObject(url, ApiResponse.class);
        List<Person> personList = apiResponse.getResults();
        personList.forEach(person -> {
            if (person.getId1() == null) {
                // Create a default Id object with empty name and null value
                Id defaultId = Id.builder().name("").value(null).build();
                person.setId1(defaultId);
                idRepository.save(defaultId);
            }
        });
        personRepository.saveAll(personList);
        personList.forEach(i -> {
            nameRepository.save(i.getName());
            locationRepository.save(i.getLocation());
            streetRepository.save(i.getLocation().getStreet());
            coordinatesRepository.save(i.getLocation().getCoordinates());
            timeZoneRepository.save(i.getLocation().getTimezone());
            loginRepository.save(i.getLogin());
            dateOfBirthRepository.save(i.getDob());
            registeredRepository.save(i.getRegistered());
            pictureRepository.save(i.getPicture());
        });
        infoRepository.save(apiResponse.getInfo());
        apiResponseRepository.save(apiResponse);
        return "success";
    }

    public List<String> wildCardQuerying(String index, String searchKey) {
        List<String> strings = new ArrayList<>();
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.queryStringQuery("*" + searchKey + "*"));
            sourceBuilder.size(10000);
            SearchRequest searchRequest = new SearchRequest(index);
            searchRequest.source(sourceBuilder);
            SearchHits searchHits = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT).getHits();
            for (SearchHit hit : searchHits) {
                if (hit != null) {
                    strings.add(hit.getSourceAsString());
                } else {
                    logger.info("No data present for{}", index);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return strings;
    }

    //match query which is more precise than wild card, and it performs full text search
    //also it provides ignorecase searching
    public List<String> getByMatchQuery(String field, String value) {
        List<String> strings = new ArrayList<>();
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            SearchRequest searchRequest = new SearchRequest();
            MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(field, value);
            sourceBuilder.query(matchQueryBuilder);
            searchRequest.source(sourceBuilder);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            for (SearchHit hit : hits.getHits()) {
                strings.add(hit.getSourceAsString());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return strings;
    }

    //it performs searching for exactly matched values
    //case-sensitive
    public List<String> getByTermQuery(String field, String value) {
        List<String> strings1 = new ArrayList<>();
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            SearchRequest searchRequest = new SearchRequest();
            TermQueryBuilder termQueryBuilder= QueryBuilders.termQuery(field, value);
            sourceBuilder.query(termQueryBuilder);
            searchRequest.source(sourceBuilder);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            for (SearchHit hit : hits.getHits()) {
                strings1.add(hit.getSourceAsString());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return strings1;
    }

}
