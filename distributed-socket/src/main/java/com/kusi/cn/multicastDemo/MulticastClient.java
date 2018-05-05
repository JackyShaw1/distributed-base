package com.kusi.cn.multicastDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            //加入广播群组
            InetAddress group = InetAddress.getByName("224.5.6.7");
            MulticastSocket socket = new MulticastSocket(8889);
            socket.joinGroup(group);
            byte[] bytes = new byte[256];
            //从群组获取字节码数据
            while (true){
                DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
                socket.receive(datagramPacket);
                System.out.println("从组播服务端获取到的数据为:"+ new String(datagramPacket.getData()));
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
