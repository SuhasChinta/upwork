package com.upwork.upwork.controller;

import com.upwork.upwork.model.FreelancerProfile;
import com.upwork.upwork.model.ClientProfile;
import com.upwork.upwork.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Create or Update Freelancer Profile
    @PostMapping("/freelancer")
    public FreelancerProfile createOrUpdateFreelancerProfile(@RequestBody FreelancerProfile profile) {
        return profileService.saveFreelancerProfile(profile);
    }

    // Create or Update Client Profile
    @PostMapping("/client")
    public ClientProfile createOrUpdateClientProfile(@RequestBody ClientProfile profile) {
        return profileService.saveClientProfile(profile);
    }

    // Get Freelancer Profile by email
    @GetMapping("/freelancer/{email}")
    public FreelancerProfile getFreelancerProfile(@PathVariable String email) {
        return profileService.getFreelancerProfile(email);
    }

    // Get Client Profile by email
    @GetMapping("/client/{email}")
    public ClientProfile getClientProfile(@PathVariable String email) {
        return profileService.getClientProfile(email);
    }
}
