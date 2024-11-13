package com.jash.JobApp.controller;

import com.jash.JobApp.model.JobPost;
import com.jash.JobApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobPostController {

    @Autowired
    JobPostService jobPostService;

    @GetMapping({"/", "/home"})
    public String home() {
        System.out.println("Inside home");
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String addJob(JobPost jobPost) {
        System.out.println("Inside handle form");
        jobPostService.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model m) {
        System.out.println("Inside view all jobs");
        List<JobPost> jobPosts = jobPostService.getAllJobs();
        m.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }
}
