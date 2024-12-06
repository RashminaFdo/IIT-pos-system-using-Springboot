package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDTo;
import com.iitposs.pos.dto.response.CustomerResponseDTO;
import com.iitposs.pos.entity.Customer;
import com.iitposs.pos.exception.NotFoundException;
import com.iitposs.pos.repo.CustomerRepo;
import com.iitposs.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {

        Customer customer = new Customer(
                saveRequestDTO.getCustomerID(),
                saveRequestDTO.getCustomerName(),
                saveRequestDTO.getCustomerAddress(),
                saveRequestDTO.getSalary(),
                saveRequestDTO.getContacts(),
                saveRequestDTO.getNic(),
                saveRequestDTO.isActiveState()
        );

        customerRepo.save(customer);

        return "saved";

    }

    @Override
    public String updateCustomer(CustomerSaveRequestDTO requestDTO) {

        if (customerRepo.existsById(requestDTO.getCustomerID())) {

            Customer customer = customerRepo.getReferenceById(requestDTO.getCustomerID());

            customer.setCustomerName(requestDTO.getCustomerName());
            customer.setCustomerAddress(requestDTO.getCustomerAddress());
            customer.setSalary(requestDTO.getSalary());
            customer.setActiveState(requestDTO.isActiveState());

            customerRepo.save(customer);

            return requestDTO.getCustomerName() + " has been updated...!";

        } else {
            return "something went wrong...!";
        }

    }

    @Override
    public CustomerResponseDTO getCustomerById(int customerID) {

        if (customerRepo.existsById(customerID)) {

            Customer customer = customerRepo.getReferenceById(customerID);

            return new CustomerResponseDTO(
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveState()
            );

        } else {
            return null;
        }
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {

        List<Customer> customers = customerRepo.findAll();

        List<CustomerResponseDTO> responseDTOS = new ArrayList<>();

        if (!customers.isEmpty()) {
            for (Customer customer : customers) {

                responseDTOS.add(new CustomerResponseDTO(
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getSalary(),
                        customer.getContacts(),
                        customer.getNic(),
                        customer.isActiveState()
                ));

            }

            return responseDTOS;

        } else {
            throw new NotFoundException("No customers found...!");
        }
    }

    @Override
    public String deleteCustomer(int customerID) {

        if (customerRepo.existsById(customerID)) {
            customerRepo.deleteById(customerID);
            return customerID + " customer has been deleted..!";
        } else {
            return "Customer is not found...!";
        }

    }

    @Override
    public List<CustomerAllDetailsResponseDTo> getAllCustomersByState(boolean state) {

        List<Customer> customers = customerRepo.findAllByActiveStateEquals(state);

        List<CustomerAllDetailsResponseDTo> responseDTOS = new ArrayList<>();

        for (Customer customer : customers) {

            responseDTOS.add(new CustomerAllDetailsResponseDTo(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveState()
            ));

        }

        return responseDTOS;
    }
}
