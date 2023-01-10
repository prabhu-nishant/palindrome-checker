package com.app.repository;

import com.app.model.PalindromeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author prabh
 * @implNote PalindromeDetailsRepository is a JpaRepository used for persisting data into database.
 */
@Repository
public interface PalindromeDetailsRepository extends JpaRepository<PalindromeDetails, String> {

}
