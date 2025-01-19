package com.myportfolio.email_system.repository

import com.myportfolio.email_system.entity.Enquiry
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EnquiryRepository : MongoRepository<Enquiry, String>