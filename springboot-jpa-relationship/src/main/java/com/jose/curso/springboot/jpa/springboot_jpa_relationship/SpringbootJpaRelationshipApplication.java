package com.jose.curso.springboot.jpa.springboot_jpa_relationship;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jose.curso.springboot.jpa.springboot_jpa_relationship.entities.Address;
import com.jose.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;
import com.jose.curso.springboot.jpa.springboot_jpa_relationship.entities.ClientDetails;
import com.jose.curso.springboot.jpa.springboot_jpa_relationship.entities.Invoice;
import com.jose.curso.springboot.jpa.springboot_jpa_relationship.repositories.ClientDetailsRepository;
import com.jose.curso.springboot.jpa.springboot_jpa_relationship.repositories.ClientRepository;
import com.jose.curso.springboot.jpa.springboot_jpa_relationship.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {
     
	@Autowired
	private ClientRepository clientRepository ; 
	@Autowired
	private ClientDetailsRepository clientDetailsRepository ; 
	@Autowired
	private InvoiceRepository invoiceRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//maniToOneFindByIdClient();
		//oneToMany();
		//deleteOneToMany();
		//oneToManyFindById();
		//removalAddress(); 
		//removalAddressFindById();
		//maniToOneBidireccional();
		//oneToOne();
		oneToOneBidireccional();
	}

	@Transactional
	public void oneToOneBidireccional(){

		Client client =  new Client("Juan" , "Lara");

		ClientDetails clientDetails = new ClientDetails(true, 5000);  
		client.setClienteDetails(clientDetails);
		clientDetails.setClient(client );
		clientRepository.save(client);
		System.out.println(client);
		
	}


	@Transactional
	public void oneToOne(){

		Client client =  new Client("Juan" , "Lara");
		clientRepository.save(client);
		ClientDetails clientDetails = new ClientDetails(true, 5000);
		clientDetails.setClient(client);
		clientDetailsRepository.save(clientDetails);
	}

	@Transactional
	public void removalAddressFindById(){
		
		Optional<Client> optionalClient =  clientRepository.findById(2L);
		optionalClient.ifPresent((client) -> {
			Address add1 =  new Address("el verjel" , 22);
			Address add2 =  new Address("Center cali" , 423);
			client.setAddresses(Arrays.asList(add1 , add2) ) ;
			clientRepository.save(client);
			System.out.println(client);
			Optional<Client> optionalClient2 = clientRepository.findOne(2l);
			optionalClient2.ifPresent((c)->{
			c.getAddresses().remove(add1);
			clientRepository.save(c);
			System.out.println(c);
		});
		});
	}

	@Transactional
	public void removalAddress(){
		Client client =  new Client("Frank" , "Lara");
		Address add1 =  new Address("el verjel" , 22);
		Address add2 =  new Address("Center cali" , 423);
		client.getAddresses().add(add1);
		client.getAddresses().add(add2);
		Client clienteDb = clientRepository.save(client);
		System.out.println(clienteDb);

		Optional<Client> optionalClient = clientRepository.findById(3l);
		optionalClient.ifPresent((c)->{
			c.getAddresses().remove(add1);
			clientRepository.save(c);
			System.out.println(c);
		});
	}

	@Transactional
	public void maniToOneBidireccional(){ 
			Client client =  new Client("jhon" , "doe"); 
			Invoice invoice1 =  new Invoice("Compras de casa" , 2000L);
			Invoice invoice2 =  new Invoice("Compras de oficina" , 8000L);
			
			List<Invoice> invoices = Arrays.asList(invoice1 , invoice2);
			
			client.setInvoices(invoices);

			//invoice1.setClient(client);
			//invoice2.setClient(client);

			clientRepository.save(client);
			System.out.println(client);

		}
	@Transactional
	public void oneToMany(){
		Client client =  new Client("Frank" , "Lara");
		Address add1 =  new Address("el verjel" , 22);
		Address add2 =  new Address("Center cali" , 423);
		client.getAddresses().add(add1);
		client.getAddresses().add(add2);
		Client clienteDb = clientRepository.save(client);
		System.out.println(clienteDb);
	}
	@Transactional
	public void oneToManyFindById(){
		
		Optional<Client> optionalClient =  clientRepository.findById(2L);
		optionalClient.ifPresent((client) -> {
			Address add1 =  new Address("el verjel" , 22);
			Address add2 =  new Address("Center cali" , 423);
			client.setAddresses(Arrays.asList(add1 , add2) ) ;
			clientRepository.save(client);
			System.out.println(client);
		});
	}
  
	@Transactional
	public void deleteOneToMany(){


		Optional<Client> optionalClient =  clientRepository.findById(3L);
		if (optionalClient.isPresent()){
			Client client =  optionalClient.orElseThrow();  
		    System.out.println(client);
		    clientRepository.delete(client);
		}
	}


  @Transactional
	public void maniToOne(){
		Client client =  new Client("jhon" , "doe");
		clientRepository.save(client);
		Invoice invoice =  new Invoice("Compras de oficina" , 2000L);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println(invoiceDb);
	}

	@Transactional
	public void maniToOneFindByIdClient(){
		Optional<Client> optionalClient =  clientRepository.findById(1L);
        if (optionalClient.isPresent()){
			Client client =  optionalClient.orElseThrow();
		
		
		Invoice invoice =  new Invoice("Compras de oficina" , 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println(invoiceDb);
	}
}

}
