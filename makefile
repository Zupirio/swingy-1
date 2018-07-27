all: maven

console: maven
	java -jar target/swingy-1.0-SNAPSHOT.jar console
	
gui: maven
	java -jar target/swingy-1.0-SNAPSHOT.jar console

maven:
	mvn compile
	mvn package

git: origin alt

origin:
	git push origin master

alt:
	git push alt master

clean:

fclean: clean
	rm -Rf target/*

re: fclean all