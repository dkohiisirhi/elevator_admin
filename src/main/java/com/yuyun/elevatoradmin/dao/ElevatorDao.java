package com.yuyun.elevatoradmin.dao;

import com.yuyun.elevatoradmin.entity.ElevatorEntity;
import com.yuyun.elevatoradmin.mapper.ElevatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElevatorDao {

    @Autowired
    ElevatorMapper elevatorMapper;

    //每一个需要缓存的数据都要指定放在哪个名字的缓存【缓存的分区,按照业务类型分】
    //默认行为自动生成SimpleKey:[]自动生成的key值
    //缓存的值默认使用jdk序列机制,序列化后保存到redis
    //默认过期时间为永不过期
    @Cacheable(value = {"elevator"}, key = "#root.methodName",sync = true)//代表当前的结果需要缓存,如果缓存中有,方法都不调用,没有就调用方法
    public List<ElevatorEntity> getElevators(){
        List<ElevatorEntity> elevators = elevatorMapper.getElevators();
        return elevators;
    }
}
