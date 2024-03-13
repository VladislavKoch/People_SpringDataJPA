package ru.vladkochur.spring.models;



import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    @NotEmpty(message = "You must write name")
    @Size(min = 2, max = 30, message = "Name length less than 2 or larger than 30")
    private String name;


    @Column(name = "age")
    @Min(value = 0, message = "Age must be 1+")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "You must write email")
    @Email(message = "Email is not correct")
    private String email;

    @Column(name = "address")
    @Pattern(regexp = "^(.*?)\\s*,\\s*(.*?)\\s*,\\s*(\\d{6})$", message = "Wright Country, City, Index like 000000")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPersonByAnotherPerson(Person person) {
        this.name = person.getName();
        this.age = person.getAge();
        this.email = person.getEmail();
        this.address = person.getAddress();
    }

    public Person() {
    }


}
