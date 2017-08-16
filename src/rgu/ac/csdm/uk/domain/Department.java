//this is representing a course will belong to a department
package rgu.ac.csdm.uk.domain;

import java.util.ArrayList;

public class Department {
private String name;
private ArrayList<Course> courses;
public Department(String name, ArrayList<Course> courses){
   this.name = name;
   this.courses = courses;
 }
public String getName(){return name;}
public ArrayList<Course> getCourses(){return courses;}


}



