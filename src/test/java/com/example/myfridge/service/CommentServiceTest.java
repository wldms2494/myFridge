package com.example.myfridge.service;

import com.example.myfridge.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {
    @Mock
    CommentRepository commentRepository;

    @Test
    @DisplayName("xss 테스트")
    void checkxss() {
        //given
        String script = "<script>xss 공격</script>";



        //when

        //then

    }


}