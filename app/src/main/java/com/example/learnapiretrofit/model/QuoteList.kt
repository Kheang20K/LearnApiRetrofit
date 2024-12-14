package com.example.learnapiretrofit.model


data class Info(
    var name: String? = "",
    val age: String? = "",
    val status: String? = "",
    val address: List<Address>? = null,
)


data class Address(
    var province: String? = "",
    var distric: String? = "",
    var village: String? = "",
)