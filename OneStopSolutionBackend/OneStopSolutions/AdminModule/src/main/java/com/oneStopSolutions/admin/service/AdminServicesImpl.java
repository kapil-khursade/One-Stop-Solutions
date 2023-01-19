package com.oneStopSolutions.admin.service;

import com.oneStopSolutions.admin.exception.AdminException;
import com.oneStopSolutions.admin.exception.DepartmentException;
import com.oneStopSolutions.admin.model.Admin;
import com.oneStopSolutions.admin.model.Department;
import com.oneStopSolutions.admin.repository.AdminDao;
import com.oneStopSolutions.admin.repository.DepartmentDao;
import com.oneStopSolutions.admin.repository.EmployeeDao;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.operator.Beans.Operator;
import com.oneStopSolutions.operator.repository.OperatorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServicesImpl implements AdminServices{

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private OperatorDao operatorDao;

    //register admin
    @Override
    public Output registerAdmin(Admin admin) throws AdminException {

        if(admin != null) {

            adminDao.save(admin);

            Output output = new Output();
            output.setTimestamp(LocalDateTime.now());
            output.setMessage("Registered Successfully");

            return output;

        }else{
            throw new AdminException("admin is null");
        }
    }


    //login admin

    @Override
    public Admin adminLogin(Login login) throws AdminException {

/*        String userId = login.getUsername();
        String password = login.getPassword();

        employeeDao.
        */
        return null;
    }


    //create department
    @Override
    public Output createDepartment(Department department) throws DepartmentException {

        departmentDao.save(department);

        Output output = new Output();
        output.setTimestamp(LocalDateTime.now());
        output.setMessage("Department Created Successfully");

        return output;
    }


    //Delete Department By Id
    @Override
    public Output deleteDepartmentById(Integer id) throws DepartmentException {
        Optional<Department> opt = departmentDao.findById(id);
        Output output = new Output();

        if (opt.isPresent()) {

            Department dept = opt.get();

            departmentDao.delete(dept);

            output.setMessage("Delete Successfully");
            output.setTimestamp(LocalDateTime.now());

            return output;

        } else
            throw new DepartmentException("Department does not exist with id :" + id);
    }


    //Update Department Name By Id
    @Override
    public Output updateDepartmentNameById(Integer id, String name) throws DepartmentException {

        Optional<Department> opt= departmentDao.findById(id);
        Output output = new Output();

        if(opt.isPresent()) {

            Department existDepartment = opt.get();
            existDepartment.setDepartmentName(name);

            departmentDao.save(existDepartment);

            output.setTimestamp(LocalDateTime.now());
            output.setMessage("Updated Successfully");

            return output;

        }
        else
            throw new DepartmentException("Department does not exist with id :"+id);
    }


    //Get All Department
    @Override
    public List<Department> getAllDepartment() throws DepartmentException {
        List<Department> departments= departmentDao.findAll();

        if(departments.isEmpty())
            throw new DepartmentException("No department found..");

        return departments;
    }


    //Get Department By Id
    @Override
    public Department getDepartmentById(Integer id) throws DepartmentException {
        return departmentDao.findById(id).orElseThrow(() -> new DepartmentException("Department does not exist with id :"+id) );

    }


    // Create new Operator
    @Override
    public Output addOperator(Operator operator) throws AdminException {

        if (operator != null) {
            operatorDao.save(operator);
            Output output = new Output();
            output.setTimestamp(LocalDateTime.now());
            output.setMessage("Add Operator Successfully");
            return output;
        } else {
            throw new AdminException("Operator is null...");
        }
    }


    //Remove Operator By Id
    @Override
    public Output removeOperatorById(Integer id) throws AdminException {
        Optional<Operator> opt = operatorDao.findById(id);
        Output output = new Output();

        if (opt.isPresent()) {

            Operator operator = opt.get();

            operatorDao.delete(operator);

            output.setMessage("Delete Successfully");
            output.setTimestamp(LocalDateTime.now());

            return output;

        } else
            throw new AdminException("Operator does not exist with id :" + id);
    }


    //Update Operator
    @Override
    public Output updateOperator(Operator operator) throws AdminException {

        Output output = new Output();
        if(operator != null) {
            Operator opt = operatorDao.save(operator);
            output.setMessage("Update Sucessfully");
            output.setTimestamp(LocalDateTime.now());


            return output;
        }


        throw new AdminException("Operaor is null");

    }


    //Get Operator By Id
    @Override
    public Operator getOperatorById(Integer id) throws AdminException {
        return operatorDao.findById(id).orElseThrow(() -> new AdminException("Operator does not exist with id :"+id) );
    }


    //Get All Operator
    @Override
    public List<Operator> getAllOperator() throws AdminException {
        List<Operator> operators= operatorDao.findAll();

        if(operators.isEmpty())
            throw new AdminException("No Operator found..");

        return operators;
    }



}
