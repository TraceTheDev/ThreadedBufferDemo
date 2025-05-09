# ThreadedBufferDemo

A Java program that simulates the producer-consumer problem using a synchronized buffer shared between two threads. It demonstrates multithreading and real-time tracking of buffer activity.

---

## Project Structure

```
ThreadedBufferDemo/
├── src/
│   └── p1/
│       └── Main.java         # Contains ProducerTask, ConsumerTask, Buffer, and 
└──
```

---

## Key Components

### `Main.java`
- Initializes a buffer of size 10.
- Launches two threads: one producer and one consumer.
- Demonstrates thread synchronization with `wait()` and `notify()`.

### `Buffer`
- A shared array buffer accessed by both producer and consumer threads.
- Uses synchronized methods to ensure safe access and control flow.
- Randomly determines the number of items to produce or consume.
  
### `ProducerTask` / `ConsumerTask`
- Runnable tasks that repeatedly call the buffer's produce or consume methods.
- Simulates thread behavior with sleep delays and conditional handling of full/empty buffer scenarios.

---

## How to Run

1. Open the project in an IDE like **Eclipse** or **IntelliJ**.
2. Ensure Java SE 17 is set as the project SDK.
3. Run the `Main.java` file from package `p1`.

---

## Future Ideas

- Add a GUI visualization of buffer activity.
- Support multiple producer and consumer threads.
- Implement logging to track statistics like total items produced and consumed.
- Add configuration options for buffer size and thread sleep duration.
  
---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author  
**Trace Davis**  
- GitHub: [Trace0727](https://github.com/Trace0727)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
