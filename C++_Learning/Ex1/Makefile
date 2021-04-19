all: compile run_tests run_main clean

compile:
	@g++ -o int_tests MyLinkedListIntTests.cpp MyLinkedListInt.cpp -lgtest -lpthread
	@g++ -o template_tests MyLinkedListTemplateTests.cpp MyLinkedList.h -lgtest -lpthread
	@g++ -o main Ex1.cpp MyLinkedListInt.cpp
run_tests:
	@echo "Running tests:"
	@./int_tests
	@echo
	@./template_tests
run_main:
	@echo
	@echo "Running main:"
	@./main
clean:
	@rm -f int_tests
	@rm -f template_tests
	@rm -f main
