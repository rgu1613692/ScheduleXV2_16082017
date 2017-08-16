//representing the meeting time for various courses
package rgu.ac.csdm.uk.domain;

public class MeetingTime {
    private String id;
    private String time;
    public MeetingTime(String id, String time){
        this.id = id;
        this.time = time;
    }
  //get methods that returns them as below...
    public String getid(){return id;}
   public String getTime(){return time;}
}