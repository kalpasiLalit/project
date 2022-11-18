package com.ttn.EcommerceProject.EcommerceProject;

import com.ttn.EcommerceProject.EcommerceProject.Repository.ConfirmationTokenRepository;
import com.ttn.EcommerceProject.EcommerceProject.model.ConfirmationToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class EcommerceProjectApplicationTests {

	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	@Transactional
//	@Rollback(value = false)
//	public  void  updateTokenTest(){
//		Optional<ConfirmationToken> confirmationToken1 = confirmationTokenRepository.findByUserId(167L);
//     if (confirmationToken1.isPresent()){
//         confirmationTokenRepository.
//				 updateUser("eu11",LocalDateTime.now(),LocalDateTime.now().plusMinutes(1), confirmationToken1.get().getId());
//
//     }
//	}

}
