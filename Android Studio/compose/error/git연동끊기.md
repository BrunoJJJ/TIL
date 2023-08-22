https://sjuu.tistory.com/89

여러 블로그에서 소개하듯, file - setting - versionControl 에서 git 연동을 끊으면 된다고 적혀있는데, giraffe 버전으로 업그레이드 하면서 달라졌는지?

결론은 file - setting - versionControl - Directory Mappings 에 git 연동을 끊을 수 있는 페이지가 동일하게 위치하여 있다.

프로젝트에 .git 파일도 숨김처리 되어 있음.

원격 저장소에 google-services.json 파일을 commit & push 하면서 history 지우는 것을 실패해서 private으로 커밋하다가 프로젝트 포트폴리오를 만드는 겸

- - -

결론

public 버전으로 다시 올려보려고 같은 프로젝트의 git 연동을 android studio에서 끊고 로컬 저장소와 원격 저장소를 새로 생성하여 해결하였다.
