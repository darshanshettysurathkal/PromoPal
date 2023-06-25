package com.example.theshamelessselfpromoapp

data class Message(
    val contactName: String,
    val contactNumber: String,
    val MyDisplayName: String,
    val StartDate: String?,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val ImmediateStart: Boolean
): java.io.Serializable
{
    fun getfulldesc() =  if (includeJunior) "a junior $jobTitle" else  "an $jobTitle"

    fun availability() =if (ImmediateStart) " immediately " else " from $StartDate"

}


