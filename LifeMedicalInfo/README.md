# 생활정보의료앱

## java 파일 구조도

화면과 기능에 따라 구조화하였습니다.

- domain
  - entity
  - gps
  - repsository
    - 공공데이터와 연동하여 저장합니다.
- ui
  - repo안에 있는 데이터를 실질적으로 xml과 연동하여 안드로이드 앱의 UI를 변경합니다.
- main
  - 전체적인 UI관리, 타 폴더에 있는 메소드들을 호출합니다.
- sign
  - 로그인/회원가입에 필요한 로직을 분리하였습니다.
- Splash
  - 앱 처음 시작을 담당합니다.