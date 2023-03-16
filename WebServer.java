// Name: Nayashree Budhihal Mutt
// UTA Id: 1001965572


import java.io.* ; 
import java.net.* ; 
import java.util.* ; 

public final class WebServer{

    static int port_num= 5500;  // initializing the port number 

    // defining sockets for server and client 
    static ServerSocket server=null;
    static Socket client=null;

    // defining the main class
    public static void main(String args[]){

        // using try, catch block to display error message if the port number is not accessible 
        try{
            // to get the access to portnumber 
            server = new ServerSocket(port_num); 
        }

        catch(IOException error){
            // to display error message if access to port number is not achieved 
            System.out.println(error);
        }

        // process HTTP service requests in an infinite loop  
        while(true){
        
            try{
            // listen for a TCP connection request 
            client=server.accept();
            System.out.println("Connected to Client");
            
            // Construct an object to process the HTTP request message. 
            HttpRequest request = new HttpRequest( client ); 
            
             // Create a new thread to process the request.
             Thread thread = new Thread(request);
             
            // Start the thread.
             thread.start(); 
            }
            catch (IOException e) {
				
				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}	

        }
    }
}

