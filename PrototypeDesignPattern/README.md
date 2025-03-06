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
