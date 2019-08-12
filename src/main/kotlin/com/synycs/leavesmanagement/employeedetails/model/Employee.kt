package com.synycs.leavesmanagement.employeedetails.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="employee")
class Employee {
    @EmbeddedId
    @Column(name = "employee_id")
    var employeeId:EmployeeId?=null
    @Column(name = "employee_name")
    var employeeName:String?=null
    @Column(name = "designation")
    @Enumerated(EnumType.STRING)
    var designation:DesignationType?=null
    @Column(name = "email_id")
    var emailId:String?=null
    @Column(name = "mobile_no")
    var mobileNo:String?=null

    @Column(name = "doj")
    var doj: LocalDate?=null


    constructor()
    constructor(employeeId: EmployeeId?, employeeName: String?, designation:DesignationType?,emailId: String?, mobileNo: String?,doj: LocalDate) {
        this.employeeId = employeeId
        this.employeeName = employeeName
        this.designation=designation
        this.emailId = emailId
        this.mobileNo = mobileNo
        this.doj=doj
    }


    fun IdInitilizer(){
        this.employeeId=EmployeeId()
    }
}