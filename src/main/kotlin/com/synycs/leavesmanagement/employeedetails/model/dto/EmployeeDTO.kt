package com.synycs.leavesmanagement.employeedetails.model.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.synycs.leavesmanagement.employeedetails.config.LocalDateDeSerializer
import com.synycs.leavesmanagement.employeedetails.config.LocalDateSerializer
import com.synycs.leavesmanagement.employeedetails.model.DesignationType
import java.time.LocalDate


class EmployeeDTO {
    var employeeId: String?=null
    var employeeName:String?=null
    var designation: DesignationType?=null
    var emailId:String?=null
    var mobileNo:String?=null
    @JsonSerialize(using = LocalDateSerializer::class)
    @JsonDeserialize(using = LocalDateDeSerializer::class)
    var doj: LocalDate?=null


    constructor()
    constructor(employeeId: String?, employeeName: String?, designation:DesignationType?, emailId: String?, mobileNo: String?,doj: LocalDate?) {
        this.employeeId = employeeId
        this.employeeName = employeeName
        this.designation=designation
        this.emailId = emailId
        this.mobileNo = mobileNo
        this.doj=doj
    }
}