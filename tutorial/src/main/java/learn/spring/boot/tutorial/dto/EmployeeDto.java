package learn.spring.boot.tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

   private Long id;
   private  String name;
   private LocalDate dateOfJoining;
   private  boolean isActive;



}
