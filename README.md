# ThreadedBufferDemo

A simple Java-based multithreaded program that simulates the producer-consumer problem using a synchronized buffer. This project demonstrates thread coordination, shared memory access, and buffer state tracking in real time. Ideal for learning basic concurrency and thread safety in Java.

---

## Project Structure

```
BufferPractice/
├── src/
│   └── p1/
│       └── Main.java
└──
```

---

## Core Java Classes

### `Main.java`
Contains all logic for:
- Initializing a fixed-size buffer
- Running one producer and one consumer thread
- Displaying real-time buffer activity to the console

---

## How to Run

Compile and run using any Java-compatible IDE (like Eclipse or IntelliJ), or from the command line:

```bash
javac src/p1/Main.java
java -cp src p1.Main
```

---

## Future Enhancements
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
- GitHub: [TraceTheDev](https://github.com/TraceTheDev)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
