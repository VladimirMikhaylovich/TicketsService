package com.vlady.ticketsservice;

import com.vlady.ticketsservice.dao.UserRepo;
import com.vlady.ticketsservice.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TicketsServiceApplicationTests {

    @Autowired
    UserRepo userRepo;

   @Test
  public void CreateUserTest(){
        User user = new User();
        user.setId(1);
        user.setFirstname("Name");
        user.setLastname("Lastname");
        user.setPassport("123456");
        user.setDeleted(false);
        userRepo.save(user);
        assertNotNull(userRepo.findById(1).get());
  }
  @Test
  public void showAllUsersTest(){
      List<User> list = userRepo.findAll();
      assertThat(list.size() > 0);
  }
}
