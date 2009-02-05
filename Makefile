#********************************************************************
# Copyright 2008 Adam Kiezun, Vijay Ganesh
#********************************************************************
# AUTHORS: Adam Kiezun, Vijay Ganesh
#
# BEGIN DATE: October/November 2008
#
# This file belongs to the Hampi string solver project (solver for
# equations over regular expressions)
# 
# LICENSE: Please view LICENSE file in the home dir of this Program
#********************************************************************

all:
	./configure
	$(MAKE) -C lib all
	ant

translate-perftests:
	$(MAKE) -C slow-tests cfganalyzer-tests

run-perftests:
	$(MAKE) -C slow-tests

create-perftest-gold:
	$(MAKE) -C slow-tests create-perftest-gold

clean:
	ant clean
	$(MAKE) -C lib clean
	rm -rf *~
	rm -rf *.sh

verify:
	$(MAKE) -C lib teststp
	ant -lib lib -verbose AllTests