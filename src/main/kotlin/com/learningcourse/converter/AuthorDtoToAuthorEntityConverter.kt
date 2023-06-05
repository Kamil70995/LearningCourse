@file:JvmName("AuthorDtoToAuthorEntityConverter")

package com.learningcourse.converter

import com.learningcourse.dto.author.FrontAuthorDto
import com.learningcourse.entity.AuthorEntity

fun AuthorEntity.toAuthorFrontDto() =
     FrontAuthorDto(this.name, this.lastName, this.email).also { it.id = this.id }
