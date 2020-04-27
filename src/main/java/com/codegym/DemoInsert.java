package com.codegym;

import com.codegym.DAO.CompanyDAO;
import com.codegym.entity.Company;
import com.codegym.entity.Employee;

public class DemoInsert {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAO();
        Company company = new Company("Google");
        Employee emp1 = new Employee("Bat Man");
        Employee emp2 = new Employee("Super Man");
        Employee emp3 = new Employee("Iron Man");
        emp1.setCompany(company);
        emp2.setCompany(company);
        emp3.setCompany(company);
        company.getListEmployee().add(emp1);
        company.getListEmployee().add(emp2);
        company.getListEmployee().add(emp3);
        companyDAO.save(company);
        System.out.println("Saved!");
        System.out.println(company);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        companyDAO.close();
    }
}
