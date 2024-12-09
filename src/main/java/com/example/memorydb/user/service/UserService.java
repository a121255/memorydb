package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // 내부-패키지 내에 생성된 클래스이기 때문에 @Service 사용 가능, 다른 jar나 패키지에 있는 건 불가능
@RequiredArgsConstructor
public class UserService {

    // 옛날방식 @Autowired -> bin context에 있는 여러 객체 중 userRepository를 주입
    // -> bin context에 들어가기 위해 1) @Service 달아주거나, 2) configration 파일에(@Configuration) @Bean으로 직접 생성
    private final UserRepository userRepository; //bean으로 등록되어 있어야 함, @RequiredArgsConstructor

    public UserEntity save(UserEntity user) {
        // save
        return  userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(long id) {
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(long id) {
        return userRepository.findById(id);
    }
}
