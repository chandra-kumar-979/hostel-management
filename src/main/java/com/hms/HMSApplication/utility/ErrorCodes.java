package com.hms.HMSApplication.utility;

public interface ErrorCodes {
    //Bed User
    String BU001 = "Bed User Not Exist";
    String BU002 = "Bed User is already existed with given email";
    String BU003 = "Bed user has pending due Amount ";
    String BU004 = "Bed user does not have payment details";

    //Bed
    String B001 = "Bed not exist";
    String B002 = "Selected Bed is suspended";
    String B003 = "Bed is already occupied";
    String B004 = "Bed is already available";

    //Floor
    String F001 = "Floor not exist";
    String F002 = "Floor does not contain rooms";

    //Room
    String R001 = "Room not exist";
}
