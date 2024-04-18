package com.example.springjwtcustom.controller;

import com.example.springjwtcustom.entity.UserInfo;
import com.example.springjwtcustom.entity.AuthRequest;
import com.example.springjwtcustom.service.JwtService;
import com.example.springjwtcustom.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtservice;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @GetMapping("/welcome")
//    public String welcome(){
//        return "This is welcome page endpoint";
//    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

   @GetMapping("/user/userProfile")
   
   public String userProfile(){
       return "WElcome to the profile, user";
   }
////    @GetMapping("/admin/adminProfile")
////    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String adminProfile(){
//        return "Welcome to the profile, Admin";
////    }
//    @GetMapping("/places/placesMain")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String getPlaces() {
//        return "Places";
//    }
//    @GetMapping("/categories/categoriesMain")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String getCategories() {
//        return "Categories";
//    }
//    @GetMapping("/groups/groupsMain")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String getGroups() {
//        return "Groups";
//    }
//
    

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtservice.generateToken(authRequest.getUsername());

        }
        else{
            throw new UsernameNotFoundException("Invalid User Request");
        }
    }


}
