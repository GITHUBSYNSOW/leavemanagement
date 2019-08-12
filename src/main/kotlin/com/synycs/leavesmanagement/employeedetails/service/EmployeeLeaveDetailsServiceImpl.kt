package com.synycs.leavesmanagement.employeedetails.service

import com.synycs.leavesmanagement.employeedetails.model.DaywiseDetails
import com.synycs.leavesmanagement.employeedetails.model.EmployeeLeavesDetails
import com.synycs.leavesmanagement.employeedetails.model.dto.*
import com.synycs.leavesmanagement.employeedetails.repository.EmployeeLeaveDetailsRepo
import com.synycs.leavesmanagement.employeedetails.repository.EmployeeRepo
import io.vavr.control.Either
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeLeaveDetailsServiceImpl: IEmployeeLeaveDetailsService {

    @Autowired
    var employeeLeaveDetailsRepo:EmployeeLeaveDetailsRepo?=null

    @Autowired
    lateinit var employeeRepo:EmployeeRepo

    override fun saveEmployeeLeavesDetails(dto: EmployeeLeavesDetailsDTO) :Either<Exception,String>{

        var emps=employeeRepo.findAll().map { x->x.employeeId!!.employeeId to x.employeeName}.toMap()
        if(dto.localdate!!.dayOfMonth==1){
            var empLeaveList=ArrayList<EmployeeLeavesDetails>()

            dto.daywiseEmpList!!.forEach {  x->

                var dayWiseDetails=DaywiseDetails(x.availabilty,x.date,x.empId)
                var dayWiseList=ArrayList<DaywiseDetails>()
                dayWiseList.add(dayWiseDetails)
               // var dayWiseList= dayWiseDetails as List<DaywiseDetails>

                var empLeaveDetals=EmployeeLeavesDetails(dayWiseList,
                        x.date,x.empId,emps.get(x.empId))
                empLeaveList.add(empLeaveDetals)
            }
            var result=employeeLeaveDetailsRepo!!.saveAll(empLeaveList)
            var resultDto=EmployeeLeavesDetailsDTOConvertor.Convertor.modelListToDtoList(result)
            /*if(resultDto!=null) {
                return Either.right(resultDto)
            }*/

            if(result!=null) {
                return Either.right("Employee Leaves Details  are Created")
            }
            return Either.left(Exception("employee Leave Details not inserted !!!"))
        }
        else{
            var empLeaveDetailsMap=employeeLeaveDetailsRepo!!.findAll().map { x->x.empId to x }.toMap()

            var empLeaveDetailsList=ArrayList<EmployeeLeavesDetails>()

            dto.daywiseEmpList!!.forEach {x->
                var dayWiseDetails=DaywiseDetails(x.availabilty,x.date,x.empId)
                var empLeaveDetails=empLeaveDetailsMap.get(x.empId)
//                var oldDayWiseDeatails:List<DaywiseDetails>
                var oldDayWiseDeatails=empLeaveDetails!!.daywiseList!!
                //oldDayWiseDeatails as ArrayList
                /*if (empLeaveDetails != null) {
                    oldDayWiseDeatails= empLeaveDetails.daywiseList!!
                }*/
                //var oldDayWiseDeatails=empLeaveDetails!!.daywiseList as ArrayList
                //oldDayWiseDeatails.add(dayWiseDetails)
                var newDayWiseDetails=arrayListOf(dayWiseDetails)
                newDayWiseDetails.addAll(oldDayWiseDeatails)
                empLeaveDetails.daywiseList= listOf(dayWiseDetails)
                if (empLeaveDetails != null) {
                    empLeaveDetailsList.add(empLeaveDetails)
                }
            }
            var result=employeeLeaveDetailsRepo!!.saveAll(empLeaveDetailsList)
            if(result!=null) {
                return Either.right("Employee Leaves Details in DayWiseDetails are updated")
            }
            return Either.left(Exception("Employee Leaves Details in DayWiseDetails are not updated"))
        }
    }




    /*override fun saveEmployeeLeavesDetails(employeeLeaveDetailsDto:List<EmployeeLeavesDetailsDTO> ): AllEmployeeLeavesDetailsDto {

        var allEmployees=AllEmployeeLeavesDetailsDto()
        var  employeeLeavesDetailsList=EmployeeLeavesDetailsDTOConvertor.Convertor.dtoListToModelList(employeeLeaveDetailsDto)
        var result= employeeLeaveDetailsRepo!!.saveAll(employeeLeavesDetailsList)
        var employeeLeavesDetailsDto=EmployeeLeavesDetailsDTOConvertor.Convertor.modelListToDtoList(result)
        allEmployees.employeeLeavesDetailsDto=employeeLeavesDetailsDto
        allEmployees.yearMonth= YearMonth.now()

        return allEmployees
















        *//*  var allEmps= employeeLeaveDetailsRepo!!.findAll()
        var empLeaveList=ArrayList<EmployeeLeavesDetailsDTO>()

        allEmps.forEach {

        var emp=EmployeeLeavesDetailsDTO()*//*




     *//*   var empDetails=EmployeeLeavesDetailsDTOConvertor.Convertor.dtoToModel(employeeLeavesDetailsDto)
        var res= employeeLeaveDetailsRepo!!.save(empDetails)
        var empDetailsDto=EmployeeLeavesDetailsDTOConvertor.Convertor.modelToDto(res)*//*


    }

    override fun getEmployeeLeavesDetails(): List<AllEmployeeLeavesDetailsDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

}