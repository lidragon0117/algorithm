package com.lilong.arraylist;

/**
 * @author :lilong
 * @date :2023/1/24-10:04
 * @description :
 */
public class MainTest {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList();
        Person person1 = new Person(10,"zhangsan");
        Person person2 = new Person(9,"zhangsan");
        Person person3 = new Person(8,"zhangsan");
        Person person4 = new Person(7,"zhangsan");
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4);
        arrayList.remove(1);
        arrayList.clear();
//        arrayList.add(1);
//        arrayList.add(12);
//        arrayList.add(14);
//        arrayList.add(13);
//        arrayList.add(15);
//        arrayList.add(7);
//        arrayList.add(9);
//        arrayList.add(0,19);
//        System.out.println(arrayList.indexOf(12));
//        arrayList.set(0,17);
        System.out.println(arrayList);
    }
}
