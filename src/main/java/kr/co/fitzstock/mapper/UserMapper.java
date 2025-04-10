package kr.co.fitzstock.mapper;

import kr.co.fitzstock.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    // 이메일 사용자 조회 -> 로그인
    User findByEmail(@Param("email") String email);
    // 회원가입
    void insertUser(User user);
}