// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.web.bind.annotation.*;
import ristaurace.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ristaurace.repository.CustomerRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName) {
        CustomerModel customer = new CustomerModel();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }
}
