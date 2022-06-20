package com.homework.controller.end;

import com.homework.model.Department;
import com.homework.model.Employee;
import com.homework.service.DepartmentService;
import com.homework.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Controller
@RequestMapping("/end/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    /**
     *获取员工列表
     */
    @RequestMapping("/list")
    public String employees(Model model){
        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employeeList",employeeList);
        List<Department>  departmentList = departmentService.getDepartments();
        model.addAttribute("departmentList",departmentList);
        return "end/employee";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(Employee employee,Model model,String info){
        model.addAttribute("info",info);
        Employee employee1 = employeeService.getEmployeeById(employee);
        model.addAttribute("employee",employee1);
        List<Department> departmentList = departmentService.getDepartments();
        model.addAttribute("departmentList",departmentList);
        return "end/employeeAddOrUpdate";
    }
    /**
     *跳转到员工添加页面
     */
    @RequestMapping("/toAdd")
    public String toadd(Model model,String info){
        model.addAttribute("info",info);
        List<Department> departmentList = departmentService.getDepartments();
        model.addAttribute("departmentList",departmentList);
        return "end/employeeAddOrUpdate";
    }
    /**
     *添加员工
     */
    @RequestMapping("/add")
    public String add(Employee employee, RedirectAttributes attributes){
        Employee employee1 = employeeService.getEmployeeByCode(employee.getEmployeeCode());
        if(employee1 != null){
            attributes.addAttribute("info","该员工以存在");
            return "redirect:/end/employee/toAdd";
        }
        employeeService.add(employee);
        return "redirect:/end/employee/list";
    }
    /**
     *更新员工
     */
    @RequestMapping("/update")
    public String update(Employee employee,String oldEmployeeName,RedirectAttributes attributes){
        if(oldEmployeeName.equals(employee.getEmployeeName())){
            employeeService.update(employee);
            return "redirect:/end/employee/list";
        }
        Employee employee1  = employeeService.getEmployeeByName(employee.getEmployeeName());
        if(employee1 != null){
            attributes.addAttribute("info","该分类以存在");
            return "end/employeeAddOrUpdate";
        }
        employeeService.update(employee);
        return "redirect:/end/employee/list";
    }
    /**
     *删除员工
     */
    @RequestMapping("/delete")
    public String delete(int employeeId,RedirectAttributes attributes){
        employeeService.delete(employeeId);
        return "redirect:/end/employee/list";
    }
    /**
     *员工，模糊查询
     */
    @RequestMapping("/getEmployeeByCritiria")
    public String getEmployeeByCritiria(Employee employee,Model model){
        List<Employee> employeeList = employeeService.getListByCritiria(employee);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("employee",employee);
        List<Department> departmentList = departmentService.getDepartments();
        model.addAttribute("departmentList",departmentList);
        return "end/employee";
    }
}
