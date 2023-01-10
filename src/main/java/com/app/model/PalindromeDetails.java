package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
public class PalindromeDetails implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    private String inputString;

    private boolean isPalindrome;

}
