package com.simplon.dvdstore.services.users;


import com.simplon.dvdstore.exceptions.AccountExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * The interface User service.
 */
public interface UserService extends UserDetailsService {
    /**
     * Authenticate authentication.
     *
     * @param username the username
     * @param password the password
     * @return the authentication
     * @throws Exception the exception
     */
    Authentication authenticate(String username, String password) throws Exception;

    /**
     * Save user details.
     *
     * @param username the username
     * @param password the password
     * @return the user details
     * @throws AccountExistsException the account exists exception
     */
    UserDetails save(String username, String password) throws AccountExistsException;
}
//Remarque : Permet de découpler les couches