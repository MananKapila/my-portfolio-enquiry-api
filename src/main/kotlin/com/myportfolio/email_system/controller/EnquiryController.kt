package com.myportfolio.email_system.controller

import com.myportfolio.email_system.entity.Enquiry
import com.myportfolio.email_system.service.EnquiryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/enquiries")
class EnquiryController(private val service: EnquiryService) {
    @PostMapping
    fun createEnquiry(@RequestBody enquiry: Enquiry): ResponseEntity<String?> {
        return try {
            service.saveEnquiry(enquiry);
            ResponseEntity.ok().build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error saving enquiry: ${e.message}")
        }
    }
}
