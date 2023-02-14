package com.hibernate.onetomany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/onetomany/hibernate.cfg.xml")
				.buildSessionFactory();
		
		Student student = new Student();
		student.setName("Steve Fleming");
		student.setAge(24);
		
		Address address = new Address("Rani Pura", "Indore", "42001");
		
		student.setAddress(address);
		
		MobileNumber mobileNumber = new MobileNumber();
		mobileNumber.setNumber(7678933901l);
		mobileNumber.setOperator("JIO");
		mobileNumber.setType("Personal");
		mobileNumber.setStudent(student);
		
		MobileNumber nasserNumber = new MobileNumber(8894870697L, "VI", "Office", student);
		ArrayList<MobileNumber> list = new ArrayList<>();
		list.add(mobileNumber);
		list.add(nasserNumber);
		
		student.setMobileNumbers(list);
		
		Student student2 = new Student();
		student2.setName("Rajat Shah");
		student2.setAge(31);
		
		Address mohitAddress = new Address("Sundrel Fata", "Dhamnod", "454454");
		
		student2.setAddress(mohitAddress);
		
		MobileNumber mohitNumber = new MobileNumber();
		mohitNumber.setNumber(6789594033l);
		mohitNumber.setOperator("IDEA");
		mohitNumber.setType("Personal");
		mohitNumber.setStudent(student2);
		
		ArrayList<MobileNumber> mohitnumbers = new ArrayList<MobileNumber>();
		mohitnumbers.add(mohitNumber);
		mohitnumbers.add(new MobileNumber(988940940l, "AIRTEL","Private", student2));
		mohitnumbers.add(new MobileNumber(9128350940l, "JIO","Office", student2));
		
		student2.setMobileNumbers(mohitnumbers);

		

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

//		session.save(student);
//		session.save(student2);
		
		Query<Student> query = session.createQuery("Select M From MobileNumber as M WHERE M.student=:x");
		query.setParameter("x", 2);
		List<Student> list2 = query.list();
		for (Student student3 : list2) {
			System.out.println(student3);
		}
		
//		Query<Student> query = session.createQuery("From Student as s order by s.id desc ",Student.class);
//		List<Student> list2 = query.list();
//		for (Student object : list2) {
//			System.out.println(object);
//		}
		
//		Query query = session.createQuery("Select name From Student");
//		List list2 = query.list();
//		for (Object object : list2) {
//			System.out.println(object);
//		}
		
//		Query query = session.createQuery("Select s.name, m.number From Student as s INNER JOIN MobileNumber as m on s.id = m.student where m.number like '91%'");
//		 List<Object[]> list2 = query.list();
//		 for (Object[] object : list2) {
//			System.out.println(Arrays.toString(object));
//		}
		
		
		
		
		//get and delete
//		Student student3 = session.get(student.getClass(),3 );
//		System.out.println(student3.getMobileNumbers());
		
//		List<MobileNumber> mobileNumbers = student3.getMobileNumbers();
//		for (MobileNumber mob : mobileNumbers) {
//			if (mob.getOperator().equalsIgnoreCase("VI")) {
//				mobileNumbers.remove(mob);
//				System.out.println("Vi number deleted");
//			}
//		}
//		ListIterator<MobileNumber> listIterator = mobileNumbers.listIterator();
//		if (listIterator.hasNext()) {
//			if(listIterator.next().getOperator().equals("VI"))
//				listIterator.remove();
//		}
		
		
//		session.delete(student3);

		System.out.println("student saved");
		transaction.commit();

		session.close();
		sessionFactory.close();

	}
}
