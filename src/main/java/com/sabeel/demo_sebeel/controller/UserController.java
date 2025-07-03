package com.sabeel.demo_sebeel.controller;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import com.sabeel.demo_sebeel.dto.UserDto;
import com.sabeel.demo_sebeel.dto.UserRegistrationDTO;
import com.sabeel.demo_sebeel.entity.User;
import com.sabeel.demo_sebeel.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegistrationDTO dto) {
        userService.saveUser(dto);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/by-status")
    public ResponseEntity<Optional<List<User>>> getUserByStatus(@RequestParam UserStatus status) {
        return ResponseEntity.ok(userService.findByStatus(status));
    }

    @GetMapping("/by-phone-number")
    public ResponseEntity<Optional<User>> getUserByPhoneNumber(@RequestParam String phoneNumber) {
        return ResponseEntity.ok(userService.findByPhoneNumber(phoneNumber));
    }

    @GetMapping("/by-national-id")
    public ResponseEntity<Optional<User>> getUserByNationalId(@RequestParam String nationalId) {
        return ResponseEntity.ok(userService.findByNationalId(nationalId));
    }

    @GetMapping("/by-name")
    public ResponseEntity<Optional<User>> getUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.findByName(name));
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<User> updateUserStatus(@PathVariable long id, @RequestBody UserStatus status) {
        return ResponseEntity.ok(userService.updateStatus(id, status));
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }



}
