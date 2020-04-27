package com.codegym;

import com.codegym.DAO.CompanyDAO;
import com.codegym.entity.Company;
import com.codegym.entity.Employee;

import java.util.List;

public class DemoSelect {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAO();
        int companyId = 1;
        Company company = companyDAO.findByIdWithEmployee(companyId);
        //Company company = companyDAO.findById(companyId);
        if (company != null) {
           List<Employee> listEmployee = company.getListEmployee();
           //List<Employee> listEmployee = companyDAO.getListEmployeeByCompany(company);
            for (Employee emp : listEmployee) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Not found company with id = " + companyId);
        }
        companyDAO.close();
    }

}
