package com.ucamp.controller;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucamp.domain.Member;
import com.ucamp.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	// 멤버 페이지로 이동
	@RequestMapping("/member")
	public void getMemberPage() {

	}

	// 로그인 처리
	@RequestMapping("/loginProc")
	public String getLogin(@ModelAttribute Member member, HttpServletRequest request) {

		member = memberService.searchMemberById(member);

		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return "redirect:member";
	}

	// 로그아웃 처리
	@RequestMapping("/logout")
	public String getLogout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("member") != null) {
			session.invalidate();
		}

		return "redirect:/";
	}

	// 비밀번호 변경 페이지
	@GetMapping("/member/changepwd")
	public void getPwChangeForm() {

	}

	// 비빌번호 변경 처리
	@PostMapping("/member/changepwd")
	public String getPwChange(@RequestParam String password, HttpSession session) {

		Member member = (Member) session.getAttribute("member");

		member.setPassword(password);
		memberService.modifyMember(member);

		return "redirect:/logout";

	}
}
