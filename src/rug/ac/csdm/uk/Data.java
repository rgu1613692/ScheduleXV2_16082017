//Data class will contain and initialize all the data
package rug.ac.csdm.uk;
import java.util.ArrayList;
import java.util.Arrays;
import rgu.ac.csdm.uk.domain.Course;
import rgu.ac.csdm.uk.domain.Department;
import rgu.ac.csdm.uk.domain.Instructor;
import rgu.ac.csdm.uk.domain.MeetingTime;
import rgu.ac.csdm.uk.domain.Room;

public class Data {//will have arraylist of room,instructors, courses, depts, & meetingTime
    private ArrayList<Room> rooms;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> depts;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClasses = 0; //keeping track of the number of classes
    public Data() {initialize();}
    private Data initialize(){
        Room room1 = new Room("R1", 25, "Lab");
        Room room2 = new Room("R2", 45, "Lecture");
        Room room3 = new Room("R3", 35, "Tutotrial");
     /* Room room1 = new Room("N424", 24);
        Room room2 = new Room("N523", 24);
        Room room3 = new Room("525", 30); 
        Room room4 = new Room("527", 30);
        Room room5 = new Room("N528", 60);
        Room room6 = new Room("N530", 50);
        Room room7 = new Room("N533", 116);*/ 
        rooms=  new ArrayList<>(Arrays.asList(room1, room2, room3));
        MeetingTime meetingTime1 = new MeetingTime("MT1", "MWF 09:00 - 10:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "MWF 10:00 - 11:00");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "TTH 09:00 - 10:30");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "TTH 10:30 - 12:00");
        meetingTimes= new ArrayList<>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4));
        Instructor instructor1 = new Instructor ("I1", "Dr James Web");
        Instructor instructor2 = new Instructor ("I2", "Mr. Mike Brown");
        Instructor instructor3 = new Instructor ("I3", "Dr Steve Day");
        Instructor instructor4 = new Instructor ("I4", "Mrs Jane Doe");
        instructors = new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2, instructor3, instructor4));
        Course course1 = new Course ("C1", "325K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2)), 25);
        Course course2 = new Course ("C2", "319K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2, instructor3)), 35);
        Course course3 = new Course ("C3", "462K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2)), 25);
        Course course4 = new Course ("C4", "464K", new ArrayList<Instructor>(Arrays.asList(instructor3, instructor4)), 30);
        Course course5 = new Course ("C5", "360C", new ArrayList<Instructor>(Arrays.asList(instructor4)), 35);
        Course course6 = new Course ("C6", "303K", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor3)), 45);
        Course course7 = new Course ("C7", "303L", new ArrayList<Instructor>(Arrays.asList(instructor2, instructor4)), 45);
        courses = new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5, course6, course7));
        Department dept1 = new Department("MATH", new ArrayList<Course>(Arrays.asList(course1, course3)));
        Department dept2 = new Department("EE", new ArrayList<Course>(Arrays.asList(course2, course4, course5)));
        Department dept3 = new Department("PHY", new ArrayList<Course>(Arrays.asList(course6, course7)));
        depts = new ArrayList<Department>(Arrays.asList(dept1, dept2, dept3));
        depts.forEach(x-> numberOfClasses += x.getCourses().size());//calculate total number of classes
        
        return this;
        
    }
    
    public ArrayList<Room> getRooms(){return rooms;}
    public ArrayList<Instructor> getInstructor(){return instructors;}
    public ArrayList<Course> getCourses(){return courses;}
    public ArrayList<Department> getDepts() {return depts;}
    public ArrayList<MeetingTime> getMeetingsTimes() {return meetingTimes;}
    public int getNumberOfClasses(){return this. numberOfClasses;}
}