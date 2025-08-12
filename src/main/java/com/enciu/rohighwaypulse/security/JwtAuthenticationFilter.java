//package com.enciu.rohighwaypulse.security;
//
////import com.enciu.rohighwaypulse.service.UserService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
////@Component
////public class JwtAuthenticationFilter extends OncePerRequestFilter {
////
////    private final JwtUtil jwtUtil;
////
////    @Autowired
////    ApplicationContext context;
////    @Autowired
////    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
////        this.jwtUtil = jwtUtil;
////    }
////    @Override
////    protected void doFilterInternal(HttpServletRequest request,
////                                    HttpServletResponse response,
////                                    FilterChain filterChain) throws ServletException, IOException {
////        final String authHeader = request.getHeader("Authorization");
////
////        String username = null;
////        String jwt = null;
////
////        if (authHeader != null && authHeader.startsWith("Bearer ")) {
////            jwt = authHeader.substring(7);
////            username = jwtUtil.extractUsername(jwt);
////        }
////
////        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
////            UserDetails userDetails = context.getBean(UserService.class).loadUserByUsername(username);
////
////            if (jwtUtil.isTokenValid(jwt, userDetails)) {
////                UsernamePasswordAuthenticationToken token =
////                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
////
////                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////                SecurityContextHolder.getContext().setAuthentication(token);
////            }
////        }
////
////        filterChain.doFilter(request, response);
////    }
////}
