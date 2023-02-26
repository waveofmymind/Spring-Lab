# 리플렉션 API

- 힙 영역에 로드되어 있는 클래스 타입의 객체를 통해 필드/ 메소드/ 생성자를 접근 제어자와 상관없이 사용할 수 있도록 지원하는 API
- 런타임 시점에 동적으로 클래스 타입의 정보를 추출해낼 수 있는 프로그래밍 기법

## 적용 과제

> @Controller 애노테이션이 붙은 클래스 모두 출력하기

## 기록

- Reflections reflections = new Reflections("org.example");
        
        -> org.example 내에 있는 클래스 탐색
        
- reflections.getTypesAnnotatedWith(Controller.class) 

        -> 해당 애노테이션이 붙은 대상 찾기
        
### 힙 영역에 있는 클래스 객체 꺼내오는 방법

```
//1
Class<User> clazz = User.class;

//2
User user = new User("waveofmymind","전상준");
Class<? extends User> clazz2 = user.getClass();

//3
Class<?> clazz3 = Class.forName("org.example.User");
```
