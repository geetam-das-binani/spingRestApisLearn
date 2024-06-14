package learn.spring.boot.tutorial.services;

import learn.spring.boot.tutorial.dto.EmployeeDto;
import learn.spring.boot.tutorial.entities.EmployeeEntity;
import learn.spring.boot.tutorial.repositories.EmployeesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {



  final  EmployeesRepository employeesRepository;
  final ModelMapper modelMapper;


    public EmployeeService(EmployeesRepository employeesRepository,ModelMapper modelMapper) {
        this.employeesRepository = employeesRepository;
        this.modelMapper=modelMapper;
    }

    public EmployeeDto getEmployeeById(Long id){

        EmployeeEntity employeeEntity = employeesRepository.getById(id);
//        return  new EmployeeDto(employeeEntity.getId(),employeeEntity.getName(),employeeEntity.getDateOfJoining(),employeeEntity.isActive());

        return modelMapper.map(employeeEntity,EmployeeDto.class);


    }
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto){

        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);

       return modelMapper.map(employeesRepository.save(employeeEntity),EmployeeDto.class);

    }

    public List<EmployeeDto> getAllEmployees(){
        return  employeesRepository.findAll().stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class))
                .collect(Collectors.toList());

// *   List<EmployeeDto> list=new ArrayList<EmployeeDto>();
// *  for(EmployeeEntity employeeEntity: employeesRepository.findAll()){
//*   EmployeeDto map= modelMapper.map(employeeEntity,EmployeeDto.class);
// *  list.add(map);
// *}
// * return  list;
    }

    public boolean deleteEmployeeById(Long id){
        try{
          boolean isPresent=employeesRepository.existsById(id);
          if(!isPresent) return  false;
          employeesRepository.deleteById(id);
        return  true;

        }
        catch (NullPointerException e){
            return  false;
        }
    }

}
