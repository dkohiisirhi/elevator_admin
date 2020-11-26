package com.yuyun.elevatoradmin;

import com.yuyun.elevatoradmin.service.ElevatorService;
import com.yuyun.elevatoradmin.vo.ElevatorProjectVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ElevatorAdminApplicationTests {
    @Autowired
    ElevatorService elevatorService;
    @Test
    void contextLoads() {
        List<ElevatorProjectVo> elevatorProject = elevatorService.getElevatorProject();
        System.out.println(elevatorProject);

    }

}
