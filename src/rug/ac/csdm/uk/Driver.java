package rug.ac.csdm.uk;
import java.util.ArrayList;
import rgu.ac.csdm.uk.domain.Class;
public class Driver {//driver for the whole package
    public  static final int Population_size = 9;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private int scheduleNumb = 0;
    private int classNumb = 1;
    private Data data;
    public static void main(String[] args) {
       Driver driver = new Driver();
       driver.data = new Data();
       int generationNumber = 0;
       driver.printAvailableData();
       System.out.println("> Generation # "+generationNumber);
       System.out.print(" Schedule # |                                          ");
       System.out.print("Classes [dept,class,room,instructor,meeting-time]     ");
       System.out.println( "                                       | Fitness | Conflicts");
       System.out.print("---------------------------------------------------------------------------------------------------");
       System.out.println("------------------------------------------------------------------------------------------------------");
       
       GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
      
       Population population = new Population(Driver.Population_size, driver.data).sortByFitness();
       
       population.getSchedules().forEach(schedule -> System.out.println("         "+driver.scheduleNumb++ +
                                                                    "       | "+ schedule.getData() + " | " +
                                                                     String.format("%.5f", schedule.getFitness()) +
                                                                      " | "+schedule.getNumbOfConflicts()));
       driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
               
               
       driver.classNumb = 1;
       while (population.getSchedules().get(0).getFitness() != 1.0){
        System.out.println("> Generation # "+ ++generationNumber);
        System.out.print(" Schedule # |                                             ");
        System.out.print("Classes [dept, class, room, instructor,meeting-time]     ");
        System.out.println("                                       | Fitness | Conflicts");
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------");
        population = geneticAlgorithm.evolve(population).sortByFitness();
        driver.scheduleNumb = 0;
        population.getSchedules().forEach(schedule -> System.out.println("          "+driver.scheduleNumb++ +
                                                                         "         | "+ schedule.printer() + " | " + 
                                                                         String.format("%.5f", schedule.getFitness()) +
                                                                         " | "+schedule.getNumbOfConflicts()));
        driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
        driver.classNumb = 1;
    }
    }
    private void printScheduleAsTable(Schedule schedule, int generation){
        ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n                         ");
        System.out.println("Class # | Dept | Course (number, max # of students) | Room (Capacity) |   Instructor (Id)   |   Meeting Time (Id);        + ");
        System.out.print("                       ");
        System.out.print("------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        classes.forEach(x -> {
            int majorIndex = data.getDepts().indexOf(x.getDept());
            int coursesIndex = data.getCourses().indexOf(x.getCourse());
            int roomsindex = data.getRooms().indexOf(x.getRoom());
            int instructorsIndex = data.getInstructor().indexOf(x.getInstructor());
            int meetingTimeIndex = data.getMeetingsTimes().indexOf(x.getMeetingTime());
            System.out.print("                           ");
            System.out.print(String.format("   %1$02d  ", classNumb) + "  |  ");
            System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName()) + "  |  ");
            System.out.print(String.format("%1$21s", data.getCourses().get(coursesIndex).getName() + 
                                           " ("+data.getCourses().get(coursesIndex).getNumber()+", "+
                                           x.getCourse().getMaxNumbOfStudents())+")              | ");
            System.out.print(String.format("%1$10s", data.getRooms().get(roomsindex).getNumber() +
                                           " ("+x.getRoom().getSeatingCapacity()) + ")      |  ");
            System.out.println(data.getMeetingsTimes().get(meetingTimeIndex).getTime()+
                               " ("+data.getMeetingsTimes().get(meetingTimeIndex).getid()+")");
            classNumb++;
       });
        if (schedule.getFitness() == 1) System.out.println("> Solution Found in "+ (generation +1) +" generation");
        System.out.print("----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");
    }
        
    private void printAvailableData(){
        System.out.println("Available Departments ==>");
        data.getDepts().forEach(x ->System.out.println("name: "+x.getName()+", courses: "+x.getCourses()));
        System.out.println("\nAvailable Courses ==>");
        data.getCourses().forEach(x->System.out.println("course #: "+x.getNumber()+", name: "+x.getName()+", max # of students: "
                                                         + x.getMaxNumbOfStudents()+", instructor: "+ x.getInstructors()));
        System.out.println("\nAvailable Rooms ==>");
        data.getRooms().forEach(x->System.out.println("room #: "+x.getNumber()+", max seating capacity: "+x.getSeatingCapacity() + ", Room Type: "+ x.getRoomType()));
        System.out.println("\nAvailable Instructors ==>");
        data.getInstructor().forEach(x->System.out.println("id: "+x.getId()+", name: "+x.getName()));
        System.out.println("\nAvailable Meeting Times ==>");
        data.getMeetingsTimes().forEach(x->System.out.println("id: "+x.getid()+", Meeting Time: "+x.getTime()));
        System.out.print("--------------------------------------------------------------------------------");
        System.out.print("-----------------------------------------------------------------------------------");
                
    }
}
