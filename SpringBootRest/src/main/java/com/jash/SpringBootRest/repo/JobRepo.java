package com.jash.SpringBootRest.repo;

import com.jash.SpringBootRest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobPosts = new ArrayList<>();

    public JobRepo() {
        jobPosts.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        // Frontend Developer Job Post
        jobPosts.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));
    }

    public void addJob(JobPost jobPost) {
        jobPosts.add(jobPost);
    }

    public List<JobPost> getAllJobPost() {
        return jobPosts;
    }

    public void deleteJobPost(int postId) {
        jobPosts.removeIf(jp -> postId == jp.getPostId());
    }

    public void updateJobPost(JobPost jobPost) {
        for (JobPost jp : jobPosts) {
            if(jobPost.getPostId() == jp.getPostId()) {
                jp.setPostProfile(jobPost.getPostProfile());
            }
        }
    }

    public JobPost getJobPost(int postId) {
        for(JobPost jobPost : jobPosts) {
            if(postId == jobPost.getPostId())
                return jobPost;
        }
        return null;
    }
}
