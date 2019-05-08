package com.capgemini.hibernate.util;

import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.boot.*;
import javax.persistence.*;

public class HibernateUtil{

   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory(){
       if(sessionFactory==null){
	   StandardServiceRegistry registry = new  StandardServiceRegistryBuilder().configure().build();
	   MetadataSources sources = new  MetadataSources(registry);
           Metadata metadata = sources.getMetadataBuilder().build();
           sessionFactory = metadata.getSessionFactoryBuilder().build();
           
       }
   
         return sessionFactory ;
   }
   public static void closeSessionFactory(){
        if(sessionFactory!=null)
            sessionFactory.close();
   }
}