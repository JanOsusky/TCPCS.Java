# TCP Client-Server Ticket Booking System

This is a Java implementation of a simple TCP client-server ticket booking system. The system allows clients to request a certain number of tickets by sending a message to the server, and the server responds with a booking confirmation or an error message.

## ClientTCP

The `ClientTCP` class represents the client-side of the application. It establishes a connection with the server, sends a request for booking tickets, and receives the server's response.

To run the client:

1. Open the code file named `ClientTCP.java` in a Java IDE or text editor.
2. Modify the `serverName` and `serverPort` variables with the appropriate values.
3. Compile and run the `ClientTCP.java` file.

## ServerTCP

The `ServerTCP` class represents the server-side of the application. It listens for incoming connections from clients, receives booking requests, processes them, and sends back a response.

To run the server:

1. Open the code file named `ServerTCP.java` in a Java IDE or text editor.
2. Modify the `port` variable with the appropriate port number.
3. Compile and run the `ServerTCP.java` file.

## Ticket Booking Logic

The `booking` method in the `ServerTCP` class contains the logic for processing the booking request. It randomly generates a success or failure message based on a random number. If the random number is less than 0.8, the booking is considered successful; otherwise, an error message is returned.

## Dependencies

No external dependencies are required for this application. It uses standard Java libraries for socket communication.

## Usage

1. Start the server by running the `ServerTCP` class.
2. Start the client by running the `ClientTCP` class.
3. Follow the prompts in the client console to enter the number of tickets and the name of the person for whom the tickets are being booked.
4. The client sends the request to the server, and the server processes it.
5. The server sends the booking confirmation or error message back to the client.
6. The client displays the server's response on the console.

## Note

The code includes comments explaining the functionality of each method and important considerations.

