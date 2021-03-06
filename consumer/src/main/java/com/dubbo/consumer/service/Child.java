package com.dubbo.consumer.service;

/**
 * Author:zhangp
 * Date:2021/1/28 23:05
 * Description:
 */
public class Child extends UserService implements Cloneable{
    private String name;
    private Integer age;

    public Child(String name) {
        this.name = name;
    }

    public Child(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello(String str){
        System.out.println(str);
    }

    protected void shop(){

        System.out.println("购物！");

    }

    private void sayPrivate(String str){
        System.out.println(str);
    }



    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Child child = new Child("jj");
        Child clone = (Child) child.clone();
        System.out.println(child.equals(clone));
        System.out.println(child == clone);

    }
}
