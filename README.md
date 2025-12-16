# 🚀 High-Performance Concurrent Key-Value Store (Java)

A **thread-safe, in-memory Key-Value Store** built in Java that supports **concurrent request processing**, **LRU eviction**, and **clean separation of concerns**, inspired by real-world backend systems used at scale.

This project demonstrates **core systems engineering fundamentals** including concurrency, caching strategies, synchronization, and executor-based server design.

---

## 🧠 System Overview

The system simulates a **multi-threaded server** that processes concurrent `SET`, `GET`, and `DELETE` requests using a **fixed thread pool**, backed by an **LRU cache** to efficiently manage memory usage.

### Key Characteristics

* Concurrent request handling via `ExecutorService`
* Thread-safe LRU cache using `LinkedHashMap`
* Clean modular design (Server, Store, Cache)
* Deterministic eviction with **Least Recently Used (LRU)** policy
* Production-style locking and synchronization

---

## 🏗 Architecture

```
                ┌────────────────────┐
                │   Client Requests   │
                └─────────┬──────────┘
                          │
                          ▼
                ┌────────────────────┐
                │  ServerSimulator    │
                │ (Thread Pool)       │
                └─────────┬──────────┘
                          │
                          ▼
                ┌────────────────────┐
                │     KVStore         │
                │ (Business Logic)    │
                └─────────┬──────────┘
                          │
                          ▼
                ┌────────────────────┐
                │     LRUCache        │
                │ (Thread-Safe Cache)│
                └────────────────────┘
```

---

## ⚙️ Core Features

### ✅ Concurrent Request Processing

* Uses `ExecutorService` with configurable thread pool size
* Requests are processed asynchronously
* Demonstrates non-deterministic execution order (real-world behavior)

### ✅ Thread-Safe LRU Cache

* Built using `LinkedHashMap` with access-order enabled
* Automatic eviction on capacity overflow
* Protected using `ReentrantLock`

### ✅ Clean Separation of Concerns

| Component         | Responsibility                            |
| ----------------- | ----------------------------------------- |
| `ServerSimulator` | Accepts and schedules concurrent requests |
| `RequestHandler`  | Encapsulates request execution            |
| `KVStore`         | Business logic layer                      |
| `LRUCache`        | Caching and eviction policy               |
| `Main`            | Entry point and test driver               |

---

## 🧩 Implementation Details

### LRU Eviction Logic

```java
new LinkedHashMap<>(capacity, 0.75f, true) {
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > capacity;
    }
};
```

### Thread Safety

* All cache operations (`get`, `put`, `remove`) are protected via `ReentrantLock`
* Prevents race conditions under concurrent access

---

## ▶️ How to Run

### Prerequisites

* Java 17+ (or Java 11+)
* VS Code / IntelliJ / Terminal

### Steps

```bash
cd src
javac *.java
java Main
```

### Sample Output

```text
GET B -> 2
GET A -> 1
GET A -> null
```

> Output order may vary due to concurrent execution — this is expected behavior.

---

## 🧪 Example Test Scenario

```java
server.submitRequest("SET", "A", "1");
server.submitRequest("SET", "B", "2");
server.submitRequest("GET", "A", null);
server.submitRequest("SET", "C", "3"); // Evicts B
server.submitRequest("GET", "B", null); // null
server.submitRequest("GET", "A", null); // 1
```

---

## 🧠 What This Project Demonstrates

* Systems-level thinking
* Concurrency & synchronization
* Cache eviction strategies
* Java threading primitives
* Real-world backend design patterns

This project is **designed to be discussed in software engineering interviews**, particularly for **FAANG-style backend and systems roles**.

---

## 🚀 Future Enhancements

* [ ] Disk-backed persistence
* [ ] TTL (time-based expiration)
* [ ] REST API interface (HTTP server)
* [ ] Metrics & logging
* [ ] Stress testing with high concurrency
* [ ] Distributed KV store (sharding + replication)

---

## 👤 Author

**Nimarjot Kaur**
📧 Email: [nimarjotk@gmail.com](mailto:nimarjotk@gmail.com)
🔗 GitHub: [github.com/Nimarjot1](https://github.com/Nimarjot1)
🔗 LinkedIn: [linkedin.com/in/nimarjot-kaur-03039b273](https://www.linkedin.com/in/nimarjot-kaur-03039b273/)

---
