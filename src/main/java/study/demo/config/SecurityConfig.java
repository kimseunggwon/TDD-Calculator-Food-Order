package study.demo.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;


// @EnableWebSecurity
// TODO : 연습모드
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
