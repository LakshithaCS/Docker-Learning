package com.lakshitha.job.service;

import com.lakshitha.job.dto.JobDto;
import com.lakshitha.job.entity.Job;
import com.lakshitha.job.repository.JobRepository;
import com.lakshitha.job.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Flux<JobDto> findAllJobs() {
        return jobRepository
                .findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Flux<JobDto> findJobsBySkillsIn(Set<String> skills) {
        return jobRepository
                .findBySkillsIn(skills)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<JobDto> saveJob(Mono<JobDto> jobDto) {
        return jobDto
                .map(EntityDtoUtil::toEntity)
                .flatMap(jobRepository::save)
                .map(EntityDtoUtil::toDto);
    }
}
