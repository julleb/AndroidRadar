package com.example.jb.radar.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;

/**
 * Created by jb on 2017-05-25.
 */

public class ClientTCP implements Client {
    private Socket socket;
    private boolean connected = false;
    private BufferedReader reader;
    private BufferedWriter writer;

    @Override
    public void connect(String ip, String port) throws ClientException {
        try {
            socket = new Socket(ip, portToInt(port));
            connected = true;
            reader = createReaderOfSocket(socket);
            writer = createSocketWriter();
        } catch (IOException e) {
            throw new ClientException("Couldnt connect  to the server. " + e.getMessage() + " . " + stackTraceToString(e), e);
        }catch(NumberFormatException e) {
            throw new ClientException("Couldnt not convert port: " + port + " to String", e);
        }

    }

    private String stackTraceToString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString(); // stack trace as a string
    }

    private int  portToInt(String port) throws NumberFormatException {
            return Integer.parseInt(port);
    }

    private BufferedReader createReaderOfSocket(Socket socket) throws IOException {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private BufferedWriter createSocketWriter() {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);

            BufferedWriter bw = new BufferedWriter(osw);
            return bw;
        }catch(IOException e) {
            System.out.println("FAILED TO CREATE SOCKET WRITER");
        }
        return null;


    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public String readData() throws ClientException{
        try {
            return reader.readLine();
       } catch(IOException e) {
           throw new ClientException("Could not read the data", e);
       }

    }

    @Override
    public void sendData(String data) throws ClientException {
        try {
            writer.write(data);
            writer.flush();
        }catch(IOException e) {
            throw new ClientException("Could not send data to server. " + e.getMessage(), e);
        }

    }

    @Override
    public void closeConnection() throws ClientException {
        try {
            socket.close();
            reader.close();
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }catch(NullPointerException e) {
            e.printStackTrace();
        }
    }
}
