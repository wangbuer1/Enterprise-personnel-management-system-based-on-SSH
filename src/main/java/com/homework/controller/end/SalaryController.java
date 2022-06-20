package com.homework.controller.end;

import com.homework.model.Department;
import com.homework.model.Employee;
import com.homework.model.Salary;
import com.homework.service.DepartmentService;
import com.homework.service.EmployeeService;
import com.homework.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/31
 */
@Controller
@RequestMapping("/end/salary")
public class SalaryController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SalaryService salaryService;
    /**
     *查询所有员工工资信息
     */
    @RequestMapping("/list")
    public String list(Model model, String info){
        List<Employee> employeeList = employeeService.getEmployeesAndSalary();
        model.addAttribute("employeeList",employeeList);
        List<Department>  departmentList = departmentService.getDepartments();
        model.addAttribute("departmentList",departmentList);
        return "end/salary";
    }
    /**
     *跳转到更新页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Employee employee,Model model,String info){
        model.addAttribute("info",info);
        Employee employee1 = employeeService.getEmployeeById(employee);
        model.addAttribute("employee",employee1);
        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employeeList",employeeList);
        return "end/salaryAddOrUpdate";
    }
    /**
     *跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toadd(Model model,String info){
        model.addAttribute("info",info);
        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employeeList",employeeList);
        return "end/salaryAddOrUpdate";
    }
    /**
     *添加员工工资信息
     */
    @RequestMapping("/add")
    public String add(Employee employee){
        salaryService.add(employee);
        return "redirect:/end/salary/list";
    }
    /**
     *更新员工工资信息
     */
    @RequestMapping("/update")
    public String update(Employee employee){
        salaryService.update(employee);
        return "redirect:/end/salary/list";
    }
    /**
     *删除员工的工资条
     */
    @RequestMapping("/delete")
    public String delete(int id){
        salaryService.delete(id);
        return "redirect:/end/salary/list";
    }
    /**
     *根据员工信息查询员工工资
     */
    @RequestMapping("/getSalaryByCritiria")
    public String getDepartmentByFuzzyName(Employee employee,Model model){
        List<Employee> employeeList = employeeService.getEmployeesAndSalaryByCritiria(employee);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("employee",employee);
        List<Department> departmentList = departmentService.getDepartments();
        model.addAttribute("departmentList",departmentList);
        return "end/salary";
    }
}
