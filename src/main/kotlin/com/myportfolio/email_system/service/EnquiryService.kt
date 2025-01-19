package com.myportfolio.email_system.service

import com.myportfolio.email_system.entity.Enquiry
import com.myportfolio.email_system.repository.EnquiryRepository
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
@Slf4j
class EnquiryService(
    private val repository: EnquiryRepository,
    private val emailService: EmailService ) {
    fun saveEnquiry(enquiry: Enquiry): Enquiry{
        val logger = LoggerFactory.getLogger(EnquiryService::class.java)
        repository.save(enquiry)
        logger.info("Data saved successfully: {}", enquiry)
        emailService.sendNotification(enquiry)
        return enquiry
    }
}