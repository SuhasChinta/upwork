package com.upwork.upwork.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client_profile")
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private User client;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = true)
    private String contactDetails;

    @Column(nullable = true)
    private Integer teamMembers;

    @Column(nullable = true)
    private String description;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Integer getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Integer teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
