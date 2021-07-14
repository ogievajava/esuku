package com.example.organization;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.javafaker.Faker;

@Controller
public class HomeController {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private ExpenseRepository expenseRepository;

	// ------------------------------home ---------------------------
	@RequestMapping({ "/home", "/" })
	public String home() {
		return "home.html";
	}
	
	
	  @RequestMapping("/login") public String login() { return "login.html"; }
	 

	// -------------------- fill in our DB ---------------------------------------
	@RequestMapping({ "/fillin" })
	public String finInDB() {

		return "fillinNewMember.html";
	}

	@RequestMapping({ "/fillinNewMember" })
	public String fillInDBMember(int qtyToCreate) {

		String alphabetChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!·$%&/()=?¿?=)()/*-+^*Ç¨_:;;:_+/+/";

		// int i = 0;
		char stringRandom1, stringRandom2, stringRandom3;
		/*
		 * while (i < 10) { char charRandom =
		 * alphabetChars.charAt(createIntRandom(alphabetChars.length())); stringRandom *
		 * += stringRandom + charRandom;
		 * 
		 * }
		 */

		Faker faker = new Faker();
		//Random rand = new Random();
		int max = 1525;
		int count = 0;
		int intRandom;
		int intRandom2;
		while (count < qtyToCreate) {

			stringRandom1 = alphabetChars.charAt(createIntRandom(alphabetChars.length()));
			stringRandom2 = alphabetChars.charAt(createIntRandom(alphabetChars.length()));
			stringRandom3 = alphabetChars.charAt(createIntRandom(alphabetChars.length()));
			intRandom = createIntRandom(max);
			intRandom2 = createIntRandom(max*10);

			/*
			 * boolean randomPublished; if ((intRandom % 2) == 0) { randomPublished = true;
			 * } else { randomPublished = false; }
			 */
		
			
			memberRepository.save(new Member(
					faker.name().firstName(),
					faker.name().lastName(),
					faker.address().streetAddress(),
					faker.name().firstName() + "@java.com",
					"1234",
					faker.number().numberBetween(16, 65),
					faker.number().randomDouble(2, 5, 2000)
					));

					/* String.valueOf((intRandom + 5) *
					 * (count + 1) * 6) + stringRandom1 + stringRandom2 + stringRandom3, intRandom2,
					 * intRandom2)
					 */

			
			expenseRepository.save(new Expense(
					"dfg",
					faker.beer().name(),
					faker.number().numberBetween(1, 1000),
					faker.date().birthday(0, 3), 
					faker.number().randomDouble(2, 50, 2000)));

			count++;
		}

		return "redirect:/member/allMember";
	}

	// -------------------------- error path website ----------------------------
	@RequestMapping({ "*", "*/*", "*/*/*" })
	public String notFound(Model model) {

		String pattern = "yyyy-MM-dd HH:mm:ssZ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		model.addAttribute("serverTime", simpleDateFormat.format(new Date()));
		model.addAttribute("kingsley_variable", 15445);
		model.addAttribute("borja_test", "lo conseguire, any doubt?");
		model.addAttribute("smoker", true);

		return "notFound.html";
	}

	// -------------------------------------------------------------------------
	// ------------------ service to homeController -----------------------------
	// ---------------------------------------------------------------------------
	public static int createIntRandom(int top) {

		Random rand = new Random();

		// Generate random integers in range 0 to top, if top=10 random 0 to 9
		int intRandom = rand.nextInt(top);
		//System.out.println(intRandom);
		return intRandom;

	}

}