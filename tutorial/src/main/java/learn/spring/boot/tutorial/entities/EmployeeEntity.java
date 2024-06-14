package learn.spring.boot.tutorial.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //* This annotation specifies that the class is an entity and is mapped to a database table.
//* Entities enable the mapping of Java objects to database tables, allowing for seamless interaction with the database using Java objects.
//* With entities, developers can perform CRUD (Create, Read, Update, Delete) operations using high-level, object-oriented constructs rather than low-level SQL queries. This simplifies data manipulation and improves code readability and maintainability.
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private  boolean isActive;
    public boolean isActive() {
        return isActive;
    }

    // Explicit setter for isActive
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
