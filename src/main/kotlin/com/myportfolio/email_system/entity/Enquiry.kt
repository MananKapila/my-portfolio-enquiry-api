package com.myportfolio.email_system.entity

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "enquiries")
@Data
data class Enquiry(
    @Id
    @JsonProperty("id") val id: String? = null,
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("email") val email: String? = null,
    @JsonProperty("type") val type: String?=null,
    @JsonProperty("message") val message: String?= null,
    @JsonProperty("timestamp") val timestamp: Long = System.currentTimeMillis()
)