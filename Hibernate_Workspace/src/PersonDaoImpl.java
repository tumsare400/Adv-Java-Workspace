package com.capgemini.hibernate.dao;

import com.capgemini.hibernate.person.*;
import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.boot.*;
import javax.persistence.*;
import com.capgemini.hibernate.util.*;

public class PersonDaoImpl implements PersonDao{
   
  
   public void addNew(Person person){

      SessionFactory factory = HibernateUtil.getSessionFactory();
System.out.println(factory);
      Session session = factory.openSession();
      Transaction tx = session.beginTransaction();
   
      session.save(person);

      tx.commit();
   }
}