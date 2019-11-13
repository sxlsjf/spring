package com.mygroup.sxl.test;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Author: shenxl
 * @Date: 2019/11/7 11:26
 * @Version 1.0
 * @description：${description}
 */
public class TestCase {

    private static final String connectionString = "127.0.0.1:2181";
    public static final Integer sessionTimeout = 2000;
    public static ZooKeeper zkClient = null;

    public static void main(String[] args) throws Exception{
        //三个参数分别为连接的zookeeper集群服务器的ip，超时时间，监听器
        //收到事件通知后的回调函数（应该是我们自己的事件处理逻辑）
        zkClient = new ZooKeeper(connectionString, sessionTimeout, event ->
                System.out.println(event.getType() + "," + event.getPath()));
    }


    //链接zk
    public void init() throws Exception{
        //三个参数分别为连接的zookeeper集群服务器的ip，超时时间，监听器
        //收到事件通知后的回调函数（应该是我们自己的事件处理逻辑）
        zkClient = new ZooKeeper(connectionString, sessionTimeout, event -> System.out.println(event.getType()+","+event.getPath()));
    }

    //创建数据节点到zk中
    public void createNode() throws Exception{
        /*
         * 传入四个参数
         * 1、创建的节点
         * 2、节点数据
         * 3、节点的权限，OPEN_ACL_UNSAFE表示内部应用权限
         * 4、节点类型，4种：持久化节点，带序列持久化节点，临时节点，带序列的临时节点
         */
        init();
        String path = zkClient.create("/idea",
                "helloworld".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println(path);
    }
    /**
     *获取子节点数据
     * */
    public void getChildren()  throws Exception{
        /*
         * 传入2个参数
         * 1、指定获取哪个节点的孩子
         * 2、是否使用监听器(watcher)，true表示使用以上的监听功能
         */
        init();
        List<String> children = zkClient.getChildren("/",true);
        for (String child : children) {
            System.out.println(child);
        }
        System.in.read();}

    /**
     *判断节点是否存在
     * */
    public void testExist()  throws Exception{
        //一个参数是节点，一个是是否用监听功能,Stat封装了该节点的相关信息比如：czxid，mzxid，ctime，mtime等
        init();
        Stat stat = zkClient.exists("/idea", false);
        System.out.println(stat==null?"不存在":"存在");
    }

    /**
     *获取节点数据
     * */
    public void getData()  throws Exception{
        init();
        byte[] data = zkClient.getData("/idea", false, null);
        System.out.println(new String(data));
    }

    /**
     *删除节点
     * */
    public void delete()  throws Exception{
        //第一个参数为要删除的节点，第二个参数表示版本，-1表示所有版本
        init();
        zkClient.delete("/idea",-1);
    }

    /**
     *修改节点
     * */
    public void update() throws Exception{
        init();
        //原 /idea节点的数据为helloworld
        zkClient.setData("/idea", "zookeeper".getBytes(), -1);
        //查看修改数据是否成功
        byte[] data = zkClient.getData("/idea", false, null);
        System.out.println(new String(data));
    }
}
