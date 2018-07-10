all:

maven:

run:

git: origin alt

origin:
	git push origin master

alt:
	git push alt master

clean:
	rm *.class

fclean: clean

re: fclean all