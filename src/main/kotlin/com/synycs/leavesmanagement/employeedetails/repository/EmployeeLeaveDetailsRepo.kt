package com.synycs.leavesmanagement.employeedetails.repository

import com.synycs.leavesmanagement.employeedetails.model.EmployeeLeavesDetails
import com.synycs.leavesmanagement.employeedetails.model.EmployeeLeavesDetailsId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeLeaveDetailsRepo :JpaRepository<EmployeeLeavesDetails, EmployeeLeavesDetailsId> {
}