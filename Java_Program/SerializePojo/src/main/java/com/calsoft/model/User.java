package com.calsoft.model;

public class User {
    private String firstName ;
    private Location location ;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override public String toString() {
       String locationS = "{" + "city='" + location.getCity() + '\'' + ", state='" + location.getState() + '\'' + ", pin=" + location.getState() + '}';
        return "User{" + "firstName='" + firstName + '\'' + ", location=" + locationS + '}';
    }
}
