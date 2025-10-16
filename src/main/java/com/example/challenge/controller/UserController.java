package com.example.challenge.controller;

import com.example.challenge.model.User;
import com.example.challenge.service.user.impl.UserService;
import com.example.challenge.service.user.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService service;
    private final CreateUserService createUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final GetUserService getUserService;
    private final ListUserService listUserService;
    public UserController(UserService service,
                          CreateUserService createUserService,
                          UpdateUserService updateUserService,
                          DeleteUserService deleteUserService,
                          GetUserService getUserService,
                          ListUserService listUserService
    ) {
        this.service = service;
        this.createUserService = createUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.getUserService = getUserService;
        this.listUserService = listUserService;
    }

    @GetMapping
    public List<User> all() {
        return this.listUserService.run();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return this.getUserService.run(new GetUserService.Model(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return createUserService.run(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
        return updateUserService.run(new UpdateUserService.Model(user,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return deleteUserService.run(new DeleteUserService.Model(id));
    }
}
