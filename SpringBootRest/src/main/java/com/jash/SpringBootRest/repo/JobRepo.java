package com.jash.SpringBootRest.repo;

import com.jash.SpringBootRest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContaining(String keyword);
}

/*
List<JobPost> jobPosts = new ArrayList<>();

    public JobRepo() {
        jobPosts.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        // Frontend Developer Job Post
        jobPosts.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));
    }
* */
