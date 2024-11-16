package com.jash.SpringBootRest.controller;

import com.jash.SpringBootRest.model.JobPost;
import com.jash.SpringBootRest.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    JobPostService jobPostService;

    @GetMapping("/jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        System.out.println("Inside get all jobs");
        return jobPostService.getAllJobs();
    }
}
