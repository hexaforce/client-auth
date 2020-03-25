package com.example.demo;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DummyController {

	/**
	 * RequestHeader version.
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	@GetMapping("/login")
	public @ResponseBody LoginResponse login(//
			@RequestHeader(name = "userId", required = true) String userId, //
			@RequestHeader(name = "password", required = true) String password//
	) {
		log.info("userId : {} password : {}", userId, password);
		return DummyController.LoginResponse.builder().code("success").message("this is dummy.").token(UUID.randomUUID().toString()).build();
	}

	/**
	 * RequestParam version.
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	@GetMapping("/login2")
	public @ResponseBody LoginResponse login2(//
			@RequestParam(name = "userId", required = true) String userId, //
			@RequestParam(name = "password", required = true) String password//
	) {
		log.info("userId : {} password : {}", userId, password);
		return DummyController.LoginResponse.builder().code("success").message("this is dummy.").token(UUID.randomUUID().toString()).build();
	}

	@GetMapping("/")
	public String inidex() {
		return health();
	}

	@GetMapping("/health")
	public String health() {
		log.info("health check OK!");
		return "OK";
	}

	@Data
	@Builder
	public static class LoginResponse {
		private String code, message, token;
	}

}
