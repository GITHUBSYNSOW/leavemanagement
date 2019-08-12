package com.synycs.leavesmanagement.employeedetails.repository

import com.synycs.leavesmanagement.employeedetails.model.Employee
import com.synycs.leavesmanagement.employeedetails.model.EmployeeId
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepo :JpaRepository<Employee,EmployeeId>{





}