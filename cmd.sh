find * -name "*.java" > sources.txt

javac @sources.txt

java -cp ./src/main/java org.launcher.Avaj scenario.txt
