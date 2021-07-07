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

	@RequestMapping("/allMember")
	public String getAllMember(Model boxToView) {

		boxToView.addAttribute("memberListfromControllerAndDB", 
				memberRepository.findAll());

		return "member.html";
	}

	//-----------------------delete----------------------------------
	@RequestMapping("/deleteMember")
	public String removeMember(int id, Model model) {

		// System.out.println("inside removeEmployee" + id);
		Optional<Member> memberFound = findOneMemberById(id);

		// System.out.println("find inside removeEmployee" + employeeFound.get());

		if (memberFound.isPresent()) {

			memberRepository.deleteById(id);
			model.addAttribute("message", "done");
			model.addAttribute("memberDeleted", memberFound.get());
		}

		else {
			model.addAttribute("message", "error");
		}

		// System.out.println("finishing removeEmployee" + id);
		return "deleteMember.html";
	}

	@RequestMapping("/deleteAllMember")
	public String deleteAllEmployees () {

		
		memberRepository.deleteAll();
		

		return "redirect:/member/allMember";

	}
	
	//-----------------------add----------------------------------
	@RequestMapping("/newMember")
	public String newMember() {

		return "newMember.html";
	}

	@RequestMapping("/addMember")
	public String insertMember(Member member) {

		memberRepository.save(member);

		return "redirect:/member/allMember";
	}

	//-----------------------update----------------------------------
	@RequestMapping("/updateEmployee")
	public String updateEmpoyee(int id, Model model) {

		Optional<Member> memberFound = findOneMemberById(id);

		if (memberFound.isPresent()) {

			model.addAttribute("memberfromController", memberFound.get());
			return "updateMember";
		}

		else
			return "notFound.html";
	}

	@PostMapping("/replaceMember/{idFromView}")
	public String replaceMember(@PathVariable("idFromView") int id, Member member) {

		Optional<Member> memberFound = findOneMemberById(id);

		if (memberFound.isPresent()) {

			if (member.getName() != null)
				memberFound.get().setName(member.getName());
			if (member.getSurname() != null)
				memberFound.get().setSurname(member.getSurname());
			if (member.getPassword() != null)
				memberFound.get().setPassword(member.getPassword());
			if (member.getEmail() != null)
				memberFound.get().setEmail(member.getEmail());
			if (member.getAge() != 0)
				memberFound.get().setAge(member.getAge());
			if (member.getDonation() != 0.0)
				memberFound.get().setDonation(member.getDonation());

			memberRepository.save(memberFound.get());
			return "redirect:/member/allMember";

		} else
			return "notfound.html";

	}
	
	//-----------------------detail----------------------------------
	@RequestMapping("/detailMember")
	public String detailMember(int id, Model model) {

		Optional<Member> memberFound = findOneMemberById(id);

		if (memberFound.isPresent()) {

			model.addAttribute("memberfromController", memberFound.get());
			return "detailMember";
		}

		else
			return "notFound.html";
	}
	
//--------------------------------------------------------------------------------
//------------------------- service to controller --------------------------------
//--------------------------------------------------------------------------------

	public Optional<Member> findOneMemberById(int id) {

		// System.out.println("inside findMember" + id);
		Optional<Member> memberFound = memberRepository.findById(id);
		// System.out.println("finishing findMember" + id);
		// System.out.println("finishing findMember" + memberFound.get());
		return memberFound;
	}

}