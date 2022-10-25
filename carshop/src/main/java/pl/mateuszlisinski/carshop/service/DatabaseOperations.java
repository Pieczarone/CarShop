package pl.mateuszlisinski.carshop.service;

import pl.mateuszlisinski.carshop.model.Car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DatabaseOperations {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("carshop");

    public void addCar(Car car){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            em.merge(car);
            et.commit();
        }
        catch (Exception e){
            if(et !=null){
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public static void getCar(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query ="SELECT c FROM cars c WHERE c.id = :ID";
        TypedQuery<Car> tq = em.createQuery(query, Car.class);
        tq.setParameter("ID",id);
        Car car = null;
        try {
            car = tq.getSingleResult();
            System.out.println(car.getMake());
        }
        catch(NoResultException e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public List<Car> getCars() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Car c WHERE c.id IS NOT NULL";
        TypedQuery<Car> tq = em.createQuery(query, Car.class);
        List<Car> cars = new ArrayList<Car>();
        try{
            cars = tq.getResultList();
        }
        catch (NoResultException e){
            e.printStackTrace();
        }
        finally {

            em.close();
        }
        return cars;
    }
    public void updateCar(UUID id, String make, String registration, String description, int year, String color, Date arriveDate){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Car car = null;
        try {
            et = em.getTransaction();
            et.begin();
            car = em.find(Car.class, id);
            car.setMake(make);
            car.setRegistration(registration);
            car.setDescription(description);
            car.setYear(year);
            car.setColor(color);
            car.setArriveDate(arriveDate);
            car.setFixed(false);
            em.persist(car);
            et.commit();
        }
        catch (Exception e){
            if(et !=null){
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public void deleteCar(UUID id){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Car car = null;
        try {
            et = em.getTransaction();
            et.begin();
            car = em.find(Car.class, id);
            em.remove(car);
            et.commit();
        }
        catch (Exception e){
            if(et !=null){
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public void fixCar(UUID id){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Car car = null;
        try {
            et = em.getTransaction();
            et.begin();
            car = em.find(Car.class, id);
            car.setFixed(true);
            em.merge(car);
            et.commit();
        }
        catch (Exception e){
            if(et !=null){
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    public List<Car> getNotFixedCars() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Car c WHERE c.id IS NOT NULL and c.isFixed=0";
        TypedQuery<Car> tq = em.createQuery(query, Car.class);
        List<Car> cars = new ArrayList<Car>();
        try{
            cars = tq.getResultList();
        }
        catch (NoResultException e){
            e.printStackTrace();
        }
        finally {

            em.close();
        }
        return cars;
    }
    public List<Car> searchCars(String keyword) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Car c WHERE c.id IS NOT NULL AND (LOWER(c.make) LIKE LOWER('%" + keyword + "%') OR LOWER(c.registration) LIKE LOWER('%" + keyword + "%'))";
        TypedQuery<Car> tq = em.createQuery(query, Car.class);
        List<Car> cars = new ArrayList<Car>();
        try{
            cars = tq.getResultList();
        }
        catch (NoResultException e){
            e.printStackTrace();
        }
        finally {

            em.close();
        }
        return cars;
    }
}
