package com.rylabs.competiseedx.models

/**
 * Created by VALERIAN ARISSAPUTRA on 05/12/20
 * Copyright (c) 2020
 */

data class EventModel(
    var title: String? = "",
    var date: Long? = 0,
    var dateDisplay: String? = "",
    var startTime: String? = "",
    var endTime: String? = "",
    var organizer: String? = "",
    var location: String? = "", // deskripsi lokasi
    var isCertificate: Boolean? = true,
    var isFree: Boolean? = false,
    var price: Int? = 0,
    var detail: String? = ""
)