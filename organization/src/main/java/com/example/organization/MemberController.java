package com.example.organization;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;

	@RequestMapping("/allMembers")
	public String getAllMembers(Model boxToView) {

		// System.out.println(employeeRepository.findAll());
		boxToView.addAttribute("memberListfromControllerAndDB", memberRepository.findAll());
		// boxToView.addAttribute("message", "hi from NORWAY");
		// boxToView.addAttribute("smoker", true);
		// boxToView.addAttribute("taxesIVA", 21.00);

		return "member.html";
	}

	@RequestMapping("/deleteMember")
	public String removeEmployee(int id, Model model) {

		// System.out.println("inside removeEmployee" + id);
		Optional<Member> memberFound = findOneMemberById(id);

		// System.out.println("find inside removeEmployee" + employeeFound.get());

		if (memberFound.isPresent()) {

			memberRepository.deleteById(id);
			model.addAttribute("message", "deleted member confirmation");
			model.addAttribute("memberDeleted", memberFound.get());
		}

		else {
			model.addAttribute("message", "deleted member error, maybe there is no id .... or network connection ..");
		}

		// System.out.println("finishing removeEmployee" + id);
		return "deletedMember.html";
	}

	@RequestMapping("/newMember")
	public String newMember() {

		return "newMember.html";
	}

	@RequestMapping("/addMember")
	public String inserMember(Member member) {

		memberRepository.save(member);

		return "redirect:/member/allMembers";
	}

//--------------------------------------------------------------------------------
//------------------------- service to controller --------------------------------
//--------------------------------------------------------------------------------

	public Optional<Member> findOneMemberById(int id) {

		// System.out.println("inside findEmployee" + id);
		Optional<Member> memberFound = memberRepository.findById(id);
		// System.out.println("finishing findEmployee" + id);
		// System.out.println("finishing findEmployee" + employeeFound.get());
		return memberFound;
	}

}