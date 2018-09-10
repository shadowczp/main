package com.example.hbasedemo.observer;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Durability;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public class HelloWorldObserver extends BaseRegionObserver {
    @Override
    public void prePut(ObserverContext<RegionCoprocessorEnvironment> e, Put put, WALEdit edit, Durability durability) throws IOException {
        List<Cell> name = put.get(Bytes.toBytes("cf"), Bytes.toBytes("name"));
        // 如果不存在这个单元格直接返回
        if (name == null || name.size() == 0) {
            return;
        }
        // 比较cf:name是否为JACK
        if("JACK".equals(Bytes.toString(CellUtil.cloneValue(name.get(0))))){

        }
    }
}
