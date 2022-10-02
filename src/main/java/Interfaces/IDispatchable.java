package Interfaces;

import CommonClasses.EmergencyServiceType;

import java.util.List;
/*
*   Interface to simulate comunication between our dispatch system and
*   other organizations like fire departament, police force or medical assistance.
*   These organizations could have incompatible computer systems, that's what this interface will be used for.
*   Returning String list is a text representation of all units dispatched to the incident
* */
public interface IDispatchable {
    List<String> dispatchUnits(String incident);
    EmergencyServiceType getType();
}
