package com.ivoyant.resttemplateelasticsearch.controller;

import com.ivoyant.resttemplateelasticsearch.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping
    public ResponseEntity<String> getFromPublicApi() {
        return ResponseEntity.ok().body(restTemplateService.getFromApi());
    }

    @GetMapping("/search")
    public List<String> getByWildCardSearch(@RequestParam String index, @RequestParam String searchKey) {
        return restTemplateService.wildCardQuerying(index, searchKey);
    }

    @GetMapping("/searchByMatchQuery")
    public List<String> getByMatchingQuery(@RequestParam String field,@RequestParam String value){
        return restTemplateService.getByMatchQuery(field,value);
    }

    @GetMapping("/searchByTermQuery")
    public List<String> getByTermingQuery(@RequestParam String field,@RequestParam String value){
        return restTemplateService.getByTermQuery(field,value);
    }
}
