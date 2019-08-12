package com.synycs.leavesmanagement.employeedetails.model.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.synycs.leavesmanagement.employeedetails.config.LocalDateDeSerializer
import com.synycs.leavesmanagement.employeedetails.config.LocalDateSerializer
import com.synycs.leavesmanagement.employeedetails.model.EmployeeAvailability

import java.time.LocalDate

class DaywiseEmpDetailsDTO {

    var  empId: String?=null
    var  availabilty: EmployeeAvailability?=null
    @JsonSerialize(using = LocalDateSerializer::class)
    @JsonDeserialize(using = LocalDateDeSerializer::class)
    var  date: LocalDate?=null
    constructor()

    constructor(empId: String?, availabilty: EmployeeAvailability?, date: LocalDate?) {
        this.empId = empId
        this.availabilty = availabilty
        this.date = date
    }


}