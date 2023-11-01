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
@Document(indexName = "person")
public class Person implements Serializable {
    @org.springframework.data.annotation.Id
    @Field(type = FieldType.Auto)
    private Integer key;
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private DateOfBirth dob;
    private Registered registered;
    private String phone;
    private String cell;
    private Id id1;
    private Picture picture;
    private String nat;
}
