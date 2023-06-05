package com.learningcourse.entity

import javax.persistence.*

@Entity
@Table(name = "test")
@SequenceGenerator(name = "pk_generator_test_entity", sequenceName = "test_pk_seq")
open class TestEntity(
    @ManyToOne
    @JoinColumn(name = "test_course", nullable = false, updatable = false)
    open val testCourse: CourseEntity
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_generator_test_entity")
    @Column(name = "id", updatable = false)
    open var id: Long? = null

    @Lob
    @Column
    open var content: String? = null
}