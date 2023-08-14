SRCS =  $(shell find ./avaj_launcher -type f -name '*.java')

OBJS = $(SRCS:.java=.class)

PWD = $(shell pwd)

all: 
	find * -name "*.java" > sources.txt
	javac @sources.txt
	java avaj_launcher.Simulation.Simulation scenario.txt
clean:
	rm -rf $(OBJS)
	rm -rf sources.txt
	
fclean:	clean

re: fclean all