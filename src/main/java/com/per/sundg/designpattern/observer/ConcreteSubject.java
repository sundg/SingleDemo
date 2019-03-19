package com.per.sundg.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * <br>
 *
 * @ClassName: PublishPerson
 * @Description: 观察者模式:被观察者（发布者）
 * @Author sundg
 * @Date 2019/3/19 9:16
 * @VERSION 1.0
 */
public class ConcreteSubject implements Subject {

    List<Observer> list = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Spliterator<Observer> spliterator = list.stream().spliterator();
        while (spliterator.tryAdvance(observer -> observer.getMessage("今天家里就我一个人，你们过来吧，谁先过来谁就能得到我!")));
    }




  /*  List<Subject> list = new ArrayList<Subject>();

    public void addPerson(Person person){
        list.add(person);
    }

    public void notifyPerson() {
        Spliterator<Person> persons = list.stream().spliterator();
        while (persons.tryAdvance(person -> person.getMessage("今天家里就我一个人，你们过来吧，谁先过来谁就能得到我!")));
    }*/
}
