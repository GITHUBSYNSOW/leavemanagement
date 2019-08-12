package com.synycs.leavesmanagement.employeedetails.model

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
class DaywiseDetailsId : Serializable {

    var  daywiseDetailsId:String?=UUID.randomUUID().toString()


    set(daywiseDetailsId){
        field=daywiseDetailsId
    }
    get(){
        return field
    }
    constructor()
    constructor(daywiseDetailsId: String?) {
        this.daywiseDetailsId = daywiseDetailsId
    }
}