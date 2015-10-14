/**
 * Created by Morgan on 14/10/2015.
 * Project name : GestParapente.
 */
public class Person {

    private String name;
    private String lastName;
    private String adress;
    private int age;

    public Person(String name, String lastName, String adress, int age){
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getAdress(){
        return this.adress;
    }

    public int getAge(){
        return this.age;
    }

}
