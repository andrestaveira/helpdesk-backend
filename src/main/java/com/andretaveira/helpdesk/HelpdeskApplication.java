package com.andretaveira.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andretaveira.helpdesk.domain.Call;
import com.andretaveira.helpdesk.domain.Client;
import com.andretaveira.helpdesk.domain.Operator;
import com.andretaveira.helpdesk.domain.enums.Priority;
import com.andretaveira.helpdesk.domain.enums.Profile;
import com.andretaveira.helpdesk.domain.enums.Status;
import com.andretaveira.helpdesk.repositories.CallRepository;
import com.andretaveira.helpdesk.repositories.ClientRepository;
import com.andretaveira.helpdesk.repositories.OperatorRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private OperatorRepository operatorRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CallRepository callRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Operator operator = new Operator(null, "João", "74060636010", "joao@mail.com", "1234");
		operator.addProfile(Profile.ADMIN);
		
		Client client = new Client(null, "Maria", "41437920012", "maria@mail.com", "1234");
		
		Call call = new Call(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", operator, client);
		
		operatorRepository.saveAll(Arrays.asList(operator));
		clientRepository.saveAll(Arrays.asList(client));
		callRepository.saveAll(Arrays.asList(call));
	}

}
