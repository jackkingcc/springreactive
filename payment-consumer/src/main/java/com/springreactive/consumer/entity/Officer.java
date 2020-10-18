package com.springreactive.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Officer {
    public Officer(Rank rank,String firstname,String lastname){
        this.rank = rank;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    private String id;
    private Rank rank;
    private String firstname;
    private String lastname;
}
