package com.synycs.leavesmanagement.employeedetails.model.dto

import com.synycs.leavesmanagement.employeedetails.model.Employee
import com.synycs.leavesmanagement.employeedetails.model.EmployeeId

class EmployeeDTOConvertor {
    object Convertor{
        fun modelToDto(employee:Employee):EmployeeDTO{
            var dto=EmployeeDTO(employee.employeeId!!.employeeId,
                                 employee.employeeName,
                                  employee.designation,
                                  employee.emailId,
                                  employee.mobileNo,
                                  employee.doj)
            return dto

        }


        fun dtoToModel(dto:EmployeeDTO):Employee{

           /* var id=EmployeeId(dto.employeeId)
            id.employeeId=dto.employeeId*/
            var emp=Employee(EmployeeId(dto.employeeId),
                    dto.employeeName,
                    dto.designation,
                    dto.emailId,
                    dto.mobileNo,
                    dto.doj!!)
            return  emp
        }



        fun modelListToDtoList(employeeList: List<Employee>):List<EmployeeDTO>{
            var empDtoList=ArrayList<EmployeeDTO>()
            for(employee in employeeList) {
                var dto = modelToDto(employee)
                empDtoList.add(dto)
            }
            return empDtoList
        }

        fun dtoListTomodelList(employeeDtoList: List<EmployeeDTO>):List<Employee>{
            var empList=ArrayList<Employee>()
            for(employeeDto in employeeDtoList) {
                var emp = dtoToModel(employeeDto)
                empList.add(emp)
            }
            return empList
        }

    }



}