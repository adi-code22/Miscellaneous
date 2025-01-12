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