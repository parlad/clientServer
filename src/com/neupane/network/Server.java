/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author parlad
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket sock = null;
        try {
            sock = new ServerSocket(5055);
        } catch (IOException e) {
            System.out.println("Could not listen: " + e);
            System.exit(1);
        }
        System.out.println("Listening on port 5055");
        Socket clientSocket = null;
        try {
            clientSocket = sock.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: " + e);
            System.exit(1);
        }// Communication has been established
        InputStreamReader is = new InputStreamReader// 23 
                (clientSocket.getInputStream());
        BufferedReader input = new BufferedReader(is);
        PrintWriter client = new PrintWriter // 26 
                (clientSocket.getOutputStream());
        String line = input.readLine();
        while (line != null) {
            System.out.println(line);
            client.println("Message received");
            client.flush();
            line = input.readLine();
        }
    }

}
