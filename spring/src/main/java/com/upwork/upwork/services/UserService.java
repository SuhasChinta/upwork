package com.upwork.upwork.services;

import com.upwork.upwork.dto.ProfileDTO;
import com.upwork.upwork.dto.UserDTO;
import com.upwork.upwork.model.ClientProfile;
import com.upwork.upwork.model.FreelancerProfile;
import com.upwork.upwork.model.User;
import com.upwork.upwork.repository.ClientProfileRepository;
import com.upwork.upwork.repository.FreelancerProfileRepository;
import com.upwork.upwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FreelancerProfileRepository freelancerProfileRepository;

    @Autowired
    private ClientProfileRepository clientProfileRepository;

    public void registerUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        userRepository.save(user);

        if ("freelancer".equals(userDTO.getRole())) {
            FreelancerProfile profile = new FreelancerProfile();
            profile.setFreelancer(user);
            freelancerProfileRepository.save(profile);
        } else if ("client".equals(userDTO.getRole())) {
            ClientProfile profile = new ClientProfile();
            profile.setClient(user);
            clientProfileRepository.save(profile);
        }
    }

    public ProfileDTO getUserProfile(String email) {
        // Fetch the User by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setEmail(user.getEmail());
        profileDTO.setName(user.getName());
        profileDTO.setRole(user.getRole());

        // Fetch the profile based on the role
        if ("freelancer".equals(user.getRole())) {
            FreelancerProfile profile = freelancerProfileRepository.findByFreelancer(user);
            if (profile == null) {
                throw new RuntimeException("Freelancer profile not found");
            }
            profileDTO.setFreelancerProfile(profile);
        } else if ("client".equals(user.getRole())) {
            ClientProfile profile = clientProfileRepository.findByClient(user);
            if (profile == null) {
                throw new RuntimeException("Client profile not found");
            }
            profileDTO.setClientProfile(profile);
        }

        return profileDTO;
    }

    public void updateUserProfile(ProfileDTO profileDTO) {
        // Fetch the User by email
        User user = userRepository.findByEmail(profileDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update user name
        user.setName(profileDTO.getName());
        userRepository.save(user);

        // Update the profile based on the role
        if ("freelancer".equals(profileDTO.getRole())) {
            FreelancerProfile profile = profileDTO.getFreelancerProfile();
            profile.setFreelancer(user);
            freelancerProfileRepository.save(profile);
        } else if ("client".equals(profileDTO.getRole())) {
            ClientProfile profile = profileDTO.getClientProfile();
            profile.setClient(user);
            clientProfileRepository.save(profile);
        }
    }
}
