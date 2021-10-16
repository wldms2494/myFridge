package com.example.myfridge.service;

import com.example.myfridge.dto.SignupRequestDto;
import com.example.myfridge.model.User;
import com.example.myfridge.model.UserRoleEnum;
import com.example.myfridge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.myfridge.security.JwtTokenProvider;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //회원등록
    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        //ID중복 처리 부분
        //optional 사용, 조건문 없이도 null값 의 예외처리 가능
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }

        //패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());

        // 이메일
        String email = requestDto.getEmail();

        //사용자 ROLE확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException(("관리자 암호가 틀려 등록이 불가합니다."));
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(username, password, email, role);
        userRepository.save(user);

    }


    public User login(String username, String password) {
        System.out.println(username);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("아이디 찾을 수 없습니다."));
         if (!passwordEncoder.matches(password,user.getPassword() ))
        {
             throw new IllegalArgumentException("비밀번호 불일치");
        }

        return user;
    }
}
