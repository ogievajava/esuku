package com.example.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class DonationController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping("/allMembers")
	public String getAllMembers(Model boxToView) {
		
		
		//System.out.println(employeeRepository.findAll());
		boxToView.addAttribute("membersListfromControllerAndDB", memberRepository.findAll() );
		//boxToView.addAttribute("message", "hi from NORWAY");
		//boxToView.addAttribute("smoker", true);
		//boxToView.addAttribute("taxesIVA", 21.00);
		
		
		return "members.html";
	}

}

