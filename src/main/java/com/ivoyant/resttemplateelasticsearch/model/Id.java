package com.ivoyant.resttemplateelasticsearch.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "id")
public class Id implements Serializable {
    @org.springframework.data.annotation.Id
    @Field(type = FieldType.Auto)
    private Integer key;
    private String name;
    private String value;
}
