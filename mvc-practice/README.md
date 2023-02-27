# FrontController 패턴

- 요청을 하나의 핸들러가 받아서 처리하는 패턴

- 스프링의 DispatcherServlet

## Forward vs Redirect

### Forward

- 서블릿에서 다른 웹 브라우저를 거치지 않고 다른 서블릿에게 요청하는 방식
- Url이 변경되지 않는다.
- HttpRequestServlet,HttpResponseServlet 객체가 공유된다.

### Redirect

- 클라이언트의 웹 브라우저를 다시 거쳐 다른 서블릿에게 요청하는 방식
- Url이 변경된다.
- HttpRequestServlet,HttpResponseServlet 객체가 새로 생성된다.
