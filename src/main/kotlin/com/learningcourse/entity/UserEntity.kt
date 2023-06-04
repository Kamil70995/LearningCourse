package com.learningcourse.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user_client")
open class UserEntity(
    @Column(name = "client_name")
    open val name: String, //имя
    @Column(name = "client_lastname")
    open val lastName: String, // фамилия
    @Column(name = "client_email")
    open val email: String, // mail клиента
    @Column(name = "client_password")
    open val password: String, // пароль
    @Column(name = "client_birthdate")
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