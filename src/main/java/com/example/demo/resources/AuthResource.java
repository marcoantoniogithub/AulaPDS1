package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CredentialsDTO;
import com.example.demo.dto.EmailDTO;
import com.example.demo.dto.TokenDTO;
import com.example.demo.services.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private AuthService service;

	@PostMapping(value = "/login")
	public ResponseEntity<TokenDTO> login(@RequestBody CredentialsDTO dto) {
		TokenDTO tokenDTO = service.authenticate(dto);
		return ResponseEntity.ok().body(tokenDTO);
	}

	@PostMapping(value = "/refresh")
	public ResponseEntity<TokenDTO> refresh() {
		TokenDTO tokenDTO = service.refreshToken();
		return ResponseEntity.ok().body(tokenDTO);
	}
	
	@PostMapping(value = "/forgot")
	public ResponseEntity<TokenDTO> forgot(@RequestBody EmailDTO dto) {
		service.sendNewPassword(dto.getEmail());
		return ResponseEntity.noContent().build();
	}
}
