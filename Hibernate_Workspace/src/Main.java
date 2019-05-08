package com.capgemini.main; 
import com.capgemini.hibernate.person.*;
import com.capgemini.hibernate.dao.*;
public class Main{
    public static void main(String[] args){
      
      PersonDao dao = new PersonDaoImpl();
      dao.addNew(new Person(101, "Payal"));
      System.out.println("Hello");
    }
 }