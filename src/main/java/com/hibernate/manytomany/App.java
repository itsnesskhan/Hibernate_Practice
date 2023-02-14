package com.hibernate.manytomany;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/manytomany/hibernate.cfg.xml").buildSessionFactory();

		UserRoles roles = new UserRoles();
		roles.setId(101);
		roles.setName("STUDENT");
		
		UserRoles roles2 = new UserRoles();
		roles2.setId(102);
		roles2.setName("ADMIN");
		UserRoles roles3 = new UserRoles();
		roles3.setId(103);
		roles3.setName("TEACHER");
		
		User nasserUser = new User();
		nasserUser.setName("Nasser Khan");
		
		List<UserRoles> nasseRoles = new ArrayList<UserRoles>();
		nasseRoles.add(roles);
		nasserUser.setRoles(nasseRoles);
		
		User mohitUser = new User();
		mohitUser.setName("Mohit Malve");
		
		List<UserRoles> mohitRoles = new ArrayList<UserRoles>();
		mohitRoles.add(roles2);
		mohitRoles.add(roles3);
		
		mohitUser.setRoles(mohitRoles);
		
		UserPrivilages privilages = new UserPrivilages(302, "student:read");
		UserPrivilages privilages2 = new UserPrivilages(303, "student:write");
		
		
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();

	
//		session.save(nasserUser);
//		session.save(mohitUser);
		
		
//		ListIterator<UserRoles> listIterator = roles4.listIterator();
//		while (listIterator.hasNext()) {
//			if (listIterator.next().getName().equals("TEACHER")) {
//				listIterator.remove();
//			}
//		}
		
//		User user = session.get(User.class, 2);
//		System.out.println(user);
//		session.delete(user);
		
		//set privilages
		
		UserRoles admin = session.get(UserRoles.class, 102);
		Set<UserPrivilages> adminpermissions = new HashSet<UserPrivilages>();
		adminpermissions.add(privilages);
		adminpermissions.add(privilages2);
		admin.setPrivilages(adminpermissions);
		
		UserRoles teacher = session.get(UserRoles.class, 103);
		Set<UserPrivilages> teacherpermisions = new HashSet<UserPrivilages>();
		teacherpermisions.add(privilages);
		teacher.setPrivilages(teacherpermisions);
//		session.save(privilages);
//		session.save(privilages2);
//		session.saveOrUpdate(admin);
//		session.saveOrUpdate(teacher);
		
		Set<UserPrivilages> set = admin.getPrivilages();
		System.out.println(set);
		
		
		
		
		transaction.commit();

		session.close();
		sessionFactory.close();

	}
}
