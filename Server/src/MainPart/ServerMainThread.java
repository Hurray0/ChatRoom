/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @Date 2014-11-07 02:20:20
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package MainPart;
//通信包

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//Hash队列包
import java.util.HashMap;
import java.util.Iterator;
//线程池包
import java.util.concurrent.*;
//GUI
import java.awt.*;
import javax.swing.*;

/**
 * @Author hurray
 * @Class ServerMainThread
 */
public class ServerMainThread extends Thread {

    // Socket

    private Socket socket;
    private Socket sockethim;
    private JTextArea jta;
    private DataOutputStream outputToClient;
    private DataInputStream inputFromClient;
    private DataOutputStream outputToMe;
    private String username;
    private String othersname;

    // 服务器用户Hash列表
    private HashMap<String, Socket> usernameMap;

    // 构造方法
    public ServerMainThread(Socket socket, HashMap<String, Socket> usernameMap, JTextArea jta) {
        this.socket = socket;
        this.jta = jta;
        this.usernameMap = usernameMap;
    }

    // 线程
    public void run() {

    }
}
