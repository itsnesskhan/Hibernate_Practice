package com.hibernate.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/onetoone/hibernate.cfg.xml").buildSessionFactory();

		Address address = new Address("Abu Dhabi", "UAE", "42001");
		Student student = new Student("Inayat Khalil", 56,address );

		Address address2 = new Address("Kingsgard", "Kingslanding", "898383");
		Student student2 = new Student("Jaime Lennister", 43,address2 );

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

		//save data
//		session.save(student);
//		session.save(address);
//		session.save(student2);
//		session.save(address2);
		
		//get data
//		Student address1 = session.get(Student.class, 5);
//		Address address3 = session.get(address.getClass(), 1);
//		Student address3 = session.get(Student.class, 4);
//		System.out.println(address1);
//		System.out.println(address3);
//		System.out.println(address3.getStudent().getName());
		
		//update data
		//for update first get
//		address1.setName("Jon Snow");
//		address1.setAge(32);
//		student3.setName("Nasser Khan");
		
//		session.update(address1);
		
		//delete
		//for delete first get
//		session.delete(address1);
//	session.delete(address3);
		
		Address student3 = session.get(address.getClass(), 2);
		Student student4 = student3.getStudent();
		System.out.println(student4);
		
		System.out.println(student3);
//		session.delete(student3);
		
		System.out.println("student saved");

		transaction.commit();

		session.close();
		sessionFactory.close();

	}
}
