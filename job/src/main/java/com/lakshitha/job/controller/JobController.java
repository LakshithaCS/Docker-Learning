package com.lakshitha.job.controller;

import com.lakshitha.job.dto.JobDto;
import com.lakshitha.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("all")
    public Flux<JobDto> getAllJobs() {
        return jobService.findAllJobs();
    }

    @GetMapping("search")
    public Flux<JobDto> searchJobs(@RequestParam Set<String> skills) {
        return jobService.findJobsBySkillsIn(skills);
    }

    @PostMapping("save")
    public Mono<JobDto> saveJob(@RequestBody Mono<JobDto> jobDto) { //Mono for single item
        return jobService.saveJob(jobDto);
    }
}
