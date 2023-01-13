package com.app.repository;

import com.app.model.PalindromeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author prabh
 * @apiNote JPARepository to store palindrome details
 */
@Repository
public interface PalindromeDetailsRepository extends JpaRepository<PalindromeDetails, String> {

}
