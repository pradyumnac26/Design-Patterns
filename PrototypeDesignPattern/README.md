# 🏗️ Prototype Design Pattern

## 📌 Overview
The **Prototype Pattern** is a **creational design pattern** that allows us to **create new objects by copying (cloning) an existing object**, rather than **creating them from scratch**.  

This pattern is useful when **object creation is expensive, slow, or complex**, and we need multiple instances of similar objects.

---

## 🚨 **Issues Without Prototype Pattern**
When we create objects **without using the Prototype Pattern**, we might face several issues:

### **1️⃣ Object Creation is Expensive**
- Some objects take **a long time to initialize** due to heavy computations, database queries, or API calls.
- Creating a new object from scratch every time **wastes time and resources**.

❌ **Example Without Prototype:**  
```java
class ExpensiveObject {
    public ExpensiveObject() {
        System.out.println("Loading data from the database...");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}  // Simulate slow DB fetch
    }
}

public class WithoutPrototype {
    public static void main(String[] args) {
        ExpensiveObject obj1 = new ExpensiveObject();
        ExpensiveObject obj2 = new ExpensiveObject(); // Takes another 3 seconds
    }
}
```

## ✅ Use Prototype Pattern
We solve this by **implementing the `Prototype` interface** and providing a `clone()` method **inside the class**.

### **1️⃣ Define the Prototype Interface**
```java
interface Prototype {
    Prototype clone();
}
```

---

### **2️⃣ Implement the `Student` Class with Cloning**
```java
class Student implements Prototype {
    public String name;
    public int age;
    private int rollNumber;  // Private field (can't access directly)

    public Student(String name, int age, int rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    // Implement clone() method
    @Override
    public Student clone() {
        return new Student(this.name, this.age, this.rollNumber);
    }

    public void display() {
        System.out.println("Student: Name=" + name + ", Age=" + age + ", RollNumber=" + rollNumber);
    }
}
```

---

### **3️⃣ Client Code: Cloning a Student**
```java
public class PrototypeDemo {
    public static void main(String[] args) {
        // Create an original student
        Student original = new Student("Alice", 21, 101);

        // Clone the student
        Student clonedStudent = original.clone();

        // Modify the clone
        clonedStudent.name = "Bob";  // Only changing name

        // Display both objects
        original.display();
        clonedStudent.display();
    }
}
```

📌 **Output:**
```makefile
Student: Name=Alice, Age=21, RollNumber=101
Student: Name=Bob, Age=21, RollNumber=101
```

✅ **What happens here?**
- The **original student remains unchanged**.
- The **cloned student has the same roll number** but a **different name**.
