package qwuerty.backend.services;


import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import qwuerty.backend.models.User;
import qwuerty.backend.repos.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username){

        Optional<User> user = userRepository.findByUsername(username);

        return user.orElse(null);
    }

    public User insertUser(User user){

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUserByUsername(username);

        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
