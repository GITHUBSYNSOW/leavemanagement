package com.synycs.leavesmanagement.employeedetails.model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.time.LocalDate
import java.time.YearMonth
import javax.persistence.*

@Entity
@Table(name="employee_leaves_details")
class EmployeeLeavesDetails {

    @EmbeddedId
    @Column(name="employee_leaves_details_id")
    var employeeLeavesDetailsId:EmployeeLeavesDetailsId?=null

    @OneToMany(cascade = arrayOf(CascadeType.ALL),fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "employee_leaves_details_daywise_details",
            joinColumns = arrayOf(JoinColumn(name = "employee_leaves_details_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "daywise_details_id")))
    var daywiseList:List<DaywiseDetails>?=null

    @Column(name="year_month")
    var yearMonth:LocalDate?=null

    @Column(name="emp_id")
    var empId:String?=null

    @Column(name="employee_name")
    var employeeName:String?=null

    constructor()
    constructor( daywiseList: List<DaywiseDetails>?, yearMonth:LocalDate?, empId: String?, employeeName: String?) {
        this.employeeLeavesDetailsId = EmployeeLeavesDetailsId()
        this.daywiseList = daywiseList
        this.yearMonth = yearMonth
        this.empId = empId
        this.employeeName = employeeName
    }
    constructor( daywiseList: List<DaywiseDetails>?, yearMonth: LocalDate?) {
        this.employeeLeavesDetailsId = EmployeeLeavesDetailsId()
        this.daywiseList = daywiseList
        this.yearMonth = yearMonth

    }


    constructor(daywiseList: List<DaywiseDetails>?, empId: String?, employeeName: String?) {
        this.daywiseList = daywiseList
        this.empId = empId
        this.employeeName = employeeName
    }

}