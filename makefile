PLUGIN=$(shell basename `pwd`)
PROJ_ROOT=$(shell dirname `pwd`)
OBJ_DIR=bin
SRC_DIR=src
BUKKIT_API=$(PROJ_ROOT)/server/craftbukkit-1.2.5-R4.0.jar
JAR=$(PLUGIN).jar

include sources.mk

SRCS_FULL=$(addprefix $(SRC_DIR)/,$(SRCS))

JAVACFLAGS = -d $(OBJ_DIR) -cp $(BUKKIT_API)

$(JAR): $(SRCS_FULL)
	mkdir -p $(OBJ_DIR)
	javac $(JAVACFLAGS) $(SRCS_FULL)
	cp plugin.yml $(OBJ_DIR)
	cd $(OBJ_DIR) && jar cvf $(PROJ_ROOT)/server/plugins/$(JAR) *

clean:
	rm -rf bin
