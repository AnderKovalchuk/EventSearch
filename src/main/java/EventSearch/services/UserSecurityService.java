package EventSearch.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import EventSearch.models.User;
import EventSearch.repositories.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository usersRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = usersRepo.findByLogin(username);

        if(user == null) {
            throw new UsernameNotFoundException("User with login " + username + " was not found");
        }

        return user;
    }
}