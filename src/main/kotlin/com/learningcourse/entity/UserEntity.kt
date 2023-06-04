package com.learningcourse.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user")
open class UserEntity(
    @Column(name = "user_name")
    open val name: String, //имя
    @Column(name = "user_lastname")
    open val lastName: String, // фамилия
    @Column(name = "user_email")
    open val email: String, // mail клиента
    @Column(name = "user_password")
    open val password: String, // пароль
    @Column(name = "user_birthdate")
    open val birthdate: LocalDate // дата рождения
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    open var id: Long? = null

    /**
     * Курсы, на которые записан
     */
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "user_course",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    open var courses: MutableSet<CourseEntity> = mutableSetOf()
}