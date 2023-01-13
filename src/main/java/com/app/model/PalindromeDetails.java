package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author prabh
 * @implNote This is an entity which is being will be persisted in the data store.
 * The getters and setters for the variables are auto handled with @Data annotation.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PalindromeDetails implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    private String inputString;

    private boolean isPalindrome;

}
