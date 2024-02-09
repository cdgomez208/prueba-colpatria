package com.prueba.tecnica.backend.controllers;


import com.prueba.tecnica.backend.dtos.CustomerClientDTO;
import com.prueba.tecnica.backend.dtos.ResponseDTO;
import com.prueba.tecnica.backend.servicesImpl.CustomerClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "https://localhost:8080")
@RestController
public class CustomerClientController {

    @Autowired
    private CustomerClientService customerService;

    @GetMapping("/customers")
    public String getCustomers()  {
        String customers = customerService.getCustomers();

        return customers;
    }

    @ApiOperation(value = "create Customer", response = ResponseDTO.class)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody CustomerClientDTO customerClientDTO) throws Exception {

        return  customerService.createCustomer(customerClientDTO);

    }
}
