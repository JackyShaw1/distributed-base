package com.kusi.cn.multicastDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class MultiCastServer {
    public static void main(String[] args) {
        try {
            //组播地址段:224.0.0.0 - 239.255.255.255
            InetAddress group = InetAddress.getByName("224.5.6.7");
            MulticastSocket socket = new MulticastSocket();

            //发送多条数据给群组
            for (int i=0;i<10;i++){
                String data = "Hello,我是组播服务器..." + i;
                byte[] bytes = data.getBytes();
                socket.send(new DatagramPacket(bytes,bytes.length,group,8889));
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
