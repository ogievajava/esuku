package com.example.organization;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/expense")
	public class ExpenseController {
		
		@Autowired
		ExpenseRepository expenseRepository;

		//----------------------- read ---------------------------------
		@RequestMapping("/allExpense")
		public String getAllExpense(Model boxToView) {
			
			boxToView.addAttribute("expensefromController", expenseRepository.findAll() );
			
			return "expense.html";
		}
		
		//-----------------------add----------------------------------
		@RequestMapping("/newExpense")
		public String newExpense () {

			return "newexpense.html";
		}


		@RequestMapping("/addExpense")
		public String inserExpense ( @Validated Expense expense, Model boxToView) {
			
			//System.out.println(expense);
			expenseRepository.save(expense);
			boxToView.addAttribute("expensefromController", expenseRepository.findAll());
			boxToView.addAttribute("expenseAdded", expense);

			return "expense.html";
		}
		
		
		//-----------------------delete----------------------------------
		@RequestMapping("/deleteExpense")
		public String removeExpense(int id, Model boxToView) {

			// System.out.println("inside removeEmployee" + id);
			Optional<Expense> expenseFound = findOneExpenseById(id);

			// System.out.println("find inside removeEmployee" + employeeFound.get());

			if (expenseFound.isPresent()) {

				expenseRepository.deleteById(id);
				
				boxToView.addAttribute("expensefromController", expenseRepository.findAll());
				boxToView.addAttribute("expenseDeleted", expenseFound.get());
				
			}

			else {
				boxToView.addAttribute("expenseDeleted", "error");
			}

			// System.out.println("finishing removeEmployee" + id);
			return "expense.html";
		}

		
		//-----------------------update----------------------------------
		@RequestMapping("/updateExpense")
		public String updateExpense(int id, Model model) {

			Optional<Expense> expenseFound = findOneExpenseById(id);

			if (expenseFound.isPresent()) {

				model.addAttribute("expensefromController", expenseFound.get());
				return "updateexpense.html";
			}

			else
				return "notfound.html";
		}

		@PostMapping("/replaceExpense/{idFromView}")
		public String replaceMember(@PathVariable("idFromView") int id, Expense expense, Model model) {

			Optional<Expense> expenseFound = findOneExpenseById(id);

			if (expenseFound.isPresent()) {

				if (expense.getName() != null)
					expenseFound.get().setName(expense.getName());
				
				if (expense.getProduct() != null)
					expenseFound.get().setProduct(expense.getProduct());
				
				if (expense.getQuantity() != 0)
					expenseFound.get().setQuantity(expense.getQuantity());
				
				if (expense.getValue() != 0.0)
					expenseFound.get().setValue(expense.getValue());

				expenseRepository.save(expenseFound.get());
				model.addAttribute("expensefromController", expenseRepository.findAll());
				model.addAttribute("expenseUpdated", expenseFound.get());
				
				return "expense.html";

			} else
				return "notfound.html";

		}
		
		
	//--------------------------------------------------------------------------------
	//------------------------- service to controller --------------------------------
	//--------------------------------------------------------------------------------

		public Optional<Expense> findOneExpenseById(int id) {

			// System.out.println("inside findEmployee" + id);
			Optional<Expense> expenseFound = expenseRepository.findById(id);
			// System.out.println("finishing findEmployee" + id);
			// System.out.println("finishing findEmployee" + employeeFound.get());
			return expenseFound;
		}
		



}