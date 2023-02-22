package cns.assignment2.assignment2.repository;

import cns.assignment2.assignment2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

   User findByUsernameAndPassword(String username,String password);
}
