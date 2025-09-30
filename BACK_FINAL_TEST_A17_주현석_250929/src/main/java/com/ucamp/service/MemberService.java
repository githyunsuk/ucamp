package com.ucamp.service;

import javax.security.auth.login.LoginException;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ucamp.domain.Member;
import com.ucamp.exception.LoginFailException;
import com.ucamp.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	// 유저 찾기
	public Member searchMemberById(Member member) {

		Member targetMember = null;
		try {
			targetMember = memberMapper.selectMemberById(member.getId());
			if(targetMember == null) throw new LoginFailException("아이디가 틀립니다");
			if(!targetMember.getPassword().equals(member.getPassword())) throw new LoginFailException("비밀번호가 틀립니다");
		} catch(DataAccessException e) {
			throw new LoginFailException("로그인 과정에서 문제가 생겼습니다. 다시 시도해주세요");
		}

		return targetMember;
	}

	// 유저 변경
	public void modifyMember(Member member) {

		memberMapper.updateMember(member);
	}

}
