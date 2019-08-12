package com.synycs.leavesmanagement.employeedetails.controller


import com.synycs.leavesmanagement.employeedetails.model.dto.EmployeeLeavesDetailsDTO
import com.synycs.leavesmanagement.employeedetails.service.EmployeeLeaveDetailsServiceImpl
import io.vavr.control.Either
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/empLeaves")
class EmployeeLeavesDetailsController {
    @Autowired
    lateinit var  empLeaveDetailsService:EmployeeLeaveDetailsServiceImpl

    @PostMapping
    fun registerAllEmployeeLeaves(@RequestBody empLeaveDetailsDto:EmployeeLeavesDetailsDTO):ResponseEntity<*>
    {
        var result=empLeaveDetailsService.saveEmployeeLeavesDetails(empLeaveDetailsDto)
        if(result.isRight){
            return ResponseEntity.ok(result)
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST)
    }

}