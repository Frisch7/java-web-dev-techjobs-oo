package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        this.id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
    public static boolean areAllEqual(String checkValue, String... otherValues)
    {
        for (String value : otherValues)
        {
            if (value != checkValue)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String coreCompetencyValue, employerValue, locationValue, positionValue, nameValue;



        if(coreCompetency == null || coreCompetency.getValue().isEmpty()){ coreCompetencyValue = "Data not available"; }else{
            coreCompetencyValue = coreCompetency.getValue(); }
        if(location == null || location.getValue().isEmpty()){ locationValue = "Data not available"; }else{
            locationValue = location.getValue(); }
        if(employer == null || employer.getValue().isEmpty()){ employerValue = "Data not available"; }else{
            employerValue = employer.getValue(); }
        if(positionType == null || positionType.getValue().isEmpty()){ positionValue = "Data not available"; }else{
            positionValue = positionType.getValue(); }
        if(name == null || name.isEmpty()){ nameValue = "Data not available";}else{
            nameValue = this.name;
        }
        if(areAllEqual(coreCompetencyValue, employerValue, locationValue, positionValue, nameValue)){
            return "OOPS! This job does not seem to exist.";
        }

        return "\nID: "+id +"\n" +
                "Name: "+ nameValue +"\n" +
                "Employer: "+ employerValue +"\n" +
                "Location: "+ locationValue + "\n" +
                "Position Type: "+ positionValue + "\n" +
                "Core Competency: "+ coreCompetencyValue + "\n";

    }
}
