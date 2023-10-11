package com.simplon.dvdstore.controllers.auth;

import com.simplon.dvdstore.exceptions.AccountExistsException;
import com.simplon.dvdstore.exceptions.UnauthorizedException;
import com.simplon.dvdstore.services.users.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Security controller.
 */
@RestController

public class SecurityController {
    @Autowired
    private JwtUserService userService;


    /**
     * Register response entity.
     *
     * @param dto the dto
     * @return the response entity
     * @throws AccountExistsException the account exists exception
     */
// Ajouter un nouvel utilisateur et génère un JWT à la volée
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody AuthRequestDto dto) throws AccountExistsException {
        UserDetails user = userService.save(dto.getUsername(),
                dto.getPassword());
        String token = userService.generateJwtForUser(user);
        return ResponseEntity.ok(new AuthResponseDto(user,token));
    }


    /**
     * Authorize response entity.
     *
     * @param requestDto the request dto
     * @return the response entity
     * @throws UnauthorizedException the unauthorized exception
     */
// Authentifie le principal (le user) à partir du JWT.
    @PostMapping("/authorize")
    public ResponseEntity<AuthResponseDto> authorize(@RequestBody AuthRequestDto
                                                          requestDto) throws UnauthorizedException {
        Authentication authentication = null;
        try {
            authentication = userService.authenticate(requestDto.getUsername(),
                    requestDto.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
// Token generation
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(user);
            return ResponseEntity.ok(new AuthResponseDto(user, token));
        } catch(AuthenticationException e) {
            throw new UnauthorizedException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


