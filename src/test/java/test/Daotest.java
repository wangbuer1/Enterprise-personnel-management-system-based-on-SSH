package test;

import com.homework.dao.EmployeeDao;
import com.homework.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml","classpath:spring-service.xml","classpath:spring-web.xml"})
public class Daotest {

    @Resource
    private EmployeeDao employeeDao;

    @Test
    public void testEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeCode("123");
        employee.setEmployeeName("aa");
        employee.setAge(12);
        employeeDao.save(employee);
    }
}
