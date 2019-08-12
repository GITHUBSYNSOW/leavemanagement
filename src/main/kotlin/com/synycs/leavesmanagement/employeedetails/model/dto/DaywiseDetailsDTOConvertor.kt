package com.synycs.leavesmanagement.employeedetails.model.dto

import com.synycs.leavesmanagement.employeedetails.model.DaywiseDetails
import com.synycs.leavesmanagement.employeedetails.model.DaywiseDetailsId

class DaywiseDetailsDTOConvertor {

object Convertor{

    fun modelToDto(daywiseDetails: DaywiseDetails):DaywiseEmpDetailsDTO{
             var dto=DaywiseEmpDetailsDTO(daywiseDetails.empId,
                daywiseDetails.availabilty,
                daywiseDetails.date)
             return dto
    }

    fun dtoToModel(dtoEmp:DaywiseEmpDetailsDTO):DaywiseDetails{


        var  daywiseDetails=DaywiseDetails(dtoEmp.availabilty,dtoEmp.date,dtoEmp.empId)

        return daywiseDetails
    }

    fun modelListToDtoList(daywiseDetailsList:List<DaywiseDetails>):List<DaywiseEmpDetailsDTO>{
        var daywiseDetailsDtoList=ArrayList<DaywiseEmpDetailsDTO>()
        for(daywiseDetails in daywiseDetailsList){
            var dto= modelToDto(daywiseDetails)
            daywiseDetailsDtoList.add(dto)
        }
        return daywiseDetailsDtoList
    }

    fun dtoListToModelList(daywiseEmpDetailsDtoList: List<DaywiseEmpDetailsDTO>):List<DaywiseDetails>{
        var daywiseDetailsList=ArrayList<DaywiseDetails>()
        for(daywiseDetailsDto in daywiseEmpDetailsDtoList){
            var dto= dtoToModel(daywiseDetailsDto)
            daywiseDetailsList.add(dto)
        }
        return daywiseDetailsList
    }



}


}