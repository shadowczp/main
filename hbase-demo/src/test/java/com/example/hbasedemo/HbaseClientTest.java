package com.example.hbasedemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HbaseClientTest {
    private Connection connection;
    private Table test;

    @Before
    public void init() throws URISyntaxException, IOException {
        // Configuration用于加载连接hbase的各项配置
        Configuration config = HBaseConfiguration.create();
        // 加载配置文件
        config.addResource(new Path(ClassLoader.getSystemResource("hbase-site.xml").toURI()));
        config.addResource(new Path(ClassLoader.getSystemResource("core-site.xml").toURI()));
        connection = ConnectionFactory.createConnection();
        test = connection.getTable(TableName.valueOf("test"));
    }

    @Test
    public void insert() throws IOException {
        // 最简单的新增操作  row1 新增 列族cf，列名name，value是jack
        Put put = new Put(Bytes.toBytes("row1"));
        put.addColumn(Bytes.toBytes("cf"),Bytes.toBytes("name"),Bytes.toBytes("jack"));
        test.put(put);
    }

    @Test
    public void update() throws IOException {
        // 最简单的新增操作，其实就是对于相同的rowkey，再次put，会覆盖前面的数据(如果多版本的话，以前的旧版本数据不会立刻删除)
        Put put = new Put(Bytes.toBytes("row1"));
        put.addColumn(Bytes.toBytes("cf"),Bytes.toBytes("name"),Bytes.toBytes("czp"));
        test.put(put);
    }

    @Test
    public void read() throws IOException {
        // get 对象可以只获取某些列或者列族
        Get get = new Get(Bytes.toBytes("row1")).addColumn(Bytes.toBytes("cf"),Bytes.toBytes("name"));
        Result result = test.get(get);

        // 从result中获取数据
        byte[] value = result.getValue(Bytes.toBytes("cf"), Bytes.toBytes("name"));
        System.out.println(Bytes.toString(value));
    }
}
