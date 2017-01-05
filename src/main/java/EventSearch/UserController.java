package EventSearch;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import EventSearch.services.UserService;

@Controller
public class UserController {
	
	  @Autowired
	  private UserService usersService;
	  
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
		  public String register(@RequestParam("login") String login, 
		      @RequestParam("email") String email, 
		      @RequestParam("pass") String pass) { 
		    usersService.register(login, email, pass);
		    return "redirect:home";
	  }
	  
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String login(String login, String password, HttpSession session) {
	      Long userId = usersService.login(login, password);

	      if(userId != null) {
	          session.setAttribute("userId", userId);
	          return "redirect:home";
	      } else {
	          return "redirect:login";
	      }
	  }
	  
	  @ResponseBody 
	  @RequestMapping(value="/userLogins", method = RequestMethod.POST)
	  public Boolean checkUserExists(@RequestParam("login") String login) {
		  return usersService.dobleLogin(login);
	  }
	  
	  @ResponseBody 
	  @RequestMapping(value="/userEmail", method = RequestMethod.POST)
	  public Boolean checkEmailExists(@RequestParam("email") String email) {
		  return usersService.dobleEmail(email);
	  }

}
