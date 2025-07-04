package com.sabeel.demo_sebeel.controller;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import com.sabeel.demo_sebeel.dto.UserDto;
import com.sabeel.demo_sebeel.dto.UserRegistrationDTO;
import com.sabeel.demo_sebeel.entity.User;
import com.sabeel.demo_sebeel.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Validated
@Tag(name = "User Controller", description = "APIs for user management")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Register a new user", description = "Register a new user with name, phone, national ID, etc.")
    @ApiResponse(responseCode = "200", description = "User registered successfully")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegistrationDTO dto) {
        userService.saveUser(dto);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/all")
    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of users retrieved"),
            @ApiResponse(responseCode = "404", description = "No users are found")
    })
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No users are found"));
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Provide an ID to lookup specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/by-status")
    @Operation(summary = "Get users by status", description = "Provide user status to filter users")
    @ApiResponse(responseCode = "200", description = "Users with given status retrieved")
    public ResponseEntity<List<User>> getUserByStatus(@RequestParam @Parameter(
            description = "User account status", example = "ACTIVE") UserStatus status) {
        return ResponseEntity.ok(userService.findByStatus(status).orElse(Collections.emptyList()));    }

    @GetMapping("/by-phone-number")
    @Operation(summary = "Get user by phone number", description = "Provide user phone number to filter users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with given phone number retrieved"),
            @ApiResponse(responseCode = "404", description = "User with given phone number is not found")
    })
    public ResponseEntity<User> getUserByPhoneNumber(@RequestParam String phoneNumber) {
        User user = userService.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with given phone number is not found"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/by-national-id")
    @Operation(summary = "Get user by national id", description = "Provide user national id to filter users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with given national id retrieved"),
            @ApiResponse(responseCode = "404", description = "User with given national id is not found")
    })
    public ResponseEntity<User> getUserByNationalId(@RequestParam String nationalId) {
        User user = userService.findByNationalId(nationalId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with given national id is not found"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/by-name")
    @Operation(summary = "Get user by username", description = "Provide username to filter users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with given username retrieved"),
            @ApiResponse(responseCode = "404", description = "User with given username is not found")
    })
    public ResponseEntity<User> getUserByName(@RequestParam String name) {
        User user = userService.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with given username is not found"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<User> updateUserStatus(@PathVariable long id, @RequestBody @Parameter(
            description = "New status for the user", example = "SUSPENDED") UserStatus status) {
        return ResponseEntity.ok(userService.updateStatus(id, status));
    }

    @PutMapping("/update-user/{id}")
    @Operation(summary = "Update user information", description = "Update full user information by ID")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    public ResponseEntity<User> updateUser(@PathVariable long id, @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/delete-user/{id}")
    @Operation(summary = "Delete user", description = "Delete user by ID")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
