//this is representing a course with a specific department that is schedulled to be taught by a specific instructor in a specific meeting time in a specific room
package rgu.ac.csdm.uk.domain;

public class Class {
  // The Class class will have the following attributes...
    private int id;
    private Department dept;
    private Course course;
    private Instructor instructor;
    private MeetingTime meetingTime;
    private Room room;
    //the constructor for the Class will be as follows...
    public Class (int id, Department dept, Course course){
        this.id = id;
        this.course = course;
        this.dept = dept;
    
    
    
    }
    public void setInstructor (Instructor instructor){this.instructor = instructor;}
    public void setMeetingTime (MeetingTime meetingTime){this.meetingTime = meetingTime;}
    public void setRoom(Room room){this.room = room;}
    //get method that returns
    public int getId(){return id;}
    public Department getDept(){return dept;}
    public Course getCourse(){return course;}
    public Instructor getInstructor(){return instructor;}
    public MeetingTime getMeetingTime(){return meetingTime;}
    public Room getRoom(){return room;}
    @Override
    public String toString(){
        return "["+dept.getName()+", "+course.getNumber()+", "+room.getNumber()+", "+instructor.getId()+", "
                + ","+meetingTime.getid()+"]";
    }   
}