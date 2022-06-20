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
 * @Date: 2021/5/31
 */
@Controller
@RequestMapping("/end/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    /**
     *查询所有部门信息
     */
    @RequestMapping("/list")
    public String list(Model model, String info){
        model.addAttribute("info",info);
        List<Department> departmentList = departmentService.getDepartments();
        model.addAttribute("departmentList",departmentList);
        return "end/department";
    }
    /**
     *跳转到更新页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(int departmentId,Model model,String info){
        model.addAttribute("info",info);
        Department department = departmentService.getDepartmentId(departmentId);
        model.addAttribute("department",department);
        return "end/departmentAddOrUpdate";
    }
    /**
     *跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toadd(Model model,String info){
        model.addAttribute("info",info);
        return "end/departmentAddOrUpdate";
    }
    /**
     *添加部门
     */
    @RequestMapping("/add")
    public String add(Department department, RedirectAttributes attributes){
        Department department1 = departmentService.getDepartmentByName(department.getDepartmentName());
        if(department1 != null){
            attributes.addAttribute("info","该岗位以存在");
            return "redirect:/end/department/toAdd";
        }
        departmentService.add(department);
        return "redirect:/end/department/list";
    }
    /**
     *更新部门
     */
    @RequestMapping("/update")
    public String update(Department department,String oldDepartmentName,RedirectAttributes attributes){
        if(oldDepartmentName.equals(department.getDepartmentName())){
            return "redirect:/end/department/list";
        }
        Department department1 = departmentService.getDepartmentByName(department.getDepartmentName());
        if(department1 != null){
            attributes.addAttribute("info","该岗位以存在");
            return "end/departmentAddOrUpdate";
        }
        departmentService.update(department);
        return "redirect:/end/department/list";
    }
    /**
     * 删除部门
     **/
    @RequestMapping("/delete")
    public String delete(int departmentId,RedirectAttributes attributes){
        List<Employee> employees = employeeService.getEmployeeByDepartmentId(departmentId);
        if (employees.size()>0){
            attributes.addAttribute("info","请先删除该岗位下的所有员工");
            return "redirect:/end/department/list";
        }
        departmentService.delete(departmentId);
        return "redirect:/end/department/list";
    }
    /**
     * 模糊查询
     **/
    @RequestMapping("/getDepartmentByFuzzyName")
    public String getDepartmentByFuzzyName(Department department,Model model){
        List<Department> departmentList = departmentService.endListByFuzzyName(department.getDepartmentName());
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("department",department);
        return "end/department";
    }
}
