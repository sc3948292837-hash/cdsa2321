#!/usr/bin/env bash
set -euo pipefail

GRADLE_VERSION="${GRADLE_VERSION:-8.10.2}"
CACHE_ROOT="${HOME}/.gradle/manual-dists"
GRADLE_HOME="${CACHE_ROOT}/gradle-${GRADLE_VERSION}"
GRADLE_BIN="${GRADLE_HOME}/bin/gradle"

if [ ! -x "${GRADLE_BIN}" ]; then
  echo "Gradle ${GRADLE_VERSION} not found. Downloading..."
  mkdir -p "${CACHE_ROOT}"
  ZIP_FILE="${CACHE_ROOT}/gradle-${GRADLE_VERSION}-bin.zip"
  curl -L --retry 3 --retry-delay 5 -o "${ZIP_FILE}" "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
  rm -rf "${GRADLE_HOME}"
  unzip -q "${ZIP_FILE}" -d "${CACHE_ROOT}"
fi

exec "${GRADLE_BIN}" "$@"
