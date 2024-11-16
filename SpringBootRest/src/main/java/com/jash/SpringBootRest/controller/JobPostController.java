package com.jash.SpringBootRest.controller;

import com.jash.SpringBootRest.model.JobPost;
import com.jash.SpringBootRest.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    JobPost jobPost;

    @Autowired
    JobPostService jobPostService;

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        System.out.println("Inside get all jobs");
        return jobPostService.getAllJobs();
    }

    @GetMapping(value = "/job/{postId}", produces = "application/xml")
    public JobPost getJobPost(@PathVariable("postId") int postId){
        System.out.println("Get Job using ID");
        return jobPostService.getJobPost(postId);
    }

    @PostMapping(value = "/addJob")
    public List<JobPost> addJobPost(@RequestBody JobPost jobPost) {
        System.out.println("Adding job post");
        jobPostService.addJob(jobPost);
        return jobPostService.getAllJobs();
    }

    @PutMapping(value = "/jobPosts")
    public List<JobPost> updateJobPost(@RequestBody JobPost jobPost) {
        System.out.println("Updating job post");
        jobPostService.updateJobPost(jobPost);
        return jobPostService.getAllJobs();
    }

    @DeleteMapping(value = "/jobPosts/{postId}")
    public List<JobPost> deleteJobPost(@PathVariable int postId) {
        System.out.println("Deleting job post");
        jobPostService.deleteJobPost(postId);
        return jobPostService.getAllJobs();
    }

}
