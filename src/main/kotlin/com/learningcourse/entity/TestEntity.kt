package com.learningcourse.entity

import javax.persistence.*

@Entity
@Table(name = "test")
open class TestEntity(
    @ManyToOne
    @JoinColumn(name = "test_course", nullable = false, updatable = false)
    open val testCourse: CourseEntity
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    open var id: Long? = null

    @Lob
    @Column
    open var content: String? = null
}