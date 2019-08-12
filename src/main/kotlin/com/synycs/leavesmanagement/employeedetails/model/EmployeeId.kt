package com.synycs.leavesmanagement.employeedetails.model

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
class EmployeeId:Serializable {
    var employeeId:String?=UUID.randomUUID().toString()

    constructor()
    constructor(employeeId: String?) {
        this.employeeId = employeeId
    }
}