@echo off
REM Windows helper. For cloud build GitHub uses ./gradlew on Linux.
REM If you build locally on Windows, install Android Studio/Gradle or use Git Bash.
echo This project is configured for GitHub Actions cloud build.
echo Use GitHub Actions or run gradle assembleDebug if Gradle is installed.
exit /b 1
