package com.laprogramming.restaurantorders.socket;

import android.content.Context;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketConnection extends Thread{

    private InetSocketAddress address = new InetSocketAddress("192.168.1.55", 5622);
    private static BufferedReader input;
    private static PrintStream output;
    private static SocketMessage socketMessage;

    private static Socket socket;

    private String loginString;

    public SocketConnection(String loginString){
        this.loginString=loginString;
    }

    public void run(){
        try{
            socket=new Socket(address.getAddress(), address.getPort());

            output=new PrintStream(socket.getOutputStream());
            input=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                readMessage();
                System.out.println(socketMessage.toString());

                //If it's a request from server require input from keyboard
                if(socketMessage.getRequestAnswer()==SocketMessage.REQUEST){
                    String outString=loginString;

                    if(outString.toLowerCase().equals("quit")){
                        socketMessage.setRequestAnswer(SocketMessage.REQUEST);
                        socketMessage.setMessageInfo(SocketMessage.CLOSE);
                        socketMessage.setMessage("QUIT");
                    }
                    else{
                        socketMessage.setRequestAnswer(SocketMessage.ANSWER);
                        //socketMessage.setMessageInfo(socketMessage.getMessageInfo());
                        socketMessage.setMessage(outString);
                    }

                    sendMessage();

                    if(requestClose())
                        break;
                }
            }

            //Close connection
            if(input!=null)
                input.close();
            output.close();
            socket.close();
            System.out.println("Connection with server closed");
        }
        catch(IOException e){
            System.out.println("Error - Socket : "+e.toString());
        }

    }

    private static void sendMessage(){
        output.println(socketMessage.toSend());
        output.flush();

    }

    private static void readMessage(){
        try{
            socketMessage=new SocketMessage(input.readLine());//TODO Rimuovere costruttore
        }
        catch(IOException e){
            System.out.println("Error - Reading from socket : "+e.toString());
        }
    }

    //Verify if is a closing message
    private static boolean requestClose(){
        if(socketMessage.getRequestAnswer()==SocketMessage.REQUEST && socketMessage.getMessageInfo()==SocketMessage.CLOSE)
            return true;
        else
            return false;
    }
}
