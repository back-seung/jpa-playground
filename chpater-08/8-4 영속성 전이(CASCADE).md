## 8.4 영속성 전이: CASCADE

### 8.4.1 개념
> #### 특정 엔티티를 영속 상태로 만들 때 연관된 엔티티 또한 영속상태로 만드는 것

- 부모 엔티티를 영속 상태로 만들 때, 자식 엔티티 또한 영속 상태로 만든다.
    - 부모 엔티티를 영속성 컨텍스트에서 제거(remove)하려면, 자식 엔티티도 영속성 컨텍스트에서 제거해야 한다.

- JPA에서 엔티티를 저장할 때, 연관된 모든 엔티티는 영속 상태여야 한다.
    - JPA는 CASCADE 옵션으로 영속성 전이를 제공한다.

![영속성 전이](https://mblogthumb-phinf.pstatic.net/MjAyMjAzMThfMjkz/MDAxNjQ3NjAxMTgxMDg2.2m0Hmon_YemSslOOv4cdmKCF-Dejg2VKpAEDnHNfjC0g.PU4n7CtSFj3E5u6ZZakqK-CApLuR-6sqwxWwuL5bVpwg.PNG.fbfbf1/image.png?type=w800)

### 8.4.2 영속성 전이: 저장

> #### 자바: @OneToMany(mappedBy = "	", cascade = CascadeType.PERSIST)
> #### 코틀린: @OneToMany(mappedBy = "	", cascade = [CascadeType.PERSIST])

- 영속성 전이를 사용하지 않을 경우 : 부모 엔티티와 자식 엔티티 모두를 각각 영속 상태로 등록한다.

- 영속성 전이를 사용할 경우 : JPA는 CascadeType.PERSIST 옵션을 사용하면, 부모 엔티티가 영속 상태가 되었을 때 자식 엔티티까지 함께 영속화를 해준다.

![영속성 전이](https://mblogthumb-phinf.pstatic.net/MjAyMjAzMThfMjAz/MDAxNjQ3NjAxMjM5MDIz.Te2ZsAkNLYIm3Cg2ajs8yyl-bpk1ve6TKO5JyEipEqcg.ku_BRjdXwt6s0YjKAZDRyLIHxz3G0Bln0AfDjbARf_0g.PNG.fbfbf1/image.png?type=w800)

### 8.4.3 영속성 전이: 삭제
> ### 부모 엔티티가 삭제되었을 때만 자식 엔티티를 삭제하고, 부모와 자식의 연관관계가 끊어졌을 때는 자식 엔티티를 삭제하지 않는다.
> #### 자바: @OneToMany(mappedBy = "	", cascade = CascadeType.REMOVE)
> #### 코틀린: @OneToMany(mappedBy = "	", cascade = [CascadeType.REMOVE])

- 영속성 전이를 사용하지 않을 경우 : 부모 엔티티와 자식 엔티티를 각각 영속성 컨텍스트에서 제거해야한다.

- 영속성 전이를 사용할 경우 : JPA는 CascadeType.REMOVE 옵셥을 사용하면, 부모 엔티티가 영속성 컨텍스트에서 제거되었을 때(=DB에서 제거되었을 때) 자식 엔티티도 함께 삭제된다.

    - 삭제 순서는 자식 엔티티를 먼저 삭제하고, 부모 엔티티를 나중에 삭제한다.

        - 부모를 먼저 삭제해버리면, 외래 키를 이용해 자식 엔티티에 접근할 수 없으므로 데이터베이스에서 무결성 예외가 발생한다.

### 8.4.4 CASCADE 종류

> #### 자바: @OneToMany(mappedBy = "	", cascade = {CascadeType.REMOVE, CascadeType.REMOVE, ...})
> #### 코틀린: @OneToMany(mappedBy = "	", cascade = [CascadeType.REMOVE, CascadeType.REMOVE, ...])

|옵션|설명|
|:--:|:--:|
|ALL|모든 CASCADE를 적용|
|PERSIST|엔티티를 영속 상태로 만들 때 연관된 엔티티도 전부 영속 상태로 만든다.|
|REMOVE|엔티티를 영속성 컨텍스트에서 제거할 때(remove), 연관된 엔티티도 전부 제거한다.|
|DETACH|엔티티를 영속성 컨텍스트에서 분리할 때, 연관된 엔티티도 전부 분리한다.|
|MERGE|준영속 상태인 엔티티를 다시 영속 상태로 병합할 때, 연관된 엔티티도 병합한다.|
|REFRESH|상위 엔티티를 새로고침할 때, 연관된 엔티티도 전부 새로고침한다.|
