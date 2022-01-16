# Brainfuckインタプリタ
![CI with Gradle](https://github.com/e215714/prog2-report6/actions/workflows/gradle.yml/badge.svg)
![Java version](https://img.shields.io/badge/Java-v16.0.2-B07219.svg?logo=java)
![Java version](https://img.shields.io/badge/Gradle-v7.2-006245.svg?logo=Gradle)

  prog2-report6で作成した、Javaで実装されたBrainfuckインタプリタ。

### 機能
  - Brainfuckのコードが書かれたファイルから結果を出力する。
  - インタラクティブモードからコードを入力して実行できる。

## 実行確認済み環境
  - macOS 11.4(Big Sur) M1
    - Java 16.0.2
  - macOS 12.1(Monterey) M1
    - Java 16.0.2
  - Ubuntu 20.04.3 LTS (Release:20.04, focal)
    - Java 16.0.1

prog2の授業では[VSCodeの環境構築](https://github.com/naltoma/java_intro2020/blob/master/VSCode-env.md)でインストールしたOpenJDK 16を使用しているため、build.gradle内で`sourceCompatibility = 16`としていますが、それ以外のバージョンでも動作できると思います。

## build方法(jarファイルの生成)
  ```
  ./gradlew build
  ```
  
  `app/build/libs/BfInterpreter.jar`が生成されます。

## 使い方

### ファイルを読み込んで出力

```
java -jar BfInterpreter.jar [filename]
```

### インタラクティブモードの起動
```
java -jar BfInterpreter.jar
```

## コントリビューター
  - Taiga Ogawa ([@e215714](https://github.com/e215714))
  - Taisei Maetake ([@e215703](https://github.com/e215703))
