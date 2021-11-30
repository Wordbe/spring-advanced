package co.wordbe.advanced.app.proxy.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping // 스프링은 @Controller 또는 @RequestMapping 이 있어야 스프링 컨트롤러로 인식한다.
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/orders")
    String order(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
