## 🌱 TIL - Today I Learned

### 2024.09.03
자바로 백엔드를 개발하다가 요즘 채용공고를 둘러보면서 코틀린+자바+스프링을 함께 테크스택으로 가지는 회사들이 많다고 느꼈다. 그래서 이참에 코틀린+스프링으로 간단한 블로그 페이지를 개발해보기로 했다.  

오늘은 프로젝트를 생성하고 JPA 엔티티를 Kotlin으로 구현해 봤는데 Spring Data JPA와 Kotlin의 궁합이 살짝 좋지는 않다고 느껴졌다.
자바로 했을 때는 롬복을 사용해서 @Getter, @Setter를 만들어줬는데 자바의 set은 캡슐화를 통해서 내부 인스턴스를 private 하게 관리를 한다. (엔티티의 set() 사용은 거의 금지되긴하지만..)  

근데 코틀린은 이 get, set을 변수만 생성해도 자동으로 생성하는거로 알고 있다. 기본적인 접근제한자는 public 으로 선언이 된다. 그치만 내가 원하는 건 set()은 private 으로 막아둬야하는데.. 난 이부분이 좀 JPA와 fit이 맞지 않게 느껴졌다.

인프랩의 개발 블로그를 봤는데 Java와 Kotlin을 혼용해서 사용하고 있었다. Java는 Null safety의 부재가 가장 큰 골칫거리였다고 한다. (이건 나도 느꼈다. 코틀린을 학교에서 배우면서 Null safety한 개발이 가능하다는게 가장 놀라웠다)
Java를 사용하다 보면 만나는 NullPointException은 자주 따라다니는 에러인데, NullPointException은 흔히 “10억 달러의 실수” 라고 하는 Null을 참조하려고 할 때 생기는 흔히 많이 접해봤을 에러이다.
*(사실 IDE의 도움을 받아 Optinal 클래스를 사용해서 Null safety하게 개발을 할 수 있긴 하다.)*

스프링 생태계는 Java를 기준으로 하고 있고, JPA도 이름에서 나와 있듯이 Java Persistence API, Java를 기준으로 나온 표준이다. 그렇다보니 JPA와 궁합이 좋지 않은게 나만 느끼는게 아니였나보다.
open 키워드를 사용하지 않는 한 모든 클래스가 기본적으로 final이다. 반면 JPA는 엔티티를 선언할 때 final 키워드를 사용하지 않도록 요구한다. 변경감지, 지연 로딩 등 런타임에 언제든지 변경될 수 있는 상태를 가지는게 자연스러운 현상이기 때문이다.

가장 번거로운 것은 Private Setter 설정이였다. 프로퍼티 선언마다 var로 선언하고, protected set을 해줘야한다... 보통 Java를 Kotlin으로 바꿀 때 이전보다 더 간결해지는 경우가 많은데, 이 경우는 오히려 행사 코드가 늘어나는것 같다.  

정리하면 각 언어 마다 장단점이 있는 것 같다.
- **Java**
  - JPA와의 궁합이 좋음
  - Null safety 지원 미흡
  - 비교적 편의 문법 미지원
  - QueryDSL 설정이 조금 복잡
- **Kotlin**
  - JPA와의 궁합이 좋지 않음
  - Null safety 지원
  - 편의 문법 지원
  - QueryDSL 설정이 복잡
  
느낀점은 **JPA 엔티티 설정은 Java로, 그 외 로직은 Kotlin으로 개발하는 것이 가장 현명한 것 같다(마치 Spring Data JPA 와 QueryDSL을 함께 사용하는 것처럼)**
