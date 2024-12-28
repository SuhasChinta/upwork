package com.upwork.upwork.repository;

import com.upwork.upwork.model.ClientProfile;
import com.upwork.upwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {

    ClientProfile findByClient(User client);
}
