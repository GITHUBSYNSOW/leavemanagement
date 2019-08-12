package com.synycs.leavesmanagement.employeedetails.model.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.synycs.leavesmanagement.employeedetails.config.LocalDateDeSerializer
import com.synycs.leavesmanagement.employeedetails.config.LocalDateSerializer
import java.time.LocalDate
import java.time.YearMonth

class EmployeeLeavesDetailsDTO {

    var daywiseEmpList:List<DaywiseEmpDetailsDTO>?=null
    @JsonSerialize(using = LocalDateSerializer::class)
    @JsonDeserialize(using = LocalDateDeSerializer::class)
    var localdate: LocalDate?=null


    constructor()
    constructor(daywiseEmpList: List<DaywiseEmpDetailsDTO>?, localdate: LocalDate?) {
        this.daywiseEmpList = daywiseEmpList
        this.localdate = localdate
    }

}