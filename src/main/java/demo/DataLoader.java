package demo;

import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

        // set global write concern for write operations
        mongoTemplate.setWriteConcern(WriteConcern.JOURNALED);

        // set write concern per operation basis
        // mongoTemplate.setWriteConcernResolver(new CustomerWriteConcernResolver());

    }

}
