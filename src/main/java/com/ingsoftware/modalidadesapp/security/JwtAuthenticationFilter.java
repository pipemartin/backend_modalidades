package com.ingsoftware.modalidadesapp.security;

import com.ingsoftware.modalidadesapp.Services.UserDetailsServiceImpl;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.lang.NonNull;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter  {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtil;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().contains("/api/user/authentication")) {
            filterChain.doFilter(request, response);
            return;
        }if (request.getServletPath().contains("/api/user/register")) {
            filterChain.doFilter(request, response);
            return;
        }if (request.getServletPath().contains("/api/user/update")) {
            filterChain.doFilter(request, response);
            return;
        }
        String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            System.out.println("SI entra al if de Bearer");
            jwtToken = requestTokenHeader.substring(7);
            try{
                username = this.jwtUtil.extractUsername(jwtToken);
            }catch (ExpiredJwtException exception){
                System.out.println("El token ha expirado");
                return;
            }catch (Exception e){
                System.out.println("El token no es valido");
                return;
            }
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(this.jwtUtil.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else{
            System.out.println("El token no es valido");
        }
        filterChain.doFilter(request,response);
    }
}

