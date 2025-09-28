package com.example.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.entity.UserEntity;
import com.example.exception.LoginException;
import com.example.exception.RegisterException;
import com.example.mapper.UserMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;

	// 회원가입
	@Transactional
	public void addUser(UserEntity user) {

		try {
			if (userMapper.selectUserById(user.getId()) != null) {
				throw new RegisterException("이미 존재하는 유저입니다.");
			}

			userMapper.insertUsers(user);
		} catch (DataAccessException e) {
			throw new RegisterException("회원가입 중 문제가 발생하였습니다.");
		}

	}

	// 로그인
	public UserEntity login(UserEntity user) {

		UserEntity targetUser = null;

		try {
			targetUser = userMapper.selectUserById(user.getId());

			if (targetUser == null) {
				throw new LoginException("존재하지 않는 유저입니다.");
			}

			if (!targetUser.getPassword().equals(user.getPassword())) {
				throw new LoginException("비밀번호가 틀렸습니다.");
			}

		} catch (DataAccessException e) {
			throw new LoginException("로그인 중 문제가 생겼습니다.");
		}

		return targetUser;
	}
}
