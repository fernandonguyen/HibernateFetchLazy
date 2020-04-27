package com.codegym.DAO;

import com.codegym.entity.Company;
import com.codegym.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import java.util.List;

public class CompanyDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public Company findById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Company company = entityManager.find(Company.class,id);
        entityManager.close();
        return company;
    }

    public Company save(Company company){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
        entityManager.close();
        return company;
    }

    public Company findByIdWithEmployee(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Company company = entityManager.find(Company.class, id);
        List<Employee> listEmployee = company.getListEmployee();
        listEmployee.size();
        entityManager.close();
        return company;
    }

    public List<Employee> getListEmployeeByCompany(Company company) {
        PersistenceUnitUtil impl = entityManagerFactory.getPersistenceUnitUtil();
        if(!impl.isLoaded(company.getListEmployee())){
            System.out.println("listEmployee is Lazy");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            List<Employee> listEmployee = entityManager
                    .createQuery("SELECT e FROM Employee e WHERE company = :company", Employee.class).setParameter("company", company).getResultList();
            entityManager.close();
            return listEmployee;
        }else{
            return company.getListEmployee();
        }
    }

    public void close() {
        entityManagerFactory.close();
    }

}
