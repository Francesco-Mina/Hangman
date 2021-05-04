/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class HangmanServer {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	  int port = 8888;
    	  ServerSocket serverSocket = new ServerSocket(port);
    	  System.out.println("EchoServer: started ");
    	  Socket clientSocket=null;
    	  BufferedReader in=null;
    	  PrintWriter out=null;
    	  try {
    	    // bloccante finchè non avviene una connessione
    	    clientSocket = serverSocket.accept();
    	    System.out.println("Connection accepted: "+ clientSocket);
    	    // creazione stream di input da clientSocket
    	    InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
    	    in = new BufferedReader(isr);
    	    // creazione stream di output su clientSocket
    	    OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
    	    BufferedWriter bw = new BufferedWriter(osw);
    	    out = new PrintWriter(bw, true);
    	    //ciclo di ricezione dal client e invio di risposta
    	    while (true) {
    	      String str = in.readLine();
    	      if (str.equals("END")) break;
    	      System.out.println("Echoing: " + str);
    	      out.println(str);
    	    } 
    	  }
    	  catch (IOException e) {
    	    System.err.println("Accept failed");
    	    System.exit(1);
    	  }
    	  // chiusura di stream e socket
    	  System.out.println("EchoServer: closing...");
    	  out.close();
    	  in.close();
    	  clientSocket.close();
    	  serverSocket.close();
    }
}
    

