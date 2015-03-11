package demo;

public class CreateCustomerRequest {

    private String name;

    private CreateCustomerAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateCustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CreateCustomerAddress address) {
        this.address = address;
    }
}
