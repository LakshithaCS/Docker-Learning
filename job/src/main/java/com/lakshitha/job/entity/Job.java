package com.lakshitha.job.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class Job {

    @Id
    private String id;
    private String company;
    private String description;
    private Set<String> skills;
    private Integer salary;
    private Boolean isRemote;
}
