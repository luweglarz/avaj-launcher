OBJS = $(shell find ./avaj_launcher -type f -name '*.class' | sed 's/[$\"]/\\&/g')

all: 
	find * -name "*.java" > sources.txt
	javac @sources.txt

start:
	java avaj_launcher.Simulation.Simulation scenario.txt

clean:
	rm -rf $(OBJS)
	rm -rf sources.txt
	
fclean:	clean

re: fclean all