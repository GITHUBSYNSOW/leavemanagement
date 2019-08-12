package com.synycs.leavesmanagement.employeedetails.controller

import com.synycs.leavesmanagement.employeedetails.model.dto.EmployeeDTO
import com.synycs.leavesmanagement.employeedetails.service.IEmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/employee")
class EmployeeController {
@Autowired
lateinit var  employeeService: IEmployeeService

    @PostMapping
    fun registerEmployee(@RequestBody employeeDto:EmployeeDTO):ResponseEntity<*>{
        var employeeDto=employeeService.saveEmployee(employeeDto)
        if(employeeDto.isRight){
            return ResponseEntity.ok(employeeDto.get())
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST)
    }


    @GetMapping
    fun searchAllEmployees():ResponseEntity<*> {
        var empList = employeeService.getAllEmployee()
        if (empList.isRight) {
            return ResponseEntity.ok(empList.get())
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST)
    }

    @GetMapping("/byId/{empId}")
    fun searchEmployeeById(@PathVariable empId:String):ResponseEntity<*>{

        var empDto=employeeService.getEmployeeById(empId)
        if(empDto.isRight){
            return ResponseEntity.ok(empDto.get())
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST)
    }

}