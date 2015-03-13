package demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Document(collection = "customers")
public class Customer {

    @Id
    private String id;

    private String name;

    @DBRef
    private Address address;

    private Map<String, House> houses = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void addHouse(House house) {
        String houseId = UUID.randomUUID().toString();
        house.setId(houseId);

        houses.put(houseId, house);
    }

    public Map<String, House> getHouses() {
        return houses;
    }

}
