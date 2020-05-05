package br.sc.senai.dao;

import br.sc.senai.model.Phone;
import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PhoneDao {

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

        Phone phone = new Phone();
        phone.setNumber("(48) 9852-6365");

        User user = entityManager.find(User.class, 6);

        phone.setUser(user);

        entityManager.persist(phone);

        entityManager.getTransaction().commit();

    }
}
