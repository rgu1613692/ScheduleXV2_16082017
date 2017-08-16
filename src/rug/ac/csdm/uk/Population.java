//population of schedules
package rug.ac.csdm.uk;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Population {
private ArrayList<Schedule> schedules; //arraylist of schedules
public Population (int size, Data data){
    schedules = new ArrayList<>(size);
    IntStream.range(0,size).forEach(x -> schedules.add(new Schedule(data).initialize()));
  }
public ArrayList<Schedule> getSchedules(){ return this.schedules;} //get method that will return the schedules
public Population sortByFitness(){
    schedules.sort((schedule1, schedule2) -> {
        int returnValue = 0;
        if (schedule1.getFitness() > schedule2.getFitness()) returnValue = -1;
        else if (schedule1.getFitness() < schedule2.getFitness()) returnValue = 1;
        return returnValue;
       });
       return this;
}
}
