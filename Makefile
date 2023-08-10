SRCS =  $(shell find ./avaj_launcher -type f -name '*.java')

OBJS = $(SRCS:.java=.class)

PWD = $(shell pwd)

all: 
	javac $(SRCS)
	@echo "avaj_launcher"
	java avaj_launcher.Simulation.Simulation scenario.txt
clean:
	rm -rf $(OBJS)
	
fclean:	clean

re: fclean all