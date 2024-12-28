package com.upwork.upwork.services;

import com.upwork.upwork.model.FreelancerProfile;
import com.upwork.upwork.model.ClientProfile;
import com.upwork.upwork.model.User;
import com.upwork.upwork.repository.FreelancerProfileRepository;
import com.upwork.upwork.repository.ClientProfileRepository;
import com.upwork.upwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private FreelancerProfileRepository freelancerProfileRepository;

    @Autowired
    private ClientProfileRepository clientProfileRepository;

    @Autowired
    private UserRepository userRepository;  // You need to use UserRepository to get the User by email

    // Create or update Freelancer Profile
    public FreelancerProfile saveFreelancerProfile(FreelancerProfile profile) {
        return freelancerProfileRepository.save(profile);
    }

    // Create or update Client Profile
    public ClientProfile saveClientProfile(ClientProfile profile) {
        return clientProfileRepository.save(profile);
    }

    // Get Freelancer Profile by email
    public FreelancerProfile getFreelancerProfile(String email) {
        // Fetch the User by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch the Freelancer Profile based on the User
        return freelancerProfileRepository.findByFreelancer(user);
    }

    // Get Client Profile by email
    public ClientProfile getClientProfile(String email) {
        // Fetch the User by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch the Client Profile based on the User
        return clientProfileRepository.findByClient(user);
    }
}
