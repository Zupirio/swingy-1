all: maven

console: fclean maven
	java -jar target/swingy-1.0-SNAPSHOT.jar console
	
gui: fclean maven
	java -jar target/swingy-1.0-SNAPSHOT.jar gui

maven:
	clear
	mvn clean package

git: origin alt

origin:
	git push origin master

alt:
	git push alt master

clean:
	rm -Rf .settings
	rm -Rf .classpath
	rm -Rf .project
	rm -Rf .DS_Store
	rm -Rf bin

fclean: clean
	mvn clean

re: fclean all