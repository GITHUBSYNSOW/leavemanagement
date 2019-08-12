package com.synycs.leavesmanagement.employeedetailstest

import com.synycs.leavesmanagement.LeavesmanagementApplication
import com.synycs.leavesmanagement.employeedetails.model.EmployeeAvailability
import com.synycs.leavesmanagement.employeedetails.model.dto.DaywiseEmpDetailsDTO
import com.synycs.leavesmanagement.employeedetails.model.dto.EmployeeLeavesDetailsDTO
import com.synycs.leavesmanagement.employeedetails.service.EmployeeLeaveDetailsServiceImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate
import java.time.Month

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(LeavesmanagementApplication::class))
class EmployeeLeavesDetailsTest {

    @Autowired
    var empLDetailsService:EmployeeLeaveDetailsServiceImpl?=null


    @Test
    fun saveEmpLeaveDetailsTest(){

        var empLDetails=EmployeeLeavesDetailsDTO()


        var daywiseEmpDetails=DaywiseEmpDetailsDTO()
        daywiseEmpDetails.availabilty=EmployeeAvailability.PRESENT
        daywiseEmpDetails.empId="c669c8b5-da1c-4895-b773-4a9fea11af39"
        daywiseEmpDetails.date= LocalDate.of(2019,Month.AUGUST,2)
        var daywiseEmpDetailsList=ArrayList<DaywiseEmpDetailsDTO>()
        daywiseEmpDetailsList.add(daywiseEmpDetails)
        empLDetails.localdate=LocalDate.of(2019,Month.AUGUST,2)

       // var daywiseModel=DaywiseDetailsDTOConvertor.Convertor.dtoListToModelList(daywiseEmpDetailsList)
        empLDetails.daywiseEmpList=daywiseEmpDetailsList

       empLDetailsService!!.saveEmployeeLeavesDetails(empLDetails)

    }
}