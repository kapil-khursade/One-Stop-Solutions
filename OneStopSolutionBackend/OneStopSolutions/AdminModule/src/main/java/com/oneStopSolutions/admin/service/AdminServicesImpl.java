package com.oneStopSolutions.admin.service;

import com.oneStopSolutions.admin.dto.AddOperatorDto;
import com.oneStopSolutions.admin.dto.RegisterAdminDto;
import com.oneStopSolutions.admin.exception.AdminException;
import com.oneStopSolutions.admin.exception.DepartmentException;
import com.oneStopSolutions.admin.model.Admin;
import com.oneStopSolutions.admin.model.Department;
import com.oneStopSolutions.admin.model.Employee;
import com.oneStopSolutions.admin.repository.AdminDao;
import com.oneStopSolutions.admin.repository.DepartmentDao;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.customerBeans.UserType;
import com.oneStopSolutions.customer.repository.LoginRepository;
import com.oneStopSolutions.operator.Beans.Operator;
import com.oneStopSolutions.operator.exception.OperatorException;
import com.oneStopSolutions.operator.repository.OperatorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServicesImpl implements AdminServices {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	@Transient
	private OperatorDao operatorDao;

	@Autowired
	@Transient
	private LoginRepository loginDao;

	// register admin
	@Override
	public Output registerAdmin(RegisterAdminDto dto) throws AdminException, DepartmentException {
		if (dto != null) {

			Optional<Department> opt = departmentDao.findById(dto.getDepartmentId());

			if (opt != null) {
				Department department = opt.get();

				Admin admin = new Admin();

				admin.setFirstName(dto.getFirstName());
				admin.setLastName(dto.getLastName());
				admin.setEmail(dto.getEmail());
				admin.setDepartment(department);

				Login login = new Login();

				login.setUsername(dto.getUsername());
				login.setPassword(dto.getPassword());
				login.setActive(true);
				login.setType(UserType.ADMIN);

				admin.setLogin(login);

				Employee employee = new Employee();

				employee.setDepartment(department);
				employee.setFirstName(dto.getFirstName());
				employee.setLastName(dto.getLastName());

				department.getAdminList().add(admin);

				department.getEmployeeList().add(employee);

				departmentDao.save(department);

				Output output = new Output();
				output.setTimestamp(LocalDateTime.now());
				output.setMessage("Admin Added Successfully");
				return output;
			} else {
				throw new DepartmentException("No Department Found With DepartmentID : " + dto.getDepartmentId());
			}

		} else {
			throw new AdminException("Fill All the Fields");
		}

	}

	// login admin

	@Override
	public Admin adminLogin(Login login) throws AdminException {
		Login login2 = loginDao.findByUsername(login.getUsername());

		if (login2 == null) {
			throw new AdminException("No A./c Found");
		} else if (!login2.getPassword().equals(login.getPassword())) {
			throw new AdminException("Password Incorrect");
		} else {

			Admin admin = adminDao.findByLogin(login2);

			if (admin == null) {
				throw new AdminException("Admin Not Found");
			} else {
				return admin;
			}

		}
	}

	// create department
	@Override
	public Output createDepartment(Department department) throws DepartmentException {

		departmentDao.save(department);

		Output output = new Output();
		output.setTimestamp(LocalDateTime.now());
		output.setMessage("Department Created Successfully");

		return output;
	}

	// Delete Department By Id
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

	// Update Department Name By Id
	@Override
	public Output updateDepartmentNameById(Integer id, String name) throws DepartmentException {

		Optional<Department> opt = departmentDao.findById(id);
		Output output = new Output();

		if (opt.isPresent()) {

			Department existDepartment = opt.get();
			existDepartment.setDepartmentName(name);

			departmentDao.save(existDepartment);

			output.setTimestamp(LocalDateTime.now());
			output.setMessage("Updated Successfully");

			return output;

		} else
			throw new DepartmentException("Department does not exist with id :" + id);
	}

	// Get All Department
	@Override
	public List<Department> getAllDepartment() throws DepartmentException {
		List<Department> departments = departmentDao.findAll();

		if (departments.isEmpty())
			throw new DepartmentException("No department found..");

		return departments;
	}

	// Get Department By Id
	@Override
	public Department getDepartmentById(Integer id) throws DepartmentException {
		return departmentDao.findById(id)
				.orElseThrow(() -> new DepartmentException("Department does not exist with id :" + id));

	}

	// Create new Operator
	@Override
	public Output addOperator(AddOperatorDto dto) throws OperatorException, DepartmentException {

		if (dto != null) {

			Optional<Department> opt = departmentDao.findById(dto.getDepartmentId());

			if (opt != null) {
				Department department = opt.get();

				Operator operator = new Operator();
				operator.setOperatorFirstName(dto.getOperatorFirstName());
				operator.setOperatorLastName(dto.getOperatorLastName());
				operator.setOperatorEmail(dto.getOperatorEmail());
				operator.setOperatorMobile(dto.getOperatorMobile());
				operator.setOperatorType(dto.getOperatorType());

				Login login = new Login();

				login.setUsername(dto.getUsername());
				login.setPassword(dto.getPassword());
				login.setActive(true);
				login.setType(UserType.OPERATOR);

				operator.setLogin(login);

				Employee employee = new Employee();

				employee.setDepartment(department);
				employee.setFirstName(dto.getOperatorFirstName());
				employee.setLastName(dto.getOperatorLastName());

				department.getOperatorList().add(operator);

				department.getEmployeeList().add(employee);

				departmentDao.save(department);

				Output output = new Output();
				output.setTimestamp(LocalDateTime.now());
				output.setMessage("Operator Added Successfully");
				return output;
			} else {
				throw new DepartmentException("No Department Found With DepartmentID : " + dto.getDepartmentId());
			}

		} else {
			throw new OperatorException("Fill All the Fields");
		}
	}

	// Remove Operator By Id
	@Override
	public Output removeOperatorById(Integer operatorId) throws AdminException {

		Optional<Operator> opt = operatorDao.findById(operatorId);
		Output output = new Output();

		if (opt.isPresent()) {

			Operator operator = opt.get();

			operatorDao.delete(operator);

			output.setMessage("Operator Deleted Successfully");
			output.setTimestamp(LocalDateTime.now());

			return output;

		} else {
			throw new AdminException("Operator does not exist with id :" + operatorId);
		}

	}

	// Update Operator
	@Override
	public Output updateOperator(Operator operator) throws AdminException {

		Optional<Operator> opt = operatorDao.findById(operator.getOperatorId());

		if (opt == null) {
			throw new AdminException("No Operator Found");
		} else {
			Operator operator2 = opt.get();

			if (operator.getLogin() != null) {
				if (operator.getLogin().getPassword() != null) {
					operator2.getLogin().setPassword(operator.getLogin().getPassword());
				}
				if (operator.getLogin().getUsername() != null) {
					operator2.getLogin().setUsername(operator.getLogin().getUsername());
				}
			}
			if (operator.getOperatorEmail() != null) {
				operator2.setOperatorEmail(operator.getOperatorEmail());
			}
			if (operator.getOperatorFirstName() != null) {
				operator2.setOperatorFirstName(operator.getOperatorFirstName());
			}
			if (operator.getOperatorLastName() != null) {
				operator2.setOperatorLastName(operator.getOperatorLastName());
			}
			if (operator.getOperatorMobile() != null) {
				operator2.setOperatorMobile(operator.getOperatorMobile());
			}
			if (operator.getOperatorType() != null) {
				operator2.setOperatorType(operator.getOperatorType());
			}

			operatorDao.save(operator2);

			Output output = new Output();
			output.setMessage("Update Sucessfully");
			output.setTimestamp(LocalDateTime.now());

			return output;
		}

	}

	// Get Operator By Id
	@Override
	public Operator getOperatorById(Integer id) throws AdminException {
		return operatorDao.findById(id)
				.orElseThrow(() -> new AdminException("Operator does not exist with id : " + id));
	}

	// Get All Operator
	@Override
	public List<Operator> getAllOperator() throws AdminException {
		List<Operator> operators = operatorDao.findAll();

		if (operators.isEmpty())
			throw new AdminException("No Operator found..");

		return operators;
	}

}
