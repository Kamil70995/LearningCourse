package com.learningcourse.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "author")
@SequenceGenerator(name = "pk_generator_author_entity", sequenceName = "author_pk_seq")
open class AuthorEntity(

    @Column(name = "author_name")
    open val name: String, //имя

    @Column(name = "author_lastname")
    open val lastName: String, // фамилия

    @Column(name = "author_email")
    open val email: String, // mail автора

    @Column(name = "author_password")
    open val password: String, // пароль

    @Column(name = "author_birthdate")
    open val birthdate: LocalDate // дата рождения
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_generator_author_entity")
    @Column(name = "id", updatable = false)
    open var id: Long? = null

    /**
     * Курсы, созданные автором
     */
    @OneToMany(mappedBy = "courseAuthor", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    open var courses: MutableList<CourseEntity> = mutableListOf()
}