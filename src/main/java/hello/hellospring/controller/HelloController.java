package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //url뒤에 붙는 값인거 같음
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // 이 return은 hello.html을 실행시켜라는거임 위의 데이터를 가지고 !
        //viewResolver가 화면을 찾아서 처리하는데 templates/{VewName}+.html 찾는거같음
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    //Body부에 이 데이터를 직접 넣을 것이다 그대루!
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; //name이 spring 이면 "hello spring" view가없음
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        //객체 반환이 됐네! 기본으로는 json방식으로 데이터를 만들어서 반환
    }

    static class Hello {
          private String name;

          public String getName(){
              return name;
          }

          public void setName(String name){
              this.name = name;
          }
            }
}
