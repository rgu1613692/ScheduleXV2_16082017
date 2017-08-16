//where the couse will be thought
package rgu.ac.csdm.uk.domain;

public class Room {
   // The Room will have numbers and seating capacity attributes as follows...
    private String number;
    private int seatingCapacity;
    private String roomType;
    // the constructor will be as below
    public Room (String number, int seatingCapacity, String roomT){
        this.number = number;
        this.seatingCapacity = seatingCapacity;
        this.roomType= roomT;
    }
    // get methods to retrive them as below...
    public String getNumber(){return number;}
    public int getSeatingCapacity() {return seatingCapacity;}
    public String getRoomType(){return roomType;}

}
