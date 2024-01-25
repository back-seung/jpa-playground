## 7.2 @MappedSuperclass

### 개념

> #### 부모 클래스를 테이블과 매핑하지 않고, 부모 클래스를 상속받는 자식 클래스에게 매핑 정보만 제공하고 싶을 때 사용
> #### 테이블과는 관계가 없고, 엔티티가 공통으로 사용하는 매핑 정보를 모아주는 역할을 수행

- 지금까지 학습한 상속 관계 매핑은 부모 클래스와 자식 클래스를 모두 데이터베이스 테이블과 매핑
- 등록일, 수정일처럼 여러 엔티티에서 공통으로 사용하는 매핑 정보만 상속할 때 사용
- **추상 클래스(abstract class)**와 비슷한 개념
  - @Entity : 실제 데이터베이스에 존재하는 테이블과 매핑
  - @MappedSuperClass : 실제 테이블과 매핑 X, 매핑 정보 상속에만 사용

![](https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F68ec7836-8821-4ee5-b973-6364ef1bf3f5%2F_2020-06-16__9.38.17.png&blockId=c2a31f4b-863b-4761-8876-9848b9d22b85)

### @MappedSuperclass 정리

- 테이블과 매핑되지 않고, 자식 클래스에 엔티티의 매핑 정보를 상속하기 위해 사용
- @MappedSuperclass로 지정한 클래스는 엔티티가 아니므로 en.find()나 JPQL에서 사용할 수 없다.
- 이 클래스를 직접 생성해서 사용할 일은 거의 없으므로, 추상 클래스로 만드는 것이 좋다.
