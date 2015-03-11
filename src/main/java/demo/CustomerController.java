package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @RequestMapping(value = "/v1/customers", method = RequestMethod.POST)
    ResponseEntity<Void> create(@RequestBody CreateCustomerRequest createCustomerRequest) {
        createCustomerRequest.getName();

        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());

        Address address = new Address();
        address.setStreetName(createCustomerRequest.getAddress().getStreetName());

        addressRepository.save(address);
        // here can be a problem
        customerRepository.save(customer);

        return ResponseEntity.ok().build();
    }

}
