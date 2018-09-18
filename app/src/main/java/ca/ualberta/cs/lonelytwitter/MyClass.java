package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shaiful on 17/09/18.
 */

public class MyClass {

private String name;
private int salary;

  public MyClass(String name, int salary){
      this.name=name;
      this.salary=salary;
  }
  public MyClass(String name){
        this.name=name;
        this.salary=10;
  }

  public void setName(String name){
      this.name=name;

  }

  public String getName(){
      return this.name;
  }

  public void setSalary(int salary){
      this.salary=salary;

  }
  public int getSalary(){
      return this.salary;
  }
}
