package restful.demo.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import restful.demo.mapper.TestMapper;
import restful.demo.mapper.TestRepository;
import restful.demo.service.TestService;
import restful.demo.service.TestServiceImpl;

import javax.management.MXBean;


// @EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig  {

    //private final TestMapper testMapper;

   /* protected void configure(HttpSecurity http) throws Exception{

        //모든 경로 매칭 허용
        http.authorizeHttpRequests()
                .anyRequest().permitAll();
    }*/

  /* @Bean
    public TestMapper testMapper() {
       return new TestRepository(testMapper);
   }*/


}
