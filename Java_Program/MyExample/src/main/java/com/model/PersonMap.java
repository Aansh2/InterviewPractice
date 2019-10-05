package com.model;

public class PersonMap {

  private int id;
  private String name;

  public PersonMap(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int hashCode() {
    System.out.println("called hashCode for =" + id + "." + name);
    return id;
  }

  public boolean equals(Object obj) {
    System.out.println(
        "called equals on ="
            + id
            + "."
            + name
            + "  to compare with  = "
            + ((PersonMap) obj).getId()
            + "."
            + ((PersonMap) obj).getName());
    boolean result = false;
    if (obj instanceof Person) {
      if (((PersonMap) obj).getId() == id && ((PersonMap) obj).getName().equals(name))
        result = true;
    }
    return result;
  }

  public String toString() {
    return id + " - " + name;
  }
}
