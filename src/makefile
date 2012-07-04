JC = javac
FLAGS = -d ../bin/

default : _ctrl _model _figure _frame _junit

_ctrl :
	$(JC) $(FLAGS) jmodel/ctrl/*.java

_model :
	$(JC) $(FLAGS) jmodel/model/*.java

_figure :
	$(JC) $(FLAGS) jmodel/figure/*.java

_frame :
	$(JC) $(FLAGS) jmodel/frame/*.java

_junit :
	$(JC) $(FLAGS) junit/*.java

.PHONY : clean
clean :
	-rm -r ../bin/*

