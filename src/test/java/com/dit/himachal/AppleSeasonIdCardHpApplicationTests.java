package com.dit.himachal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.dit.himachal.entities.RolesEntity;
import com.dit.himachal.entities.UserEntity;
import com.dit.himachal.repositories.RolesRepository;
import com.dit.himachal.repositories.UserRepository;
import com.dit.himachal.utilities.random24;

@SpringBootTest
class AppleSeasonIdCardHpApplicationTests {

//	@Autowired
//    RolesRepository rolesRepository;
//    @Autowired
//    UserRepository userRepository;
//
//
//    @Test
//    @Transactional
//    @Rollback(value = false)
//    void createUser(){
//
//        UserEntity user1 = new UserEntity();
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        user1.setUserName("kush");
//        user1.setPassword(encoder.encode("kush"));
//        user1.setMobileNumber(9418008559L);
//        user1.setActive(true);
//
////        UserEntity user2 = new UserEntity();
////        user2.setUserName("Demo2");
////        user2.setPassword("Demo@123");
//
//        userRepository.save(user1);
//       // userRepository.save(user2);
//    }
////
////
////    @Test
////    @Transactional
////    @Rollback(value = false)
////    void createRoles() {
////
////        RolesEntity roles = new RolesEntity();
////        roles.setRoleName("ADMIN");
////        roles.setRoleDescription("Administrator");
////
////        Optional<UserEntity> user = userRepository.findById((long) 4);
////		List<UserEntity> list = new ArrayList<UserEntity>();
////		list.add(user.get());
////        roles.setUsers(list);
////
////        rolesRepository.save(roles);
////
////    }
////
    @Test
    void bCryptPassword(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        encoder.encode("Demo@123");
        System.out.printf("\n");
        System.out.printf(encoder.encode("Demo@123"));
        System.out.printf("\n");
    }
//    
	
//  @Test
//  void checkRandom(){
//     
//      System.out.println("!@!@!@!@!"+random24.randomDecimalString(6)); 
//  }
	
	
	
    
}
