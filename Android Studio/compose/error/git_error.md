https://sjuu.tistory.com/89

여러 블로그에서 소개하듯, file - setting - versionControl 에서 git 연동을 끊으면 된다고 적혀있는데, giraffe 버전으로 업그레이드 하면서 달라졌는지?

결론은 file - setting - versionControl - Directory Mappings 에 git 연동을 끊을 수 있는 페이지가 동일하게 위치하여 있다.

프로젝트에 .git 파일도 숨김처리 되어 있음.

원격 저장소에 google-services.json 파일을 commit & push 하면서 history 지우는 것을 실패해서 private으로 커밋하다가 프로젝트 포트폴리오를 만드는 겸

- - -

결론

public 버전으로 다시 올려보려고 같은 프로젝트의 git 연동을 android studio에서 끊고 로컬 저장소와 원격 저장소를 새로 생성하여 해결하였다.

ps. git의 default branch를 master에서 main으로 변경 하기 https://velog.io/@abc9985/GitHub%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%8A%A4%ED%8A%9C%EB%94%94%EC%98%A4%EC%97%90%EC%84%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0

main -> main (non fast-forward) 문제 해결 (README.md 파일 문제, 프로젝트 안에도 README.md 파일이 있고 원격 저장소에도 있었음)

```git push origin +main```

https://somjang.tistory.com/entry/Git-rejected-master-master-non-fast-forward-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95
