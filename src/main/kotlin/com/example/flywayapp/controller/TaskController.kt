package com.example.flywayapp.controller

import com.example.flywayapp.entity.Task
import com.example.flywayapp.repository.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class TaskRequest(
    val name: String,
    val type: String
)

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskRepository: TaskRepository
) {

    @PostMapping
    fun create(@RequestBody request: TaskRequest): ResponseEntity<Task> {
        val task = Task(
            name = request.name,
            type = request.type
        )
        val saved = taskRepository.save(task)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Task>> {
        val tasks = taskRepository.findAll()
        return ResponseEntity.ok(tasks)
    }
}
