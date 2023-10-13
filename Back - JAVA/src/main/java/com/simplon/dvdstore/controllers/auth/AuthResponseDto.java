package com.simplon.dvdstore.controllers.auth;


import org.springframework.security.core.userdetails.UserDetails;

/**
 * The type Auth response dto.
 */
public class AuthResponseDto {
    private UserDetails user;
    private String token;

    /**
     * Instantiates a new Auth response dto.
     *
     * @param user  the user
     * @param token the token
     */
    public AuthResponseDto(UserDetails user, String token) {
        this.user = user;
        this.token = token;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public UserDetails getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(UserDetails user) {
        this.user = user;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
