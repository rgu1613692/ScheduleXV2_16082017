//the representing an instructor to teach a course.
package rgu.ac.csdm.uk.domain;


public class Instructor {//will have instructor id and name
   private String id;
   private String name;;
   //
   public Instructor(String id, String name){
       this.id = id;
       this.name = name;
   }
public String getId(){return id;}
public String getName(){return name;}
public String toString() {return name;}

}

