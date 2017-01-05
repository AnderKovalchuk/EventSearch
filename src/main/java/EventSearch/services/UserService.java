package EventSearch.services;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import EventSearch.models.User;
import EventSearch.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository usersRepo;

  @Transactional
  @PostConstruct
	public void createAdminUser() {		
		User userAdmin=usersRepo.findByLogin("admin");
		if(userAdmin==null){
			register("admin", "admin@mail.com", "admin");
		}
	}
  
  public Long login(String login, String password) {
  	User user=usersRepo.findByLogin(login);

      if(user==null || !( new BCryptPasswordEncoder().matches(password, user.getPassword()) ) ){	 
         	return null;
      }
          
      return user.getId();
  }
  
  public void register(String login, String email, String pass) {
    String passHash = new BCryptPasswordEncoder().encode(pass);
    User u = new User(login, email.toLowerCase(), passHash);
    usersRepo.save(u);
  }

  public Boolean dobleLogin(String login){
	  if(usersRepo.findByLogin(login) == null)
		  return true;
	  return false;
  }
  public Boolean dobleEmail(String email){
	  if(usersRepo.findByEmail(email) == null)
		  return true;
	  return false;
  }
}