package com.mygroup.sxl.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: shenxl
 * @Date: 2019/11/13 15:23
 * @Version 1.0
 * @description：${description}
 */
public class NioServer2 {

    public static void main(String[] args) throws Exception{
        // 创建一个selector
        Selector selector = Selector.open();
        // 创建一个ServerSocketChannel
        ServerSocketChannel servChannel = ServerSocketChannel.open();
        servChannel.configureBlocking(false);
        // 绑定端口号
        servChannel.socket().bind(new InetSocketAddress(8080), 1024);
        // 注册感兴趣事件
        servChannel.register(selector, SelectionKey.OP_ACCEPT);

        // select系统调用
        selector.select(1000);

        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> it = selectedKeys.iterator();
        SelectionKey key = null;
        while (it.hasNext()) {
            key = it.next();
            it.remove();
            if (key.isValid()) {
                // 处理新接入的请求消息
                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    // 接收客户端的连接，并创建一个SocketChannel
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    // 将SocketChannel和感兴趣事件注册到selector
                    sc.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    // 读数据的处理
                }
            }
        }
    }
}
