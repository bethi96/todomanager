package com.example.tharun.todomanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tharun.todomanager.entity.Todomanager;
import com.example.tharun.todomanager.entity.User;
import com.example.tharun.todomanager.repository.TodomanagerRepository;
import com.example.tharun.todomanager.repository.UserRepository;
import com.example.tharun.todomanager.service.TodomanagerService;
import com.example.tharun.todomanager.service.UserService;

import jakarta.websocket.server.PathParam;

@Controller
public class TodomanagerController {


	private TodomanagerService todomanagerService;
	
	@Autowired
	private TodomanagerRepository todomanagerepo;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@Autowired
	public TodomanagerController(TodomanagerService todomanagerService) {
		super();
		this.todomanagerService = todomanagerService;
	}

	public TodomanagerController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	public TodomanagerController(TodomanagerRepository todomanagerepo) {
		super();
		this.todomanagerepo = todomanagerepo;
	}

	@GetMapping("/")
	public String homepage() {
		return "redirect:/homepage";
	}

	@GetMapping("/homepage")
	public String viewHomepage() {
		return "index";
	}

	@GetMapping("/register")
	public String registerUser(Model model) {
		//register new user
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user")User user) {
		userService.saveUser(user);
		return "redirect:/register?success";
	}

	@GetMapping("/loginpage")
	public String Login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "loginpage";
	}
	
	@GetMapping("/gettodos")
	public String todoname(Model model) {
		Todomanager todo = new Todomanager();
		model.addAttribute("todoname", todo);
		return "gettodos";
	}
	
	@GetMapping("/edittodos")
	public String edittodoname(Model model) {
		Todomanager todo = new Todomanager();
		model.addAttribute("todoname", todo);
		return "edittodos";
	}
	
	@GetMapping("/deletetodos")
	public String deletetodoname(Model model) {
		Todomanager todo = new Todomanager();
		model.addAttribute("todoname", todo);
		return "deletetodos";
	}
	
	@PostMapping("/todoname")
	public String todoByName(@ModelAttribute("todoname")Todomanager todomanager,Model model) {
		String myname = todomanager.getName();
		System.out.println(myname);
		List<Todomanager> mytodolist = todomanagerepo.findTodoByName(myname);
		System.out.println(mytodolist);
		model.addAttribute("todos", mytodolist);
		System.out.println("success1");
		boolean validation = mytodolist.isEmpty();
		if(validation == false) {
		return "todos";
		}else {
			return "todo_error";
		}
	}
	
	@PostMapping("/userlogin")
	public String userLogin(@ModelAttribute("user")User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		System.out.println(email);
		System.out.println(password);
		User temp = userRepo.findByEmail(email);
		System.out.println(temp);
		String tempemail = temp.getEmail();
		String temppassword = temp.getPassword();
		//Optional<User> userdata = Optional.of(userService.findUserByEmail(email));
		//System.out.println(userdata);
		if(email.equals(tempemail)&& password.equals(temppassword)) {
			System.out.println("success");
			//return "redirect:/todos";
			return "redirect:/gettodos";
		}else {
			System.out.println("failure");
			return "error";
		}
		//User existingEmail = userService.findUserByEmail(email);
		//User existingPassword = userService.findUserByPassword(password);
		//System.out.println(existingEmail);
		//System.out.println(existingPassword);
		//return "todos";
	}

	//handler method
	@GetMapping("/todos")
	public String listTodos(Model model) {
		model.addAttribute("todos", todomanagerService.getAllTodos());
		return "todos";
	}

	@PostMapping("/todos")
	public String viewTodos(Model model) {
		model.addAttribute("todos", todomanagerService.getAllTodos());
		return "todos";
	}
	
	@GetMapping("/todos/new")
	public String createTodo(Model model) {
		//create student object to hold student data
		Todomanager todo = new Todomanager();
		model.addAttribute("todo", todo);
		return "create_todo";
		
	}
	
	@PostMapping("/todocreated")
	public String saveTodo(@ModelAttribute("todo")Todomanager todomanager) {
		todomanagerService.saveTodo(todomanager);
		//return "redirect:/todos?success";
		return "redirect:/gettodos?success";
	}
	
	@GetMapping("/todos/edit/{id}")
	public String editTodo(@PathVariable Long id, Model model) {
		model.addAttribute("todo", todomanagerService.getTodoById(id));
		return "edit_todo";
	}
	
	@PostMapping("/todocreated/{id}")
	public String updateTodo(@PathVariable Long id,@ModelAttribute("todo")Todomanager todomanager,Model model) {
		//get todo by id from DB
		Todomanager existingTodo = todomanagerService.getTodoById(id);
		existingTodo.setId(id);
		existingTodo.setTodoitem(todomanager.getTodoitem());
		existingTodo.setPriority(todomanager.getPriority());
		existingTodo.setComments(todomanager.getComments());
		existingTodo.setDescription(todomanager.getDescription());
		existingTodo.setDueDate(todomanager.getDueDate());
		existingTodo.setDueTime(todomanager.getDueTime());
		
		//save updated todo
		todomanagerService.updateTodo(existingTodo);
		//return "todos";
		return "redirect:/edittodos?success";
		
	}
	
	//handler for delete
	@GetMapping("/todos/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todomanagerService.deleteTodoById(id);
		return "redirect:/deletetodos?success";
		//return "todos";
	}


}
