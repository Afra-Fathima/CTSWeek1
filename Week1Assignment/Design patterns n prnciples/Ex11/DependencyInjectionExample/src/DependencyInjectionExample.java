// Repository Interface
interface CustomerRepository {
    Customer findCustomerById(String id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(String id) {
        // In a real application, this would query a database
        return new Customer(id, "John Doe");
    }
}

// Model Class
class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}

// Main Class
public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.getCustomerById("12345");
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}
