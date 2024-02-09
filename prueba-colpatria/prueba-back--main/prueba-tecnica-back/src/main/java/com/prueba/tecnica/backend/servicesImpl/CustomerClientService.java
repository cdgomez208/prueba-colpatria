package com.prueba.tecnica.backend.servicesImpl;


import com.prueba.tecnica.backend.dtos.CustomerClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class CustomerClientService {

    private final String CUSTOMERS_URL = "https://8e7c6b8a-fc46-4674-a529-4ebec57295d3.mock.pstmn.io/customers";
    private final RestTemplate restTemplate;


    @Autowired
    public CustomerClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
     }


    public String getCustomers() {
       String respuesta= restTemplate.getForObject(CUSTOMERS_URL, String.class);
        System.out.println("respuesta"+respuesta);
       return respuesta;
    }

    public ResponseEntity<String> createCustomer(CustomerClientDTO customerClientDTO)  {

        if (validateCustomer(customerClientDTO)) {
              ResponseEntity<String> response=consumeApi(customerClientDTO);
              return response;

        }  else {

        throw new IllegalArgumentException("Error de validación: los datos del cliente no son válidos");
    }


    }

    private  ResponseEntity<String> consumeApi(CustomerClientDTO customerClientDTO){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CustomerClientDTO> request = new HttpEntity<>(customerClientDTO, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(CUSTOMERS_URL, request, String.class);
     return response ;
    }

    public boolean validateCustomer(CustomerClientDTO customerDto) {
        // Validación de obligatoriedad de los campos
        if (customerDto.getName() == null ) {
            return false;
        }

        if (customerDto.getAge() == 0) {
            return false;
        }

        if (customerDto.getPhoneNumber() == null || customerDto.getPhoneNumber().isEmpty()) {
            return false;
        }

        if (customerDto.getAddress() == null || customerDto.getAddress().isEmpty()) {
            return false;
        }



        if (!(customerDto.getPhoneNumber() instanceof String)) {
            return false;
        }

        // Validación de formato para address calle 10 # 15 A - 23este
        if (!customerDto.getAddress().matches("[A-Za-z]+ \\d{2} # \\d{2} [A]{1} - \\d{2}[A-Za-z]+$")) {
            return false;
        }

        // Validación de formato para phoneNumber
        if (!customerDto.getPhoneNumber().matches("\\d{10}")) {
            return false;
        }

        // Validación de formato para age
        if (customerDto.getAge() < 0 || customerDto.getAge() > 99) {
            return false;
        }

        // Validación de formato para name
        if (!customerDto.getName().matches("[A-Z][a-z]+( [A-Z][a-z]+)*")) {
            return false;
        }

        if (customerDto.getName().length() > 50) {
            return false;
        }

        return true; // Si todas las validaciones pasan, retorna true
    }


}