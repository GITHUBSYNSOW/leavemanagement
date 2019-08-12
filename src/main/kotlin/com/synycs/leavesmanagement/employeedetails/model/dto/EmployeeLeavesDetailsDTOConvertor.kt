package com.synycs.leavesmanagement.employeedetails.model.dto

import com.synycs.leavesmanagement.employeedetails.model.EmployeeLeavesDetails
import com.synycs.leavesmanagement.employeedetails.model.EmployeeLeavesDetailsId

class EmployeeLeavesDetailsDTOConvertor {

    object Convertor {

        fun modelToDto(employeeLeavesDetails: EmployeeLeavesDetails): EmployeeLeavesDetailsDTO {
            var dto = EmployeeLeavesDetailsDTO(
                    DaywiseDetailsDTOConvertor.Convertor.modelListToDtoList(employeeLeavesDetails.daywiseList!!),
                    employeeLeavesDetails.yearMonth!!


            )
            //BeanUtils.copyProperties(employeeLeavesDetails, dto)
            return dto
        }

        fun dtoToModel(employeeLeavesDetailsDto: EmployeeLeavesDetailsDTO): EmployeeLeavesDetails {


            var employeeLeavesDetails = EmployeeLeavesDetails(
                    DaywiseDetailsDTOConvertor.Convertor.dtoListToModelList(employeeLeavesDetailsDto.daywiseEmpList!!),
                    employeeLeavesDetailsDto.localdate
                    )
            //BeanUtils.copyProperties(employeeLeavesDetailsDto, employeeLeavesDetails)
            return employeeLeavesDetails
        }


        fun modelListToDtoList(employeeLeavesDetailsList: List<EmployeeLeavesDetails>): List<EmployeeLeavesDetailsDTO> {
            var dtoList = ArrayList<EmployeeLeavesDetailsDTO>()
            for (employeeLeaves in employeeLeavesDetailsList) {
                var dto = modelToDto(employeeLeaves)
                dtoList.add(dto)
            }
            return dtoList
        }

        fun dtoListToModelList(employeeLeavesDetailsDtoList: List<EmployeeLeavesDetailsDTO>): List<EmployeeLeavesDetails> {
            var employeeLeavesDetailsList = ArrayList<EmployeeLeavesDetails>()
            for (employeeLeavesDto in employeeLeavesDetailsDtoList) {
                var employeeLeavesDetails = dtoToModel(employeeLeavesDto)
                employeeLeavesDetailsList.add(employeeLeavesDetails)
            }
            return employeeLeavesDetailsList
        }
    }
}
