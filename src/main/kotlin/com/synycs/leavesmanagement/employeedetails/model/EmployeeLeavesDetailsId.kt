package com.synycs.leavesmanagement.employeedetails.model

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
class EmployeeLeavesDetailsId :Serializable{

    var employeeLeavesDetailsId:String=UUID.randomUUID().toString()

    set(employeeLeavesDetailsId){
        field=employeeLeavesDetailsId
    }
    get(){
        return field
    }

    constructor()
    constructor(employeeLeavesDetailsId: String) {
        this.employeeLeavesDetailsId = employeeLeavesDetailsId
    }
}