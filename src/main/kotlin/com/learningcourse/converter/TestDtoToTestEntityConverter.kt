@file:JvmName("TestDtoToTestEntityConverter")
package com.learningcourse.converter

import com.learningcourse.dto.test.FrontTestDto
import com.learningcourse.entity.TestEntity

fun TestEntity.toTestFrontDto() = FrontTestDto().also { it.content = this.content }