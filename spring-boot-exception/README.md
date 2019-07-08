# SpringBoot Exception
> SpringBoot 异常处理

## 处理 HTTP 错误
在 Java Web 开发中，如果服务端产生 HTTP 错误，如 403、404、500 等等，Spring Boot 把错误信息默认映射到`/error`上，所以我们只需要编写`/error`控制器的代码，就可以做到对错误的处理。  
首先创建一个实现了 ErrorController 接口的 Controller，然后重写`getErrorPath()`方法，方法返回`/error`，最后自己写一个处理`/error`的`RequestMapping`处理错误信息就行了。
```java
@RestController
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity error(HttpServletResponse response) {
        int statusCode = response.getStatus();
        return ResponseEntity
                .status(statusCode)
                .body(HttpStatus.valueOf(statusCode).getReasonPhrase());
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
```
tips: 也可以直接写一个 Controller 处理 `/error`

## 处理Java异常
当后端抛出未处理的异常后，会产生 HTTP 500 错误，如果不单独处理的话，会直接被`/error`处理。
如果需要单独处理Java异常，新建一个类写上`@ControllerAdvice`或者`@RestControllerAdvice`注解，表示这是一个处理Java异常的类。在这个类中，标注了`@ExceptionHandler`的方法就是处理异常的方法。
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理抛出的 Exception.class 异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Exception Handler.");
    }

}
```