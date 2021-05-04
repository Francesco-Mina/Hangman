/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import hangman.ArtificialPlayer;
import hangman.Hangman;
import hangman.Player;

/**
 * Class for the playing without a network.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class LocalGame {
    
    /**
     * Play the game with the terminal.
     * 
     * @param args ignored
     * @throws IOException 
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        /*Hangman game = new Hangman();
        Player player = new LocalPlayer();
        // Player player = new ArtificialPlayer();
        game.playGame(player);*/
    	Socket clientSocket = new Socket("0.0.0.0", 8888);
    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        for(int i=0; i<10; i++) {
        	out.println("Ciao");
        }
        out.println("END");
        in.close();
        out.close();
        clientSocket.close();
    }
}
