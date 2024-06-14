package learn.spring.boot.tutorial.configuration;


import learn.spring.boot.tutorial.DB;
import learn.spring.boot.tutorial.DevDb;
import learn.spring.boot.tutorial.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode" , havingValue = "development")
    public DB getDevBean(){
        return new DevDb();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode" , havingValue = "production")
    public DB geProdDBBean(){
        return new ProdDB();
    }


    @Bean
    public ModelMapper getModelMapper(){
        return  new ModelMapper();
    }
}
