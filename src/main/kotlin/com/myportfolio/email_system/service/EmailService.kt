package com.myportfolio.email_system.service

import com.myportfolio.email_system.entity.Enquiry
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
@Slf4j
class EmailService(private val mailSender: JavaMailSender) {

    @Value("\${spring.email.from-email}")
    lateinit var senderEmail: String

    @Value("\${spring.email.to-email}")
    lateinit var toEmail: String

    fun sendNotification(enquiry: Enquiry) {

        val message = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, false)
        val logger = LoggerFactory.getLogger(EmailService::class.java)

        helper.setFrom(senderEmail)
        helper.setTo(toEmail)
        helper.setSubject("New Enquiry: ${enquiry.type}")
        helper.setText(
            """
            Name: ${enquiry.name}
            Email: ${enquiry.email}
            Message: ${enquiry.message}
            """.trimIndent(),
            false
        )
        mailSender.send(message)
        logger.info("Notification email sent successfully for enquiry: ${enquiry.id}")
    }
}
