package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.project.dto.AuthRequest;
import com.project.dto.Product;
import com.project.entity.UserInfo;
import com.project.repository.UserInfoRepository;
import com.project.service.JwtService;
import com.project.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/signup")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }
    
    @GetMapping("/getAllUsers")
    public List<UserInfo> getAllUsers()
    {
    	return repository.findAll();
    }

    @GetMapping("/products/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }


    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
}
