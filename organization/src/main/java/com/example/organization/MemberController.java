package com.example.organization;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberRepository memberRepository;

	// Print complete list of members from database
	@RequestMapping("/allMember")
	public String getAllMembers(Model boxToView) {
		boxToView.addAttribute("memberListfromControllerAndDB", memberRepository.findAll());
		return "member.html";
	}

	// Operacion de crear new member
	@RequestMapping("/newMember")
	public String newMember() {
		return "newMember.html";
	}
	// Operacion de insert new member
	@RequestMapping("/addMember")
	public String insertMember(Member member) {
		memberRepository.save(member);
		return "redirect:/member/allMember";
	}

	
	// Operacion de delete member
	@RequestMapping("/deleteMember")
	public String removeEmployee(int id, Model model) {
		Optional<Member> memberFound = findOneMemberById(id);
		if (memberFound.isPresent()) {
			memberRepository.deleteById(id);
			model.addAttribute("message", "deleted member confirmation");
			model.addAttribute("memberDeleted", memberFound.get());
		} else {
			model.addAttribute("message", "deleted member error, maybe there is no id .... or network connection ..");
		}
		return "deletedMember.html";
	}

	// optional <Member> return operation from DB
	public Optional<Member> findOneMemberById(int id) {
		Optional<Member> memberFound = memberRepository.findById(id);
		return memberFound;
	}

}