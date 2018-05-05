package com.kusi.cn.socketDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost",8888);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);//往服务端返回数据
            writer.println("hello,我是客户端。");//返回信息给客户端

            while (true){//读取完所有接收到的数据
                String serverData = reader.readLine();
                if (serverData==null){
                    break;
                }
                System.out.println("从服务器接收到的数据为:" + serverData);
            }

            writer.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
    }
}
