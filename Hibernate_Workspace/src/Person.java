package com.capgemini.hibernate.person;

import javax.persistence.*;

@Entity
public class Person{
   @Id
   int personId;
   String personName;

   public Person(int Id, String  Name){
     this.personId=Id;
     this.personName=Name;
   }

    public void setPersonId( int personId){
      this.personId = personId;
    }

    public  int getPersonId(int personid){
       return personId;
    }

     public void setPersonName(String personName){
       this.personName = personName;
    }

     public String getPersonId(String personName){
       return personName;
    }

    public String toString(){
     return ("Id:"+personId+"Name"+personName);
   }
}