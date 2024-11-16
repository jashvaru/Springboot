package com.jash.SpringBootRest.service;

import com.jash.SpringBootRest.model.JobPost;
import com.jash.SpringBootRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {

    @Autowired
    JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobPost();
    }

    public JobPost getJobPost(int postId) {
        return jobRepo.getJobPost(postId);
    }

    public void updateJobPost(JobPost jobPost) {
        jobRepo.updateJobPost(jobPost);
    }

    public void deleteJobPost(int postId) {
        jobRepo.deleteJobPost(postId);
    }
}
