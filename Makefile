SRCS =  $(shell find ./avaj_launcher -type f -name '*.java')

OBJS = $(SRCS:.java=.class)

PWD = $(shell pwd)

all: 
	javac $(SRCS)
	@echo "avaj_launcer"
	
clean:
	rm -rf $(OBJS)
	
fclean:	clean

re: fclean all