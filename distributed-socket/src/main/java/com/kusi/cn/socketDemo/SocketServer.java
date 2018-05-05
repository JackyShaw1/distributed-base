package com.kusi.cn.socketDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket =  new ServerSocket(8888);
            //使用多线程读取数据
          while (true){//保持通信
              Socket socket = serverSocket.accept();
              new Thread(()->{ //箭头函数
                  try {
                      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//接收数据缓冲区
                      PrintWriter writer =  new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//往客户端返回数据

                      while(true){//只要有数据一直读取
                          String clientData = reader.readLine();
                          if(clientData ==null){
                              break;
                          }
                          //打印出接收到的客户端数据
                          System.out.println("从客户端接收到的数据为" + clientData);
                          //返回数据给客户端
                          writer.println("hello,我是单播服务器：");
                          writer.flush();
                      }

                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }).start();
          }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                serverSocket.close();
            }
        }
    }
}
