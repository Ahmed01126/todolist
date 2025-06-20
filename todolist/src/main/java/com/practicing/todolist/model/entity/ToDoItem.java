//package com.practicing.todolist.model.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.UUID;
//
//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "todo_items")
//public class ToDoItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "uuid", updatable = false, nullable = false)
//    private UUID id;
//
//    @Column(nullable = false)
//    private String title;
//
//    private String description;
//
//    @Column(nullable = false)
//    private boolean completed;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "uuid")
//    private User user;
//
//}
