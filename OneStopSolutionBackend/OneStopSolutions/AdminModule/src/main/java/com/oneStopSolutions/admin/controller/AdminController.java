package com.oneStopSolutions.admin.controller;

import com.oneStopSolutions.admin.exception.AdminException;
import com.oneStopSolutions.admin.exception.DepartmentException;
import com.oneStopSolutions.admin.model.Admin;
import com.oneStopSolutions.admin.model.Department;
import com.oneStopSolutions.admin.service.AdminServices;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.operator.Beans.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminService;

    //Register Admin
    
    @PostMapping("/pot")
    public ResponseEntity<Output> registerAdminHandler(@RequestBody Admin admin) throws AdminException{

        Output output = adminService.registerAdmin(admin);

        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    //Admin login

    //Create new  Department
    @PostMapping("/d")
    public ResponseEntity<Output> createDepartmentHandler(@RequestBody Department department) throws DepartmentException {

        Output output = adminService.createDepartment(department);

        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    //Delete Department By Id

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Output> deleteDepartmentByIdHandler(@PathVariable("id") Integer id)throws DepartmentException{

        Output output = adminService.deleteDepartmentById(id);

        return new ResponseEntity<>(output, HttpStatus.ACCEPTED);

    }

    //Update Department Name By Id

    @PatchMapping("/departments/{id}")
    public ResponseEntity<Output> updateDepratmentNameByIdHandler(@PathVariable("id") Integer id, @RequestParam String name)throws DepartmentException{

        Output output = adminService.updateDepartmentNameById(id,name);
        return new ResponseEntity<>(output, HttpStatus.ACCEPTED);

    }

    //Get all Department

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartmentHandler()throws DepartmentException{

        List<Department> departments = adminService.getAllDepartment();
        return new ResponseEntity<>(departments, HttpStatus.OK);

    }

    //Get Department By Id

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentByIdHandler(@PathVariable("id") Integer id)throws DepartmentException{

        Department department = adminService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);

    }

    // Add new Operator

    @PostMapping("/operators")
    public ResponseEntity<Output> addOperatorHandler(@RequestBody Operator operator)throws AdminException{

        Output output = adminService.addOperator(operator);

        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    // Remove Operator By Id

    @DeleteMapping("/operators/{id}")
    public ResponseEntity<Output> removeOperatorByIdHandler(@PathVariable("id") Integer id)throws AdminException{
        Output output = adminService.removeOperatorById(id);
        return new ResponseEntity<>(output, HttpStatus.ACCEPTED);
    }

    //Update Operator

    @PutMapping("/operator")
    public ResponseEntity<Output> updateOperatorHandler(@RequestBody Operator operator)throws AdminException{

        Output output = adminService.updateOperator(operator);

        return new ResponseEntity<>(output, HttpStatus.CREATED);

    }

    // Get Operator By Id

    @GetMapping("/operator/{id}")
    public ResponseEntity<Operator> getOperatorByIdHandler(@PathVariable("id") Integer id)throws AdminException{

        Operator operator = adminService.getOperatorById(id);

        return new ResponseEntity<>(operator, HttpStatus.OK);

    }


    //Get All Operator

    @GetMapping("/operators")
    public ResponseEntity<List<Operator>> getAllOperatorHandler()throws AdminException{

        List<Operator> operators = adminService.getAllOperator();
        return new ResponseEntity<>(operators, HttpStatus.OK);

    }


}
