package com.company;

public class Main {

    public static void main(String[] args) {
	    // Паттерн засовывает все сервисы с вызавми в один объект
        // (ни чем не отличается от остольных патернов, только название)
        
        BusinessObject businessObject = new BusinessObject();
        System.out.println(businessObject.getUser().getName());
    }
}

class User {
    String name = "No name";
    int age;

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
}

interface Service{
    User getUser();
}

class ServiceEJB implements Service{
    @Override
    public User getUser() {
        return new User();
    }
}

class BusinessObject {
    ServiceEJB serviceEJB = new ServiceEJB();
    public User getUser() {
        return serviceEJB.getUser();
    }
}