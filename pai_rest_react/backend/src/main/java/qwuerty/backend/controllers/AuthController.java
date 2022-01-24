package qwuerty.backend.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qwuerty.backend.configs.jwt.JwtTokenUtil;
import qwuerty.backend.models.User;
import qwuerty.backend.models.jwt.JwtRequest;
import qwuerty.backend.models.jwt.JwtResponse;
import qwuerty.backend.services.UserService;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest)
            throws Exception {

        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        final User user = userService.getUserByUsername(jwtRequest.getUsername());
        System.out.println(jwtRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(user);
        System.out.println(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Valid
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @RequestBody JwtRequest jwtRequest) {

        User checkUser = userService.getUserByUsername(jwtRequest.getUsername());
        if(checkUser == null){

            User user = new User(jwtRequest.getUsername(), passwordEncoder.encode(jwtRequest.getPassword()), jwtRequest.getName(), jwtRequest.getSurname());
            userService.insertUser(user);

            return "Zarejestrowano użytkownika";
        }else{
            return "Użytkownik istnieje";
        }

    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
