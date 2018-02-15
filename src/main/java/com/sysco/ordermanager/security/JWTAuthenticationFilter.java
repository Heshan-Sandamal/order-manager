package com.sysco.ordermanager.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.web.api.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.sysco.ordermanager.security.SecurityConstants.EXPIRATION_TIME;
import static com.sysco.ordermanager.security.SecurityConstants.HEADER_STRING;
import static com.sysco.ordermanager.security.SecurityConstants.SECRET;
import static com.sysco.ordermanager.security.SecurityConstants.TOKEN_PREFIX;



public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/users/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            UserData creds = new ObjectMapper().readValue(request.getInputStream(),UserData.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getName(),
                            creds.getPassword(),
                            new ArrayList<>()
                    )
            );

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((User)authResult.getPrincipal()).getUsername()) // User name = user id here.
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512,SECRET.getBytes())
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}