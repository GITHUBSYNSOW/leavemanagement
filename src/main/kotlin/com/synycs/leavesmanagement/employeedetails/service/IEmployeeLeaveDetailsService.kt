package com.synycs.leavesmanagement.employeedetails.service

import com.synycs.leavesmanagement.employeedetails.model.dto.AllEmpLeavesDetailsDto

import com.synycs.leavesmanagement.employeedetails.model.dto.EmployeeLeavesDetailsDTO
import io.vavr.control.Either

interface IEmployeeLeaveDetailsService {

    //fun getEmployeeLeavesDetails():List<AllEmployeeLeavesDetailsDto>

    fun saveEmployeeLeavesDetails(employeeLeaveDetailsDto:EmployeeLeavesDetailsDTO):Either<Exception,String>




}