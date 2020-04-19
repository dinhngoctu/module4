package app.controller;


import app.Service.CustomerService;
import app.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/get/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        System.out.println(customer.getFirstName());
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PutMapping(value = "/put/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> putCustomer(@PathVariable("id") Long id, @RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        if (this.customerService.findById(id) != null) {
            customer.setId(id);
            this.customerService.save(customer);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/get/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @PostMapping(value = "/post/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> postCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + customer.getLastName());
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(customer.getId()).toUri());
        System.out.println("123");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id,UriComponentsBuilder ucBuilder) {
        if (this.customerService.findById(id) != null) {
            customerService.remove(id);
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }
}
