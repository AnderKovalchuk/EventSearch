package EventSearch.models;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(indexes = {
		  @Index(columnList="login", unique = true), 
		  @Index(columnList="email", unique = true)
		})
public class User implements UserDetails {
	  @Id
	  @GeneratedValue
	  private Long id;
	
	  @NotBlank
	  @Size(min = 1, max = 512)
	  @Column(unique = true)
	  private String login;
	
	  @NotBlank
	  @Size(min = 1, max = 512)
	  @Column(unique = true)
	  private String email;
	
	  @NotBlank
	  @Size(min = 1, max = 100)
	  private String password;
	
	  public User() {}
	  
	public User(String login, String email, String password) {
		super();
		this.login = login;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	 public String getUsername() {
	        return getLogin();
	    }

	    public String getPassword() {
	        return password;
	    }

	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return AuthorityUtils.createAuthorityList("USER");
	    }

	    public boolean isAccountNonExpired() { return true; }
	    public boolean isAccountNonLocked() { return true; }
	    public boolean isCredentialsNonExpired() { return true; }
	    public boolean isEnabled() { return true; } 

	    
	    public static User getCurrentUser() {
	        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    }

	    public static Long getCurrentUserId() {
	        return getCurrentUser().getId();
	    }

	    public static boolean isAnonymous() {
	        return "anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName());
	    }
}