#include <stdio.h>

int main(int argc, char* argv[]) {
	if (argc < 2) {
		fprintf(stderr, "usage: %s arg1 arg2 ... argn\n", argv[0]);
		return -1;
	}
	
	int i;
	for (i = 0; i < argc; i++) {
		printf("%i - argv[%i] = %s\n", i, i, argv[i]);
	}
	return 0;
}
