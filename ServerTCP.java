import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerTCP {

    public static String booking(String s){
        String res = "";
        String [] ERRORS = {"Sold out", "System error", "Try again later", "Request error"};
        double random = Math.random();
        if (random < 0.8)
            res = "Successfull booking";
        else res = "Failed booking: " + ERRORS[new Random().nextInt(ERRORS.length)];

        return res;
    }

    public static void main(String[] args) throws IOException {
        Integer port = null;
        // SOCKETS
        ServerSocket server = null; // Pasive (requests receiving)
        Socket client = null;       // Active (attending a client)

        // SEND/REPLY STREAMS
        BufferedReader in = null;
        PrintWriter out = null;

        // Creates and initializes the server socket (passive socket)
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("ERROR: Could not listen on port "+port);
            System.exit(-1);
        }

        while (true) // Reception loop of incoming connections
        {
            System.out.println("STATUS: Waiting for clients");
            // Wait for incoming connections
            try {
                client = server.accept();
            } catch (IOException e) {
                System.out.println("Accept failed: "+ port);
                System.exit(-1);
            }
		    // Once a connection is accepted, initialize input/output streams of the connected socket
            try {
                out = new PrintWriter( client.getOutputStream(), true);
                in = new BufferedReader( new InputStreamReader(client.getInputStream()) );
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for " + client.getRemoteSocketAddress());
                System.exit(1);
            }
            System.out.println("STATUS: Client connected from: " + client.getRemoteSocketAddress());

            try{
                Integer requests = 0; // Number of tickets ordered by the customer
                String line = null;

                line = in.readLine();
                System.out.println("STATUS: Received from client " + line);
                requests += Character.getNumericValue(line.charAt(0));

                line = booking(line);
                out.println(line);
                System.out.println("STATUS: Sending to client " + line);
            }catch (IOException e){
                System.out.println("ERROR: Receive/send: "+ e.getMessage());
            }

            System.out.println("STATUS: Closing connection with the client");
            //* TODO: Close streams and socket
            in.close();
            out.close();
            client.close();
        } // loop ends
    } // method ends
}
