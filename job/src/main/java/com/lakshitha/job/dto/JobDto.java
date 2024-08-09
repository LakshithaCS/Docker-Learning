package com.lakshitha.job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class JobDto {
    private String id;
    private String company;
    private String description;
    private Set<String> skills;
    private Integer salary;
    private Boolean isRemote;
}
