import java.io.*;
import java.net.Socket;


public class ClientTCP {

    public static void main(String[] args) throws IOException {
        // SERVER DATA:
        String serverName = null;
        Integer serverPort = null;

        // SOCKET
        Socket serviceSocket = null;

        // SEND AND REPLY STREMS
	    PrintWriter out = null;
        BufferedReader in = null;

        // Create socket and connect to server
        try {
            serviceSocket = new Socket(serverName, serverPort);
        } catch (IOException e) {
            System.err.println("ERROR: cannot connect to " + serverName + ":" + serverPort);
            System.exit(1);
        }

        // Initialize the input/output streams of the connected socket in the PrintWriter and BufferedReader variables
        try {
            out = new PrintWriter( serviceSocket.getOutputStream(), true);
            in = new BufferedReader( new InputStreamReader(serviceSocket.getInputStream()) );
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + serverName);
            System.exit(1);
        }

        System.out.println("STATUS: Connected to the server ");

        // Obtain text by keyboard
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        try {
            System.out.println("Number of tickets: ");
            userInput = stdIn.readLine(); /*STRING STORED IN userInput*/
            System.out.println("Name of the person to whom the tickets go: ");
            userInput += stdIn.readLine(); /*STRING STORED IN userInput*/

            // Sends text in userInput to the server via the output stream of the connected socket
            out.println(userInput);

            System.out.println("STATUS: Sending " + userInput); // displays the sent text on the screen
            System.out.println("STATUS: Waiting for the reply"); //  displays status on the screen

            //* TODO: Receive text sent by the server through the input stream of the connected socket
            String line = null;
            line = in.readLine();

            System.out.println("Reply received: " + line); // displays the received echo on the screen
        }catch (IOException e){
            System.out.println("ERROR: Reply/send: "+ e.getMessage());
        }

        // Exit
        System.out.println("STATUS: Closing connection");
        System.out.print("STATUS: Closing ...");
        //* TODO Close streams and socket
        out.close();
        in.close();
        stdIn.close();
        serviceSocket.close();

        System.out.println(" closed");
    }
}
