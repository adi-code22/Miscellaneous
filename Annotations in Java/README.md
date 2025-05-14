

## Custom Annotations in Java Spring Boot

Welcome to the world of custom annotations — where Java meets elegance and Spring Boot becomes even more powerful.

This repository contains practical, real-world examples of how to create and use custom annotations to keep your codebase clean, modular, and expressive.

#### What You’ll Learn

- What annotations are and how they work under the hood

- How to define your own annotation using @interface

- How to configure annotations using @Target, @Retention, and @Documented

- How to hook behavior to annotations using Spring AOP (Aspect-Oriented Programming)


#### Included Annotations

1. @TrackExecutionTime

Measure and log how long a method takes to execute. Ideal for performance profiling.

Example:

```java
@TrackExecutionTime
public void processOrder() {
    // business logic
}
```

2. @RateLimit(limit = 3)

Limit access to a method or API to a specified number of hits. Simple rate limiting with custom behavior.

Example:

```java
@RateLimit(limit = 3)
@GetMapping("/sensitive-data")
public String fetchData() {
    return "Restricted info";
}
```

#### How It Works

Behind the scenes, Spring AOP intercepts annotated methods and injects the behavior at runtime. This keeps your business logic clean while encapsulating cross-cutting concerns like logging and rate limiting.

#### Getting Started

1. Clone the repo

git clone https://inkd.in/gc7rfjyb
cd your-repo-name


2. Build & Run

./mvnw spring-boot:run


3. Try out the endpoints and observe logs or behavior based on annotations!



#### Why Use Custom Annotations?

Clean separation of concerns

Reusability across projects

Abstract boilerplate logic (logging, auth, metrics, etc.)

Impress your teammates with elegance and power


#### Want to Contribute?

Feel free to fork, raise issues, or open pull requests with new ideas for annotations or enhancements!

