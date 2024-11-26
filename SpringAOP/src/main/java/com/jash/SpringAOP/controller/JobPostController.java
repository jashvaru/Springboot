package com.jash.SpringAOP.controller;

import com.jash.SpringAOP.model.JobPost;
import com.jash.SpringAOP.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/job/{postId}")
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

    @GetMapping("/load")
    public String loadJobPosts() {
        jobPostService.loadAll();
        return "success";
    }

    @GetMapping("/search/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return jobPostService.searchByKeyword(keyword);

    }
}
