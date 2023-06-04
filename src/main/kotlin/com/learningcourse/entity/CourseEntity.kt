package com.learningcourse.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "course")
@SequenceGenerator(name = "pk_generator_course_entity", sequenceName = "course_pk_seq")
open class CourseEntity(

    @Column(name = "course_title", updatable = false)
    open val courseTitle: String, // название курса

    @Column(name = "upload_date", updatable = false)
    open val courseUploadDate: LocalDate, // дата загрузки курса

    /**
     * Автор курса
     */
    @ManyToOne
    @JoinColumn(name = "course_author", nullable = false, updatable = false)
    open val courseAuthor: AuthorEntity,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_generator_course_entity")
    @Column(name = "id", updatable = false)
    open var id: Long? = null

    /**
     * Контент, который в этом курсе
     */
    @Lob
    @Column(name = "content")
    open var content: String? = null

    /**
     * Пользователи, записанные на курс
     */
    @ManyToMany(mappedBy = "courses")
    open var user: MutableList<UserEntity> = mutableListOf()

    /**
     * Тесты, которые есть в этом курсе.
     */
    @OneToMany(mappedBy = "testCourse", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    open var tests: MutableList<TestEntity> = mutableListOf()
}