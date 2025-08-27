package com.example.android14.practicainicial

import java.io.Serializable

data class PersonB(
    var name: String,
    var age: Int,
    var isMarried: Boolean,
    var phone: String,
    var email:String
):Serializable