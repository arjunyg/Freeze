PLUGIN=$(shell basename `pwd`)
OBJ_DIR=bin
SRC_DIR=src
BUKKIT_API=lib/bukkit.jar
JAR=$(PLUGIN).jar

include sources.mk

SRCS_FULL=$(addprefix $(SRC_DIR)/,$(SRCS))

JAVACFLAGS = -d $(OBJ_DIR) -cp $(BUKKIT_API)

$(JAR): clean 
	mkdir -p $(OBJ_DIR)
	javac $(JAVACFLAGS) $(SRCS_FULL)
	cp plugin.yml $(OBJ_DIR)
	cd $(OBJ_DIR) && jar cvf $(JAR) *

clean:
	rm -rf bin
