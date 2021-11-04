import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class projectClientCode {
	
	
//testing to make sure that the pull works as expected with the new egit install
	//and testing the push...
	static class GameProject implements Runnable {
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		
		GameProject(DataOutputStream outToServer,BufferedReader inFromServer){
			this.outToServer = outToServer;
			this.inFromServer = inFromServer;
		}

		
		//run() contents just copied from ChatServerCode to just have a basic model
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					String modifiedMessage;
					modifiedMessage = inFromServer.readLine();
					System.out.println(modifiedMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					break;
				}
			}
		}
	}
	

		
	public static void main(String argv[]) throws Exception {
		// TODO Auto-generated method stub
		Socket connectionSocket = new Socket("10.220.35.205", 1234);
		
		DataOutputStream outToServer = new DataOutputStream(connectionSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		System.out.println("Client Running...");
	}

}

