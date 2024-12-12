package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;


    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity){ // 원래는Entity를 controller에서 받으면 안 됨
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    // delete
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id){
        //userService.deleteById(id);
    }

    // findbyid -> path variable
    @GetMapping("/id/{id}")
    public UserEntity findById(@PathVariable Long id){
        var response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(@RequestParam int score){
        return userService.filterScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> filterScore(@RequestParam int min, @RequestParam int max){
        return userService.filterScore(min, max);
    }

}
