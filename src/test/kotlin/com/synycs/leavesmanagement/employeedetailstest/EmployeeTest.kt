package com.synycs.leavesmanagement.employeedetailstest

import com.synycs.leavesmanagement.LeavesmanagementApplication
import com.synycs.leavesmanagement.employeedetails.model.DesignationType
import com.synycs.leavesmanagement.employeedetails.model.Employee
import com.synycs.leavesmanagement.employeedetails.model.EmployeeId
import com.synycs.leavesmanagement.employeedetails.repository.EmployeeRepo
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(LeavesmanagementApplication::class))
class EmployeeTest {
    @Autowired
    lateinit var  employeeRepo:EmployeeRepo


    @Test
    fun saveEmployeeTest(){
        var emp=Employee()
        var id=UUID.randomUUID().toString()

        emp.employeeId= EmployeeId(id)
        emp.employeeName="sas"
        emp.designation=DesignationType.SOFTWARE_ENGINEER
        emp.emailId="sas@gmail.com"
        emp.mobileNo="6969696966"
        emp.doj= LocalDate.now()
      var result= employeeRepo.save(emp)
        Assert.assertEquals(emp.emailId,result.emailId)
        Assert.assertEquals(emp.mobileNo,result.mobileNo)


    }
}