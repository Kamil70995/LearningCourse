package com.learningcourse.repository

import com.learningcourse.entity.AuthorEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<AuthorEntity, Long> {
}