package com.synycs.leavesmanagement.employeedetails.service

import com.synycs.leavesmanagement.employeedetails.model.dto.EmployeeDTO
import io.vavr.control.Either

interface IEmployeeService {


    fun saveEmployee(employeeDto:EmployeeDTO): Either<Exception, EmployeeDTO>

    fun getAllEmployee():Either<Exception,List<EmployeeDTO>>

    fun getEmployeeById(empId:String):Either<Exception,EmployeeDTO>





}