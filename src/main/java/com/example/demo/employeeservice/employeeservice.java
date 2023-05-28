package com.example.demo.employeeservice;

import com.example.demo.employeemodel.employee;
import com.example.demo.employeerepository.employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeservice {
    private static final String Hash_Key = "Employee";
    @Autowired
    employeerepo employeeRepository;

    public List<employee> display(){
        return employeeRepository.findAll();
    }
    public employee createEmployee(employee employee){
        return employeeRepository.save(employee);
    }
    public List<employee> createEmployeeList(List<employee> employee)
    {
        return employeeRepository.saveAll(employee);
    }
    //sorting data based on fields
    public List<employee> displaysort(String field){
        return employeeRepository.findAll(Sort.by(field));
    }
    //pagination
    public Page<employee> pagination(int pagesize, int offset)
    {
        Page<employee> employees = employeeRepository.findAll(PageRequest.of(pagesize,offset));
        return employees;
    }
}
