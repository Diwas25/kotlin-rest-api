package com.springbootkotin.tutorial.kotlinrestapi.controller


import com.springbootkotin.tutorial.kotlinrestapi.pojo.Student
import com.springbootkotin.tutorial.kotlinrestapi.repository.StudentsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class StudentController {
        @Autowired
        val studentsRepo = StudentsRepo()

        @GetMapping("/hello")
        fun sayHello(): String{
            val items = listOf("apple","banana","Kiwifruit");
            return "Spring Boot Rest API Example"
        }
        @GetMapping("/show-fruit")
        fun showFruit(): List<String> {
            val items = listOf("apple", "banana", "Kiwifruit");
            return items
        }

        @PostMapping("/show-name")
        fun addFruit(@RequestBody sname:String): String {
            return "Your name is $sname"
         }
        @GetMapping("/error")
            fun fallBack(): String{
                return "Error Occurred"
        }
        @GetMapping("getallstudents")
        fun getAllStudents(): List<Student>{
            return studentsRepo.retrieveAllStudents()
        }
        @PostMapping("/createStudent")
        fun createNewStudent(@RequestBody student:Student): List<Student>{
            return studentsRepo.addStudent(student)
        }
    @GetMapping("/findstudent/{name}")
    fun retrieveStudentByName(@PathVariable name:String): Student?{
        return studentsRepo.getStudentWithName(name)
    }

    @DeleteMapping("/deletestudent/{name}")
    fun deleteStudent(@PathVariable name:String): List<Student>{
        return studentsRepo.deleteByName(name)
    }
}