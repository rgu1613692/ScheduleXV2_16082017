//This class represent a population of schedules
package rug.ac.csdm.uk;
import java.util.ArrayList;
import rgu.ac.csdm.uk.domain.Class;
import rgu.ac.csdm.uk.domain.Department;
public class Schedule {//will have arraylist of classes
   private ArrayList<Class> classes; 
   private boolean isFitnessChanged = true;
   private double fitness = -1; //a schedule will have a fitness
   private int classNumb = 0; // defining class number counter
   private int numbOfConflicts = 0;// a schedule will have a number of conflicts with get method defined below
   private Data data; //using data coming from Data class
   public Data getData(){return data;}
   public Schedule(Data data){
       this.data = data;
       classes = new ArrayList<Class>(data.getNumberOfClasses()); //initialize arraylist of classes given the number of classes calculated from data class  
}
   //using the instance variable at the initiaze method
   public Schedule initialize(){
   new ArrayList<Department>(data.getDepts()).forEach(dept -> {//using data to pick up all the department
       dept.getCourses().forEach(course -> { //using data to pick up all the courses
           Class newClass = new Class(classNumb++, dept, course);
           
           
           //Potential Problem Zone
           newClass.setMeetingTime(data.getMeetingsTimes().get((int)(data.getMeetingsTimes().size()* Math.random())));
           newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));//randomely set room
           newClass.setInstructor(course.getInstructors().get((int)(course.getInstructors().size() * Math.random())));//randomely set instructor
           classes.add(newClass);
       });
   }); 
  return this;
}
public int getNumbOfConflicts(){return numbOfConflicts; }
public ArrayList<Class>getClasses(){
    isFitnessChanged = true;
    return classes;
}
public double getFitness(){
     if (isFitnessChanged == true) {
        fitness = calculateFitness();
        isFitnessChanged = false;
}
     return fitness;
}
private double calculateFitness(){//using java 8 to go through all the classes
    numbOfConflicts = 0;
    classes.forEach((Class x) -> {
        //using java 8 to go thru all the classes.
        if (x.getRoom().getSeatingCapacity()<x.getCourse().getMaxNumbOfStudents()) numbOfConflicts++;
        classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
            if (x.getMeetingTime() == y.getMeetingTime() && x.getId() !=y.getId()){
                if (x.getRoom() == y.getRoom())numbOfConflicts++;
                if(x.getInstructor() == y.getInstructor())numbOfConflicts++;
            }
            
        });
    });
        return 1/(double)(numbOfConflicts + 1);
}
   @Override
    public String toString(){//return all the classes
        String returnValue = new String();
        for (int x = 0; x < classes.size()-1;) returnValue += classes.get(x) + ";";
        returnValue += classes.get(classes.size()-1);
        return returnValue;
        }
    
    
    public String printer(){
        String response = new String();
        for (Class x : classes){
       response = x.toString();
        }
    
    return response;
    }
}