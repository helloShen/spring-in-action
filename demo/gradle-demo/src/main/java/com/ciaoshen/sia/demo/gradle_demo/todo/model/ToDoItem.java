package com.ciaoshen.sia.demo.gradle_demo.todo.model;

public class ToDoItem implements Comparable<ToDoItem> {
    private Long id;
    private String name;
    private boolean completed;

    /* InMemoryToDoRepository will set id before inserting items */
    public ToDoItem(String name) {
        this.name = name;
        this.completed = false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getCompleted() {
        return completed;
    }

    public int compareTo(ToDoItem item) {
        return (int) (this.id - item.id);
    }

    public String toString() {
        return "Item[" + id + "]:\t" + name + "\n";
    }
}