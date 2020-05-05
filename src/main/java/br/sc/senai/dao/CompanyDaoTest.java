package br.sc.senai.dao;

import br.sc.senai.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompanyDaoTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

        insert();

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
}
