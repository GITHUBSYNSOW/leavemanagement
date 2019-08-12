package com.synycs.leavesmanagement.employeedetails.model


import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "daywise_details")
class DaywiseDetails {

    @EmbeddedId
    @Column(name = "daywise_details_id")
    var  daywiseDetailsId: DaywiseDetailsId?=null

    @Column(name = "availabilty")
    @Enumerated(EnumType.STRING)
    var  availabilty:EmployeeAvailability?=null

    @Column(name = "date")
    var  date:LocalDate?=null
    @Column(name = "emp_Id")

    var empId:String?=null


    constructor()

    constructor( availabilty: EmployeeAvailability?, date: LocalDate?) {
        this.daywiseDetailsId = DaywiseDetailsId()
        this.availabilty = availabilty
        this.date = date
        this.empId=empId
    }

    constructor(availabilty: EmployeeAvailability?, date: LocalDate?,empId:String?) {
        this.daywiseDetailsId = DaywiseDetailsId()
        this.availabilty = availabilty
        this.date = date
        this.empId=empId
    }
}