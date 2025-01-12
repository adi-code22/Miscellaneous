# **Concurrency and the `i++` Problem**

Concurrency issues can turn the simplest of code into a debugging nightmare. This repository explores how race conditions occur in concurrent environments with a simple `i++` operation and demonstrates solutions to address them.

---

## **The Problem**
### What happens when 10 threads execute 1000 iterations of `i++` concurrently?  

A straightforward guess might be:
#### 10 threads * 1000 iterations = 10,000

But the actual result? **Not always!**

### Why?  

The statement `i++;` isn't atomic. It's internally broken down into three operations:  
```assembly
MOV R1, i       ; Load the value of i
ADD R1, R1, 1   ; Increment it
MOV i, R1       ; Write it back to i

The **1st** and **3rd** instructions are **critical sections**, meaning:  
- A thread can be interrupted before completing all steps.  
- This leads to **race conditions**, causing inconsistent results.  

---

## **The Solution**

Here are two approaches to ensure thread safety:

### 1. **Using AtomicInteger**

Java's `AtomicInteger` uses **compare-and-swap (CAS)** to handle updates safely:  
```java
AtomicInteger i = new AtomicInteger(0);
i.incrementAndGet();

### 2. **Use Synchronisation**
Synchronization primitives like `locks` or synchronized blocks prevent concurrent access:
```java
synchronized (lock) {
    i++;
}

---

## **Code Examples**

The repository contains:  
- **Without Fix:** Demonstrates how race conditions occur.  
- **With Fix (AtomicInteger):** Resolves the issue using `AtomicInteger`.

### Key Snippets

#### Without Fix (Race Condition)
```java
int i = 0;

Runnable task = () -> {
    for (int j = 0; j < 1000; j++) {
        i++; // Not thread-safe
    }
};

#### With Fix (Atomic Integer)
```java
AtomicInteger i = new AtomicInteger(0);

Runnable task = () -> {
    for (int j = 0; j < 1000; j++) {
        i.incrementAndGet(); // Thread-safe
    }
};