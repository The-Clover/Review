package demo;

import com.google.common.collect.ImmutableList;

import java.io.*;
import java.util.List;

class Student implements Cloneable, Serializable {
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneLearning {
    public static void main(String[] args) throws CloneNotSupportedException {
        // JDK 浅拷贝
        Student student1 = new Student("John", 20);
        Student clone = (Student) student1.clone();
        System.out.println(clone);
        // 创建包含对象的Guava的ImmutableList
        List<Student> originalList = ImmutableList.of(new Student("John", 20),
                new Student("Jane", 30));
        // 使用字节流数组进行序列化和反序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 序列化到内存流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(originalList);
            oos.close();

            // 获取序列化后的字节数组
            byte[] serializedBytes = baos.toByteArray();

            // 从内存流反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedBytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            List<Student> deserializedList = (List<Student>) ois.readObject();
            ois.close();

            // 输出反序列化后的列表
            System.out.println("original list: " + originalList);
            System.out.println("deserialized list: " + deserializedList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
