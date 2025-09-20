import java.util.*;

/**
 * Class Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 7.0
 */
public class Room {
    public String description;
    public Map<String, Room> exits;
    public static final String NORTH = "north";
    public static final String EAST = "east";
    public static final String SOUTH = "south";
    public static final String WEST = "west";
    public static final String UP = "up";
    public static final String DOWN = "down";

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public Room getExits(String direction) {
        return exits.get(direction);

    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     *
     * @param direction the exit to another room
     * @param aRoom  the room related to the exit
     *
     */
    public void setExit(String direction, Room aRoom) {
//        if (direction.equals(NORTH)) {
//            exits.put(NORTH, aRoom);
//        }
//        if (direction.equals(SOUTH)) {
//            exits.put(SOUTH, aRoom);
//        }
//        if (direction.equals(EAST)) {
//            exits.put(EAST, aRoom);
//        }
//        if (direction.equals(WEST)) {
//            exits.put(WEST, aRoom);
//        }
        exits.put(direction, aRoom);



    }

    //passing one direction and the reason why


    /**
     * @return The description of the room.
     */
    public String getDescription() {
        //there must be a change here
        return description;
    }

    public void printLongDescription() {
        Set <String> exceptUpDown = exits.keySet();
        if (!(exceptUpDown.contains(NORTH)) && !(exceptUpDown.contains(SOUTH)) && !(exceptUpDown.contains(EAST)) && !(exceptUpDown.contains(NORTH))) {
            Room exitRoom = null;
            for (String key : exceptUpDown) {
                exitRoom = exits.get(key);
            }
            System.out.println("You are " + exitRoom.getDescription());

        } else {
            System.out.println("You are " + this.getDescription());
        }

        System.out.print("Exits: ");
        for (String key : exits.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
