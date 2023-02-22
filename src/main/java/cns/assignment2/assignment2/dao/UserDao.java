package cns.assignment2.assignment2.dao;

import cns.assignment2.assignment2.entity.User;
import cns.assignment2.assignment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User signup) {
        userRepository.save(signup);
    }

   public User findByUsernameAndPassword(String username,String password){return userRepository.findByUsernameAndPassword(username,password);}
}
