package br.sc.senai.dao;

import br.sc.senai.model.Company;
import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

        //insert();

        //update();

        //delete();

        find();

        entityManager.close();
        factory.close();

    }

    public static void insert() {

        entityManager.getTransaction().begin();

        User newUser = new User();
        newUser.setEmail("jose.bueno@gmail.com");
        newUser.setFullname("José Bueno");
        newUser.setPassword("lalala");

        Company company = entityManager.find(Company.class, 1);
        newUser.setCompany(company);

        entityManager.persist(newUser);

        entityManager.getTransaction().commit();

    }

    public static void update() {

        entityManager.getTransaction().begin();

        User updatedUser = entityManager.find(User.class, 1);

        //System.out.println(updatedUser.getFullname());
        updatedUser.setFullname("Bill Gates");
        updatedUser.setEmail("bill.gates@microsoft.com");

        entityManager.merge(updatedUser);

        entityManager.getTransaction().commit();

    }

    public static void delete() {

        entityManager.getTransaction().begin();

        User deletedUser = entityManager.find(User.class, 1);

        entityManager.remove(deletedUser);

        entityManager.getTransaction().commit();

    }

    public static void find() {

        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, 6);

        System.out.println("Usuário: " + user.getFullname());
        System.out.println("Empresa: " + user.getCompany().getName());

        entityManager.getTransaction().commit();

    }
}
