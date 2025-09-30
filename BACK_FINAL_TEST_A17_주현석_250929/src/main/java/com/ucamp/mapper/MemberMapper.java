package com.ucamp.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.ucamp.domain.Member;

@Mapper
public interface MemberMapper {

	public Member selectMemberById(String id);
	
	public void updateMember(Member member);
	
}
