# 🏗️ Singleton Pattern

## 📌 Overview
The **Singleton Pattern** is a **creational design pattern** that ensures **only one instance of a class** exists and provides a **global access point** to that instance.

### **📌 Why Use Singleton Pattern?**
- Ensures that **only one instance** of a class is created.
- Provides a **global access point** to the instance.
- **Saves memory** by preventing unnecessary object creation.
- Used in **logging, configuration management, database connections, thread pools**, etc.

---

## **✅ Ways to Implement Singleton Pattern in Java**
There are **five** common ways to implement the Singleton Pattern:

---

## **1️⃣ Eager Initialization (Thread-Safe)**
```java
public class DBConnection {
    private static final DBConnection conObject = new DBConnection(); // Eagerly initialized

    private DBConnection() {}  // Private constructor

    public static DBConnection getInstance() {
        return conObject;
    }
}

public class Main {
    public static void main(String args[]) {
        DBConnection connObject = DBConnection.getInstance();
    }
}
```
### ✅ **Pros**:  
✔ Simple and easy to implement.  
✔ Thread-safe.  
### ❌ **Cons**:  
✖ Instance is **created at class loading**, even if **not needed**.  

---

## **2️⃣ Lazy Initialization (Not Thread-Safe)**
```java
public class DBConnection {
    private static DBConnection conObject;  // Instance not created initially

    private DBConnection() {}  // Private constructor

    public static DBConnection getInstance() {
        if (conObject == null) {
            conObject = new DBConnection();  // Instance created only when needed
        }
        return conObject;
    }
}

public class Main {
    public static void main(String args[]) {
        DBConnection connObject = DBConnection.getInstance();
    }
}
```
### ✅ **Pros**:  
✔ Saves memory (instance is created only when needed).  
### ❌ **Cons**:  
✖ **Not thread-safe** (Multiple threads may create multiple instances).  

---

## **3️⃣ Thread-Safe Singleton (Synchronized Method)**
```java
public class DBConnection {
    private static DBConnection conObject;

    private DBConnection() {}  // Private constructor

    public static synchronized DBConnection getInstance() {  
        if (conObject == null) {
            conObject = new DBConnection();
        }
        return conObject;
    }
}

public class Main {
    public static void main(String args[]) {
        DBConnection connObject = DBConnection.getInstance();
    }
}
```
### ✅ **Pros**:  
✔ Thread-safe.  
✔ Ensures only **one instance** is created.  
### ❌ **Cons**:  
✖ Performance overhead due to **synchronization** on every method call.  

---

## **4️⃣ Double-Checked Locking (Best Performance for Multi-threaded)**
```java
public class DBConnection {
    private static volatile DBConnection conObject;

    private DBConnection() {}  // Private constructor

    public static DBConnection getInstance() {
        if (conObject == null) {  // First check (without locking)
            synchronized (DBConnection.class) {  // Locking
                if (conObject == null) {  // Second check (inside synchronized block)
                    conObject = new DBConnection();  // Create instance
                }
            }
        }
        return conObject;
    }
}

public class Main {
    public static void main(String args[]) {
        DBConnection connObject = DBConnection.getInstance();
    }
}
```
### ✅ **Pros**:  
✔ **Thread-safe**.  
✔ **Efficient performance** (avoids unnecessary synchronization).  
✔ Uses `volatile` to **prevent instruction reordering**.  
### ❌ **Cons**:  
✖ More **complex** compared to basic approaches.  

---

## **5️⃣ Bill Pugh Singleton (Best for Simplicity & Performance)**
```java
public class DBConnection {
    private DBConnection() {}  // Private constructor

    private static class SingletonHelper {
        private static final DBConnection INSTANCE = new DBConnection();
    }

    public static DBConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

public class Main {
    public static void main(String args[]) {
        DBConnection connObject = DBConnection.getInstance();
    }
}
```
### ✅ **Pros**:  
✔ **Thread-safe** without synchronization.  
✔ **Lazy initialization** (instance is created only when needed).  
✔ **Efficient performance**.  
### ❌ **Cons**:  
✖ Slightly **more complex** than basic methods.  

---

## **🚀 Comparison of Singleton Approaches**
| **Singleton Method**         | **Thread-Safe?** | **Lazy Initialization?** | **Performance** | **Complexity** |
|-----------------------------|----------------|-----------------|----------------|----------------|
| **Eager Initialization**      | ✅ Yes | ❌ No  | ✅ Fast | ⭐ Simple |
| **Lazy Initialization**       | ❌ No  | ✅ Yes | ❌ Slow (Multi-thread issues) | ⭐ Simple |
| **Synchronized Method**       | ✅ Yes | ✅ Yes | ❌ Slow (synchronized calls) | ⭐⭐ Moderate |
| **Double-Checked Locking**    | ✅ Yes | ✅ Yes | ✅ Fast | ⭐⭐⭐ Best for Performance |
| **Bill Pugh Singleton**       | ✅ Yes | ✅ Yes | ✅ Fast | ⭐⭐⭐ Best Overall |

---

## **🎯 Conclusion**
- If **memory is not a concern**, use **Eager Initialization**.
- If **lazy initialization is needed**, use **Bill Pugh Singleton (Best Approach)**.
- If **thread safety is required** with simple implementation, use **Synchronized Method**.
- **Avoid simple Lazy Initialization** if multiple threads access it.
- **For best performance & thread safety**, **use Double-Checked Locking**.

This covers **Singleton Pattern** and **five ways to achieve it**. 🚀 Let me know if you need more details! 😊

