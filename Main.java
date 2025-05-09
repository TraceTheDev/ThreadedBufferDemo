package p1;

import java.util.Random;

class ThreadedBuffer {
	public static void main(String[] args) {
		
		Buffer buffer = new Buffer(new int[10]);
		Thread producerThread = new Thread(new ProducerTask(buffer));
		Thread consumerThread = new Thread(new ConsumerTask(buffer));

		System.out.println("Buffer created and Producer/Consumer threads are ready to execute.");

		producerThread.start();
		consumerThread.start();
	}
}


////////////////// THREAD TASKS //////////////////
class ConsumerTask implements Runnable {
	
	private Buffer buffer;
	
	ConsumerTask(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				buffer.consume();
				Thread.sleep(100);
			}
		}
		catch (InterruptedException ex) {
			System.out.print("IE occured: ");
			ex.printStackTrace();
		}
	}
}

class ProducerTask implements Runnable {
	
	private Buffer buffer;
	
	ProducerTask(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				buffer.produce();
				Thread.sleep(100);
			}
		}
		catch (InterruptedException ex) {
			System.out.print("IE occured: ");
			ex.printStackTrace();
		}
	}
}

///////////////////// BUFFER /////////////////////
class Buffer {
	private final int BUFFER_CAPACITY = 10; // total elements buffer can hold
	private final int EMPTY = 0; // used to determine if index is empty
	private final int FULL = 1; // used to determine if index is full
	private int[] buffer;
	private int index; // current location in buffer for consumption/production

	Buffer(int[] buffer) {
		this.buffer = buffer;
		index = 0;
	}
	
	public synchronized void consume() throws InterruptedException {
		int totalConsumptions = new Random().nextInt(BUFFER_CAPACITY)+1;
		System.out.println("\n<!> Consumer will now attempt to consume " + totalConsumptions + " items from the buffer <!>");
		
		// PERFORM n TOTAL PRODUCTIONS; CAN EASILY AVOID ANY ATTEMPTS AT PRODUCTIONS PAST BUFFER_CAPACITY, BUT THIS IS FOR PROJECT TEST-CASE PURPOSE
		for (int i=0; i<totalConsumptions; i++) {
			// HANDLER - EMPTY BUFFER
			if (index < 0) {
				System.out.println("<!> Consumer halted due to an empty buffer <!>");
				index++;
				wait();
				System.out.println("\n<!> Consumer Resumed: will now attempt to continue consuming remaining " + (totalConsumptions-i) + " items from the buffer <!>"); // TEST PURPOSES
			}
			
			
			// HANDLER - INDEX IS EMPTY
			if (buffer[index] == EMPTY) {
				i--;
			}
			// HANDLER - INDEX IS FULL
			else if (buffer[index] == FULL) {
				buffer[index] = EMPTY;
				System.out.println("Consumed buffer index " + index);
			}
			

			Thread.sleep(1000); // delay purely for display purposes
			
			if (i!=totalConsumptions-1) index--;
		}
		
		// NOTIFY CONSUMER IN CASE IT'S WAITING
		notify();
		
	}
	
	public synchronized void produce() throws InterruptedException {
		int totalProductions = new Random().nextInt(BUFFER_CAPACITY)+1;
		System.out.println("\n<!> Producer will now attempt to produce " + totalProductions + " items to the buffer <!>");
		
		// PERFORM n TOTAL PRODUCTIONS; CAN EASILY AVOID ANY ATTEMPTS AT PRODUCTIONS PAST BUFFER_CAPACITY, BUT THIS IS FOR PROJECT TEST-CASE PURPOSE
		for (int i=0; i<totalProductions; i++) {
			
			// HANDLER - FULL BUFFER
			if (index >= BUFFER_CAPACITY) {
				System.out.println("<!> Producer halted due to a full buffer <!>");
				index--;
				wait();
				System.out.println("\n<!> Producer Resumed: will now attempt to continue producing remaining " + (totalProductions-i) + " items to the buffer <!>"); // TEST PURPOSES
			}
			
			
			// HANDLER - INDEX IS FULL
			if (buffer[index] == FULL) {
				i--;
			}
			// HANDLER - INDEX IS EMPTY
			else if (buffer[index] == EMPTY) {
				buffer[index] = FULL;
				System.out.println("Produced buffer index " + index);
			}
			
			Thread.sleep(1000); // delay purely for display purposes
			
			if (i!=totalProductions-1) index++;
		}
		
		// NOTIFY CONSUMER IN CASE IT'S WAITING
		notify();
	}
}
