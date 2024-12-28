package com.upwork.upwork.repository;

import com.upwork.upwork.model.FreelancerProfile;
import com.upwork.upwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerProfileRepository extends JpaRepository<FreelancerProfile, Long> {

    FreelancerProfile findByFreelancer(User freelancer);
}
