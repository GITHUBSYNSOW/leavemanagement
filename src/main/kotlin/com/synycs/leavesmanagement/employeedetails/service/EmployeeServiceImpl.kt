package com.synycs.leavesmanagement.employeedetails.service

import com.synycs.leavesmanagement.employeedetails.model.EmployeeId
import com.synycs.leavesmanagement.employeedetails.model.dto.EmployeeDTO
import com.synycs.leavesmanagement.employeedetails.model.dto.EmployeeDTOConvertor
import com.synycs.leavesmanagement.employeedetails.repository.EmployeeRepo
import io.vavr.control.Either
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl:IEmployeeService {



    @Autowired
    lateinit var employeeRepo: EmployeeRepo

    override fun saveEmployee(employeeDto: EmployeeDTO): Either<Exception, EmployeeDTO> {

        var emp=EmployeeDTOConvertor.Convertor.dtoToModel(employeeDto)
        emp.IdInitilizer()
        var result=employeeRepo.save(emp)
        var empDto=EmployeeDTOConvertor.Convertor.modelToDto(result)
        if(empDto!=null){
            return Either.right(empDto)
        }
        return Either.left(Exception("Employee Not Inserted "))

    }

    override fun getAllEmployee(): Either<Exception,List<EmployeeDTO>> {
        var employeeResultDto=employeeRepo.findAll()
        var empDto=EmployeeDTOConvertor.Convertor.modelListToDtoList(employeeResultDto)
        if(empDto.isEmpty()|| empDto.size<1){
            return Either.right(ArrayList<EmployeeDTO>())
        }
        else{
            if(empDto.size>=1){
                return  Either.right(empDto)

            }
            return Either.left(Exception("Employee not Found "))
        }
    }

    override fun getEmployeeById(empId: String): Either<Exception, EmployeeDTO> {
        var id=EmployeeId(empId)
        var result=employeeRepo.findById(id)
        var resultDto=EmployeeDTOConvertor.Convertor.modelToDto(result.get())

        if(result!=null){
            return Either.right(resultDto)
        }
        return Either.left(Exception("Employee Id not found!!!"))
    }
}