package com.maimai.mybatisgenerator;

import com.maimai.mybatisgenerator.dao.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisgeneratorApplicationTests {

    @Autowired
    StudentMapper studentMapper;
    @Test
    void contextLoads() {
        studentMapper.selectByPrimaryKey("1001");
        studentMapper.selectAll();
    }

}
