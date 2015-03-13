package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class DataLoader {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    private void init() {
        addressRepository.deleteAll();
        customerRepository.deleteAll();

        Customer customer = new Customer();
        customer.setName("Zoltan");

        Address address = new Address();
        address.setStreetName("Stadionlaan");

        House house = new House();
        house.setName("house1");
        customer.addHouse(house);

        house = new House();
        house.setName("house2");
        customer.addHouse(house);

        addressRepository.save(address);
        // here can be a problem
        customerRepository.save(customer);

        Customer one = customerRepository.findOne(customer.getId());

        Map<String, House> houses = one.getHouses();
        for (String s : houses.keySet()) {
            System.out.println(s + " : " + houses.get(s).getName());
        }


        // set global write concern for write operations, default is WriteConcern.ACKNOWLEDGED
        //mongoTemplate.setWriteConcern(WriteConcern.JOURNALED);

        // set write concern per operation basis
        // mongoTemplate.setWriteConcernResolver(new CustomerWriteConcernResolver());

    }

}
