package app.Service.Iml;

import app.Service.CustomerService;
import app.model.Customer;
import app.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceIml implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.remove(id);
    }
}
