package br.sc.senai.dao;

import br.sc.senai.model.Company;
import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CompanyDaoTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

        //insert();

        listUsers();

        entityManager.close();
        factory.close();

    }

    public static void insert() {

        entityManager.getTransaction().begin();

        Company company = new Company();
        company.setName("AWS");

        entityManager.persist(company);

        entityManager.getTransaction().commit();

    }

    public static void listUsers() {

        entityManager.getTransaction().begin();

        Company company = entityManager.find(Company.class, 1);

        List<User> usuarios = company.getUsers();

        for (User user : usuarios) {
            System.out.println("--------------------------------------------");
            System.out.println(user.getFullname());
            System.out.println(user.getEmail());
            System.out.println("--------------------------------------------");
        }

        entityManager.getTransaction().commit();

    }
}
