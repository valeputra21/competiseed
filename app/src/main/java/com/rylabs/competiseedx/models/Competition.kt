package com.rylabs.competiseedx.models

/**
 * Created by VALERIAN ARISSAPUTRA on 05/12/20
 * Copyright (c) 2020
 */

class Competition {

    var title: String? = null
    var date: String? = null
    var startTime: String? = null
    var endTime: String? = null
    var organizer: String? = null
    var location: String? = null // deskripsi lokasi
    var isCertificate: Boolean? = null
    var isFree: Boolean? = null
    var price: Boolean? = null
    var detail: Boolean? = null

    constructor() {}

    constructor(
        title: String?,
        date: String?,
        startTime: String?,
        endTime: String?,
        organizer: String?,
        location: String?,
        isCertificate: Boolean?,
        isFree: Boolean?,
        price: Boolean?,
        detail: Boolean?
    ) {
        this.title = title
        this.date = date
        this.startTime = startTime
        this.endTime = endTime
        this.organizer = organizer
        this.location = location
        this.isCertificate = isCertificate
        this.isFree = isFree
        this.price = price
        this.detail = detail
    }


}