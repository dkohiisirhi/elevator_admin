package com.yuyun.elevatoradmin;

import com.yuyun.elevatoradmin.service.ElevatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ElevatorAdminApplicationTests {
    @Autowired
    ElevatorService elevatorService;
    @Test
    void contextLoads() {
elevatorService.getElevatorBrand();
    }

}
