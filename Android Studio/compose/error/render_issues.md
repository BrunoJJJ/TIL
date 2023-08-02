### preview Render issues → chatGPT 답변 중 오늘 설치했기 때문에 버전 문제 제외한 4번을 통해 해결

1. Gradle 버전 확인: Android Studio와 프로젝트의 Gradle 버전이 호환되는지 확인해야 합니다. 렌더링 문제가 발생하는 경우, Android Gradle Plugin 버전이나 Kotlin 버전을 업데이트하여 호환성을 확인해 보세요.

2. Compose 버전 확인: Compose 버전이 최신인지 확인하고 업데이트가 필요한 경우 업데이트를 진행해야 합니다. Jetpack Compose는 계속해서 개선되고 업데이트되므로, 최신 버전을 사용하는 것이 좋습니다.

3. 렌더링 문제가 있는 Composable 함수 검토: **`@Preview`** 애노테이션을 사용하는 Composable 함수에서 문제가 발생할 수 있습니다. 해당 함수의 내용을 검토하고, 잠재적인 문제를 해결해야 합니다. 불필요한 코드, 잘못된 구성, 충돌하는 속성 등을 확인해보세요.

4. Invalidate Caches/Restart: Android Studio에서 "File" 메뉴에서 "Invalidate Caches/Restart"를 선택하여 캐시를 초기화하고 재시작하는 것도 도움이 될 수 있습니다.

5. 시스템 리소스 재로딩: Android Studio에서 "File" 메뉴에서 "Sync Project with Gradle Files"를 선택하여 시스템 리소스를 다시로드할 수 있습니다.

6. 테마 및 스타일 확인: Composable 함수에서 사용하는 테마나 스타일이 올바르게 설정되었는지 확인해야 합니다. 테마나 스타일 설정이 잘못된 경우 렌더링 문제가 발생할 수 있습니다.

7. 에뮬레이터 또는 디바이스 재부팅: 때로는 에뮬레이터나 디바이스를 재부팅하여 렌더링 문제를 해결할 수 있습니다.

preview이기 때문에 너무 많은 코드나 이미지 파일들에서 issue 가능
