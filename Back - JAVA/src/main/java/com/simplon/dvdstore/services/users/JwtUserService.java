package com.simplon.dvdstore.services.users;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * The interface Jwt user service.
 */
public interface JwtUserService extends UserService{
    /**
     * Generate jwt for user string.
     *
     * @param user the user
     * @return the string
     */
    String generateJwtForUser(UserDetails user);

    /**
     * Gets user from jwt.
     *
     * @param jwt the jwt
     * @return the user from jwt
     */
    UserDetails getUserFromJwt(String jwt);
}
//Remarque : Permet de découpler l'implémentation de la vérification utilisateur avec le JWT, peut-etre mocker dans
//les tests unitaires